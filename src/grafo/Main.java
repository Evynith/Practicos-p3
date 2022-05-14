package grafo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		
		grafito.agregarArco(1, 3, null);
		grafito.agregarArco(1, 2, null);
		grafito.agregarArco(2, 4, null);
		grafito.agregarArco(3, 4, null);
		grafito.agregarArco(3, 5, null);
		grafito.agregarArco(4, 5, null);
		
		
		
		System.out.println("vertices: ");
		Iterator<Integer> it = grafito.obtenerVertices();
		while(it.hasNext()) { // 1, 2, 9
			int valor = it.next();
			System.out.println(valor);
		}
		
		EncontrarCamino camino = new EncontrarCamino(grafito, 1, 5, 2);
		System.out.println("camino largo: ");
		Iterator<Integer> it2 = camino.mayorLongitud();
		while(it2.hasNext()) { // 1, 2, 9
			int valor = it2.next();
			System.out.println(valor);
		}
		
		System.out.println("vertices que llegan: ");
		Iterator<Integer> it3 = camino.lleganAFinal();
		while(it3.hasNext()) { // 1, 2, 9
			int valor = it3.next();
			System.out.println(valor);
		}
		
		System.out.println("camino alternativo: ");
		Iterator<Integer> it4 = camino.caminoAlternativo();
		while(it4.hasNext()) { // 1, 2, 9
			int valor = it4.next();
			System.out.println(valor);
		}
		
		// Creo un grafo no dirigdo donde las etiquetas de los arcos son valores Float
				GrafoNoDirigido<Float> ciudad = new GrafoNoDirigido<>();
				
				ciudad.agregarVertice(1);
				ciudad.agregarVertice(2);
				ciudad.agregarVertice(3);
				ciudad.agregarVertice(4);
				ciudad.agregarVertice(5);
				ciudad.agregarVertice(6);
				ciudad.agregarVertice(7);
				ciudad.agregarVertice(8);
				ciudad.agregarVertice(9);
				ciudad.agregarVertice(10);
				
				ciudad.agregarVertice(11);
				ciudad.agregarVertice(12);
				ciudad.agregarVertice(13);
				ciudad.agregarVertice(14);
				ciudad.agregarVertice(15);
				ciudad.agregarVertice(16);
				ciudad.agregarVertice(17);
				ciudad.agregarVertice(18);
				ciudad.agregarVertice(19);
				ciudad.agregarVertice(20);
				
				ciudad.agregarVertice(21);
				ciudad.agregarVertice(22);
				ciudad.agregarVertice(23);
				ciudad.agregarVertice(24);
				ciudad.agregarVertice(26);
				ciudad.agregarVertice(25);
				ciudad.agregarVertice(27);
				ciudad.agregarVertice(28);
				ciudad.agregarVertice(29);
				ciudad.agregarVertice(30);
				
				ciudad.agregarVertice(31);
				ciudad.agregarVertice(32);
				ciudad.agregarVertice(33);
				ciudad.agregarVertice(34);
				ciudad.agregarVertice(36);
				ciudad.agregarVertice(35);
				ciudad.agregarVertice(37);
				ciudad.agregarVertice(38);
				ciudad.agregarVertice(39);
				ciudad.agregarVertice(40);
				
				ciudad.agregarVertice(41);
				ciudad.agregarVertice(42);
				
				ciudad.agregarArco(1, 2, null);
				ciudad.agregarArco(1, 8, null);
				ciudad.agregarArco(2, 3, null);
				ciudad.agregarArco(2, 9, null);
				ciudad.agregarArco(3, 4, null);
				ciudad.agregarArco(3, 10, null);
				ciudad.agregarArco(4, 5, null);
				ciudad.agregarArco(4, 11, null);
				ciudad.agregarArco(5, 6, null);
				ciudad.agregarArco(5, 12, null);
				ciudad.agregarArco(6, 7, null);
				ciudad.agregarArco(6, 13, null);
				ciudad.agregarArco(7, 14, null);
				
				ciudad.agregarArco(8, 9, null);
				ciudad.agregarArco(8, 15, null);
				ciudad.agregarArco(9, 10, null);
				ciudad.agregarArco(9, 16, null);
				ciudad.agregarArco(10, 11, null);
				ciudad.agregarArco(10, 17, null);
				ciudad.agregarArco(11, 12, null);
				ciudad.agregarArco(11, 18, null);
				ciudad.agregarArco(12, 13, null);
				ciudad.agregarArco(12, 19, null);
				ciudad.agregarArco(13, 14, null);
				ciudad.agregarArco(13, 20, null);
				ciudad.agregarArco(14, 21, null);
				
				ciudad.agregarArco(15, 16, null);
				ciudad.agregarArco(15, 22, null);
				ciudad.agregarArco(16, 17, null);
				ciudad.agregarArco(16, 23, null);
				ciudad.agregarArco(17, 18, null);
				ciudad.agregarArco(17, 24, null);
				ciudad.agregarArco(18, 19, null);
				ciudad.agregarArco(18, 25, null);
				ciudad.agregarArco(19, 20, null);
				ciudad.agregarArco(19, 26, null);
				ciudad.agregarArco(20, 21, null);
				ciudad.agregarArco(20, 27, null);
				ciudad.agregarArco(21, 28, null);
				
				ciudad.agregarArco(22, 23, null);
				ciudad.agregarArco(22, 29, null);
				ciudad.agregarArco(23, 24, null);
				ciudad.agregarArco(23, 30, null);
				ciudad.agregarArco(24, 25, null);
				ciudad.agregarArco(24, 31, null);
				ciudad.agregarArco(25, 26, null);
				ciudad.agregarArco(25, 32, null);
				ciudad.agregarArco(26, 27, null);
				ciudad.agregarArco(26, 33, null);
				ciudad.agregarArco(27, 28, null);
				ciudad.agregarArco(27, 34, null);
				ciudad.agregarArco(28, 35, null);
				
				ciudad.agregarArco(29, 30, null);
				ciudad.agregarArco(29, 36, null);
				ciudad.agregarArco(30, 31, null);
				ciudad.agregarArco(30, 37, null);
				ciudad.agregarArco(31, 32, null);
				ciudad.agregarArco(31, 38, null);
				ciudad.agregarArco(32, 33, null);
				ciudad.agregarArco(32, 39, null);
				ciudad.agregarArco(33, 34, null);
				ciudad.agregarArco(33, 40, null);
				ciudad.agregarArco(34, 35, null);
				ciudad.agregarArco(34, 41, null);
				ciudad.agregarArco(35, 42, null);
				
				EncontrarCamino caminoCiudad = new EncontrarCamino(ciudad, 20, 31, 2);
				
				System.out.println("ciudad, adyacentes de 19: ");
				Iterator<Integer> it5 = ciudad.obtenerAdyacentes(19);
				while(it5.hasNext()) { 
					int valor = it5.next();
					System.out.println(valor);
				}
				
				System.out.println("ciudad: ");
				System.out.println(caminoCiudad.obtenerMenorCamino());
//				caminoCiudad.obtenerMenorCamino().forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

		/*
		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		System.out.println(etiqueta); // Deber�a imprimir 3*/
		
	}

}
