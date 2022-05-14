package Backtraking;

import java.util.ArrayList;

public class Combinaciones {

	private ArrayList<Integer> numeros;
	private ArrayList<ArrayList<Integer>> resultados;
	private int nroDestino;
	
	public Combinaciones(ArrayList<Integer> numeros) {
		this.numeros = numeros;
		this.resultados = new ArrayList<ArrayList<Integer>>();
		this.nroDestino = 0;
	}
	
	public ArrayList<ArrayList<Integer>> combinacionesIgualadasA(int m){
		this.nroDestino = m;
		ArrayList<Integer> recorridos = new ArrayList<>();
		for (Integer i : this.numeros) {
			
			this.recorrido(new ArrayList<Integer>(),i, 0);
			
//			ArrayList<Integer> posibles = new ArrayList<Integer>(this.numeros);
//			recorridos.add(i);
//			posibles.removeAll(recorridos);
//			this.recorrido(new ArrayList<Integer>(), posibles, i, 0);
		}
		return this.resultados;
	}

	private void recorrido(ArrayList<Integer> conjunto, int numero, int valorProvisorio) {
//	private void recorrido(ArrayList<Integer> conjunto, ArrayList<Integer> posibles, Integer numero, int valorProvisorio) {
		conjunto.add(numero);
		valorProvisorio += numero;

		if (valorProvisorio == this.nroDestino) {
			resultados.add(new ArrayList<Integer>(conjunto));
		} else {
			if (valorProvisorio < this.nroDestino) { //poda
				
				ArrayList<Integer> posibles = this.posibles(conjunto);
				
//				ArrayList<Integer> sig = new ArrayList<Integer>(posibles);
//				sig.remove(numero);
				for (Integer i : posibles) {
//					this.recorrido(conjunto, sig, i, valorProvisorio);
					
					this.recorrido(conjunto, i, valorProvisorio);
					
					conjunto.remove(i);
				}
			}
		}
	}
	
	private ArrayList<Integer> posibles (ArrayList<Integer> conjunto){
		ArrayList<Integer> posibles = new ArrayList<Integer>(numeros);
		for (Integer i: conjunto) {
			posibles.remove(i);			
		}
		return posibles;
	}
	
	public ArrayList<ArrayList<Integer>> particionEnDos(){
		for(Integer i : this.numeros) {
			this.partirEnDos(new ArrayList<Integer>(), i);			
		}
		return this.resultados;
	}
	
	private void partirEnDos(ArrayList<Integer> conjuntoProvisorio,Integer num) {
		conjuntoProvisorio.add(num);
		ArrayList<Integer> posibles = this.posibles(conjuntoProvisorio);
		
		if(resultados.isEmpty()) { //poda
			if(this.sumaContenido(conjuntoProvisorio) == this.sumaContenido(posibles)){
//				this.resultados.clear();
				this.resultados.add(0,new ArrayList<Integer>(conjuntoProvisorio));
				this.resultados.add(1,new ArrayList<Integer>(posibles));
			} else {
				if(this.sumaContenido(conjuntoProvisorio) < this.sumaContenido(posibles)) { //poda
					for(Integer i : posibles) {
						this.partirEnDos(conjuntoProvisorio, i);
						conjuntoProvisorio.remove(i);
					}
				}
			}			
		}
	}
	
	private int sumaContenido(ArrayList<Integer> l) {
		int rta = 0;
		for(Integer i : l) {
			rta += i;
		}
		return rta;
	}
}
