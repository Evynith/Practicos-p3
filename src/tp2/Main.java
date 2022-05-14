package tp2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[] {2,5,1,8,4};
		int[] arrOrdenado = new int[] {2,5,6,8,9};
		
		Arreglo a1 = new Arreglo(arrOrdenado);
		System.out.println("busqueda ordenado: " + a1.busquedaOrdenado(6));
		
		Arreglo a2 = new Arreglo(arr);
		System.out.println("ordenado: " + a2.VerificarOrden());
		a2.ordenSeleccion();
		a2.imprimir();
		
		Arreglo a3 = new Arreglo(arr);
		a3.ordenBurbujeo();
		a3.imprimir();
		
		Arreglo a4 = new Arreglo(arr);
		a4.ordenarMergeSort();
		a4.imprimir();
		
		Arreglo a5 = new Arreglo(arr);
		a5.ordenQuickSort();
		a5.imprimir();
		
		TreeWithNode tree = new TreeWithNode();
		tree.add(10);
		tree.add(4);
		tree.add(2);
		tree.add(3);
		tree.add(12);
		
		System.out.println("existe en arbol elemento: " + tree.hasElem(1));
		System.out.println("Borrar: " + tree.delete(4));
		
		System.out.println("Frontera: ");
		ArrayList<Integer> frontera = tree.getFrontera();
		for (int i=0; i<frontera.size();i++) {
			System.out.println("| " + frontera.get(i) + " |");
		}
 		
		System.out.println("Nodo mas derecho: " + tree.getMaxElem());
		
		System.out.println("Nivel X: ");
		ArrayList<Integer> nvl = tree.getElemAtLevel(1);
		for (int i=0; i<nvl.size();i++) {
			System.out.println("| " + nvl.get(i) + " |");
		}
 		
	}

}
