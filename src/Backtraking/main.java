package Backtraking;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		GrafoDirigido<Sala> salas = new GrafoDirigido<Sala>();
		Sala s1 = new Sala(1,"entrada");
		Sala s2 = new Sala(2, "sala");
		Sala s3 = new Sala(3, "sala");
		Sala s4 = new Sala(4, "sala");
		Sala s5 = new Sala(5, "sala");
		Sala s6 = new Sala(6, "sala");
		Sala s7 = new Sala(7, "sala");
		Sala s8 = new Sala(8, "sala");
		Sala s9 = new Sala(9, "sala");
		Sala s10 = new Sala(10, "sala");
		Sala s11 = new Sala(11, "sala");
		Sala s12 = new Sala(12, "sala");
		Sala s13 = new Sala(13, "sala");
		Sala s14 = new Sala(14, "sala");
		Sala s15 = new Sala(15, "sala");
		Sala s16 = new Sala(16, "sala");
		Sala s17 = new Sala(17, "sala");
		Sala s18 = new Sala(18, "sala");
		Sala s19 = new Sala(19, "salida");
		Sala s20 = new Sala(20, "sala");
		Sala s21 = new Sala(21, "sala");
		Sala s22 = new Sala(22, "sala");
		
		salas.agregarVertice(s1);
		salas.agregarVertice(s2);
		salas.agregarVertice(s3);
		salas.agregarVertice(s4);
		salas.agregarVertice(s5);
		salas.agregarVertice(s6);
		salas.agregarVertice(s7);
		salas.agregarVertice(s8);
		salas.agregarVertice(s9);
		salas.agregarVertice(s10);
		salas.agregarVertice(s11);
		salas.agregarVertice(s12);
		salas.agregarVertice(s13);
		salas.agregarVertice(s14);
		salas.agregarVertice(s15);
		salas.agregarVertice(s16);
		salas.agregarVertice(s17);
		salas.agregarVertice(s18);
		salas.agregarVertice(s19);
		salas.agregarVertice(s20);
		salas.agregarVertice(s21);
		salas.agregarVertice(s22);
		
		salas.agregarArco(s1, s2, 0);
		salas.agregarArco(s1, s3, 0);
		salas.agregarArco(s1, s4, 0);
		salas.agregarArco(s1, s20, 0);
		salas.agregarArco(s20, s21, 0);
		salas.agregarArco(s19, s21, 0);
		salas.agregarArco(s1, s7, 0);
		salas.agregarArco(s7, s12, 0);
		salas.agregarArco(s12, s16, 0);
		salas.agregarArco(s16, s19, 0);
		salas.agregarArco(s3, s13, 0);
		salas.agregarArco(s13, s16, 0);
		salas.agregarArco(s13, s19, 0);
		salas.agregarArco(s4, s8, 0);
		salas.agregarArco(s8, s9, 0);
		salas.agregarArco(s9, s10, 0);
		salas.agregarArco(s10, s14, 0);
		salas.agregarArco(s14, s17, 0);
		salas.agregarArco(s17, s19, 0);
		salas.agregarArco(s14, s15, 0);
		salas.agregarArco(s15, s18, 0);
		salas.agregarArco(s18, s19, 0);
		salas.agregarArco(s4, s5, 0);
		salas.agregarArco(s5, s6, 0);
		salas.agregarArco(s6, s11, 0);
		salas.agregarArco(s11, s19, 0);
		salas.agregarArco(s18, s22, 0);

		Persona p1 = new Persona(salas);
		System.out.println(p1.recorrerMaximoSalas());
		
		ArrayList<Casilla> elementos = new ArrayList<Casilla>(Arrays.asList(
		 new Casilla(1, false, true, false, false), //arriba, abajo, derecha, izquierda
		 new Casilla(2, false, true, false, true),
		 new Casilla(3, false, true, true, true),
		 new Casilla(4, false, false, true, false),
		 new Casilla(5, false, false, true, false),
		 new Casilla(6, false, true, false, false),
		 new Casilla(7, false, false, false, false),
		
		new Casilla(8, false, true, false, false),
		new Casilla(9, false, true, false, false),
		 new Casilla(10, false, true, true, false),
		 new Casilla(11, false, false, true, false),
		 new Casilla(12, false, false, false, false),
		 new Casilla(13, false, true, true, false),
		 new Casilla(14, false, true, false, false),
		
		 new Casilla(15, false, true, false, false),
		 new Casilla(16, false, true, false, false),
		 new Casilla(17, false, false, true, false),
		 new Casilla(18, false, false, true, false),
		 new Casilla(19, false, true, false, false),
		 new Casilla(20, false, true, false, false),
		 new Casilla(21, false, false, false, false),
		
		 new Casilla(22, false, true, false, false),
		 new Casilla(23, false, false, true, false),
		 new Casilla(24, false, false, true, false),
		 new Casilla(25, false, false, true, false),
		 new Casilla(26, false, false, false, false),
		 new Casilla(27, false, false, true, true),
		 new Casilla(28, false, true, false, true),
		
		 new Casilla(29, false, false, true, false),
		 new Casilla(30, false, false, true, false),
		 new Casilla(31, false, false, true, false),
		 new Casilla(32, false, false, false, false),
		 new Casilla(33, false, false, false, false),
		 new Casilla(34, false, false, false, true),
		 new Casilla(35, false, false, false, true)
		));
		
		System.out.println("Ejercicio 2");
		ArrayList<ArrayList<Casilla>> casillas = new  ArrayList<ArrayList<Casilla>>();
		for (int i= 0; i< 35; i+=7) {
			casillas.add(new ArrayList<Casilla>(elementos.subList(i, i+7)));
		}
		
//		for (int i = 0; i<casillas.size(); i++) {
//			for (int j = 0; j<casillas.get(0).size(); j++) {
//				System.out.print("i,j: " + casillas.get(i).get(j));				
//			}
//			System.out.println("");
//		}
		
		Laberinto la = new Laberinto(casillas);
		System.out.println(la.encontrarCaminoMenorLongitud(3, 26));
	
		Combinaciones com = new Combinaciones(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
		for(ArrayList<Integer> lista : com.combinacionesIgualadasA(6)) {
			System.out.println(lista);
		}
		
		System.out.println("Ejercicio 3: ");
		Combinaciones com2 = new Combinaciones(new ArrayList<Integer>(Arrays.asList(1,2,3,5,1)));
		for(ArrayList<Integer> lista : com2.particionEnDos()) {
			System.out.println(lista);
		}
		
	}

}
