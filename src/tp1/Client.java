package tp1;

import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		
		//Ejercicio 1
		MySimpleLinkedList l1 = new MySimpleLinkedList();
//		l1.insertFront(43);
//		l1.insertFront(7);
//		l1.insertFront(48);
//		l1.insertFront(48);
//		l1.insertFront(2);
//		l1.insertFront(1);
		
		l1.insertFront(1);
		l1.insertFront(4);
		l1.insertFront(3);
		l1.insertFront(9);
		l1.insertFront(5);
		l1.insertFront(6);
		
		Object elemento = l1.get(7);
		if (elemento != null) {
			System.out.println("Elemento 5 es: " + elemento);	
		} else {
			System.out.println("No existe");
		}

		//Ejercicio 3
		Pila pila = new Pila();
		
		//Ejercicio 4
		System.out.println("El elemento 3 se encuentra en el indice " + l1.indexOf(3));
	
		//Ejercicio 5
		Iterator it = l1.iterator();
		while (it.hasNext()) {
			System.out.println("iterador recive: " + it.next());
		}
		
		//Ejercicio 6
		System.out.println("E6- orden");
		l1.ordenar();
		for (int i= 0 ; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		
		MySimpleLinkedList l2 = new MySimpleLinkedList();
		l2.insertFront(6);
		l2.insertFront(23);
		l2.insertFront(4);
		l2.insertFront(15);
		l2.insertFront(2);
		l2.insertFront(1);
		
		System.out.println("Iguales: ");
		MySimpleLinkedList resultantes = l1.comunesA(l2);
		for (int i= 0 ; i < resultantes.size(); i++) {
			System.out.println(resultantes.get(i));
		}
		
		//tp2 - Ejercicio2
		System.out.println("busqueda recursiva: " + l2.buscarRecursivo(100));
		
		
	
	}

}
