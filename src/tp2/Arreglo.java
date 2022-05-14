package tp2;

import java.util.ArrayList;
import java.util.Arrays;

public class Arreglo {

	private int[] arr;
	private int size = 0;
	private int[] helper = null;
	
	public Arreglo(int[] arr) {
		this.arr = arr;
		//para merge sort
		this.size = this.arr.length;
		this.helper = new int[this.size];
	}
	
	//TP2 Ejercicio 1
	public boolean VerificarOrden() {
		return this.VerificarOrden(0);
	}
	
		private boolean VerificarOrden(int puntero) {
			if (this.arr.length >= 2) {
				if(this.arr[puntero] < this.arr[puntero +1]) {
					if(puntero +1 < arr.length) {
						return this.VerificarOrden(puntero + 1);
					} else {
						return true; // acá para la recursión
					}
				} else {
					return false;
				}
			}
			return true;
		}
		
		//TP2 Ejercicio 2b
		public int busquedaOrdenado(int busca) {
			return this.busquedaOrdenado(0, busca);
		}
		
		private int busquedaOrdenado(int puntero, int busca) {
			if (this.arr.length > 0) {
				if (this.arr[puntero] == busca) {
					return puntero;
				} else if (this.arr[puntero] < busca && puntero+1 < arr.length) {
						return this.busquedaOrdenado(puntero +1, busca);	
				} else {
					return -1;
				}
			} 
			return -1;
		}
		
		//sort
		public void ordenSeleccion() {
			for (int i=0 ; i< arr.length; i++) {
				for (int k = i+1; k < arr.length; k++) {
					if (arr[i] > arr[k]) {
						int aux = arr[k];
						arr[k]= arr[i];
						arr[i]= aux;
					}
				}
			}
		}
		
		public void ordenBurbujeo() {
			for (int i=0 , j=arr.length -1 ;i<j && j>=0; i++, j--) {
				for (int k=0; k<= j - 1; k++) {
					if(arr[k] > arr[k+1]) {
						int aux = arr[k];
						arr[k]= arr[k+1];
						arr[k+1]= aux;
					}
				}
			}
		}
		
		public void ordenarMergeSort() {
			this.mergeSort(0, this.size - 1);
		}
		
		private void mergeSort(int low, int high) {
			if (low < high) {
			int middle = (low + high) / 2;
			this.mergeSort(low, middle);
			this.mergeSort(middle + 1, high);
			this.merge(low, middle, high);
			}

		
		}
		
		private void merge(int low, int middle, int high) {
			// copier ambas partes al array helper
			for (int i = low; i <= high; i++) {
				this.helper[i] = this.arr[i];
			}
			int i = low;
			int j = middle + 1;
			int k = low;
			while (i <= middle && j <= high) {
				if (this.helper[ i ] <= this.helper[ j ]) {
					this.arr[ k ] = this.helper[ i ];
					i++;
				} else {
					this.arr[ k ] = this.helper[ j ];
					j++;
				}
				k++;
			}
			// si quedaron elementos copiarlos al array original
			while (i <= middle) {
				this.arr[ k ] = this.helper[ i ];
				k++;
				i++;
			}
			while (j <= high) {
				this.arr[ k ] = this.helper[ j ];
				k++;
				j++;
			}
		}
		
		public void ordenQuickSort() {
			this.quickSort(0, this.arr.length-1, this.arr);
			
		}
		
		private int[] quickSort(int i, int f, int[] arr) {
			int pivote = arr[i] + arr[f] /2;
			int inicio = i;
			int fin = f;
			
			//itero hasta que no sea menor que ultimo
			while (inicio < fin) {
				while (arr[inicio] < pivote) {
					inicio ++;
				}
				while (arr[fin] > pivote) {
					fin --;
				}
				if(inicio <= fin) {
					int temp = arr[fin];
					arr[fin] = arr[inicio];
					arr[inicio] = temp;
					
					inicio ++;
					fin --;
				}
			}
			if (i < fin) {
				arr = this.quickSort(i , fin, arr);
			}
			if (f > inicio) {
				arr = this.quickSort(inicio,f, arr);
			}
			return arr;
		}

		public void imprimir() {
			System.out.println("arreglo: ");
			for(int i=0; i<arr.length;i++) {
				System.out.println("| " + arr[i] + " |");
			}
		}
}
