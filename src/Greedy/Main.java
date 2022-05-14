package Greedy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import Greedy.Grafo;
import Greedy.GrafoDirigido;

public class Main {

	public static void main(String[] args) {
		HashMap<Integer, Integer> monedas = new HashMap<Integer, Integer>();
		monedas.put(100, 40);
		monedas.put(25, 40);
		monedas.put(10, 40);
		monedas.put(5, 40);
		monedas.put(1, 40);
		Cajero caja = new Cajero(monedas);
		System.out.println(caja.dar(289));

		
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		elementos.add(new Elemento(10,20)); //peso, valor
		elementos.add(new Elemento(20,30));
		elementos.add(new Elemento(30,66));
		elementos.add(new Elemento(40,40));
		elementos.add(new Elemento(50,60));
		
		Mochila m = new Mochila(100);
		m.llenar(elementos);
		System.out.println("Contenido de la mochila: "+ m.getContenido());
		
		ArrayList<Elemento> elementos2 = new ArrayList<Elemento>();
		elementos2.add(new Elemento(18,25)); //peso, valor
		elementos2.add(new Elemento(15,24));
		elementos2.add(new Elemento(10,15));
		
		Mochila m2 = new Mochila(20);
		m2.llenar(elementos);
		System.out.println("Contenido de la mochila: "+ m2.getContenido());
		
		//todo los nros que empiezan en 0 java los lee como formato octal
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		actividades.add(new Actividad(LocalTime.of(0, 1), LocalTime.of(3, 0)));
		actividades.add(new Actividad(LocalTime.of(4, 0), LocalTime.of(6, 0)));
		actividades.add(new Actividad(LocalTime.of(2, 0), LocalTime.of(11, 0)));
		actividades.add(new Actividad(LocalTime.of(1, 0), LocalTime.of(9, 0)));
		actividades.add(new Actividad(LocalTime.of(8, 0), LocalTime.of(15, 0)));
		actividades.add(new Actividad(LocalTime.of(13, 0), LocalTime.of(18, 0)));

		Calendario ca = new Calendario(actividades);
		System.out.println("actividades: " + ca.actividadesCompatibles());

		GrafoDirigido<Integer> dijkstra = new GrafoDirigido<Integer>();
		dijkstra.agregarVertice(1);
		dijkstra.agregarVertice(2);
		dijkstra.agregarVertice(3);
		dijkstra.agregarVertice(4);
		dijkstra.agregarVertice(5);
		
		dijkstra.agregarArco(1, 4, 30);
		dijkstra.agregarArco(1, 2, 10);
		dijkstra.agregarArco(1, 5, 100);
		dijkstra.agregarArco(2, 3, 50);
		dijkstra.agregarArco(3, 5, 10);
		dijkstra.agregarArco(4, 5, 60);
		dijkstra.agregarArco(4, 3, 20);

		Dijkstra<Integer> algoritmo = new Dijkstra<Integer>(dijkstra);
		System.out.println("camino mas corto: " + algoritmo.caminoMasCorto(1));

		GrafoNoDirigido<Ciudad> ciudad = new GrafoNoDirigido<Ciudad>();
		Ciudad c1 = new Ciudad("La Plata");
		c1.setContienePuerto(true);
		Ciudad c2 = new Ciudad("Junin");
		Ciudad c3 = new Ciudad("Tandil");
		Ciudad c4 = new Ciudad("Olavarria");
		Ciudad c5 = new Ciudad("Tres Arrollos");
		Ciudad c6 = new Ciudad("Mar del Plata");
		c6.setContienePuerto(true);
		Ciudad c7 = new Ciudad("Bahia Blanca");
		c7.setContienePuerto(true);
		ciudad.agregarVertice(c1);
		ciudad.agregarVertice(c2);
		ciudad.agregarVertice(c3);
		ciudad.agregarVertice(c4);
		ciudad.agregarVertice(c5);
		ciudad.agregarVertice(c6);
		ciudad.agregarVertice(c7);
		
		ciudad.agregarArco(c2, c1, 321);
		ciudad.agregarArco(c2, c3, 410);
		ciudad.agregarArco(c4, c3, 137);
		ciudad.agregarArco(c3, c6, 321);
		ciudad.agregarArco(c3, c5, 180);
		ciudad.agregarArco(c5, c7, 193);
		ciudad.agregarArco(c4, c1, 345);

		
	}

}
