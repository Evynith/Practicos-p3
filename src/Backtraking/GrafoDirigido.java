package Backtraking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class GrafoDirigido<T> implements Grafo<T> {
	
	public GrafoDirigido() {
		this.verticesF = new HashMap<T,ArrayList<Arco<T>>>();
	}
	
//	// Alternativa J
//	private ArrayList<Vertice<T>> verticesJ; // ---> Vertice (ArrayList<Arco> arcos) 
//	// Alternativa H
//	private ArrayList<Vertice> verticesH; // ---> Vertice (LinkedList<Arco> arcos)
//	
	// Alternativa F
	private HashMap<T,ArrayList<Arco<T>>> verticesF;
	HashMap<T,String> recorrido = new HashMap<T,String>();
	
	@Override
	public void agregarVertice(T verticeId) {
//		Vertice ver = new Vertice(verticeId);
		verticesF.put(verticeId, new ArrayList<Arco<T>>());
	}

	@Override
	public void borrarVertice(T verticeId) {
		verticesF.forEach((k,v) -> {
//			for(Arco a : v) {
//				if(a.getVerticeDestino() == verticeId) {
					this.borrarArco(k, verticeId);
//				}
//			}
		});
		verticesF.remove(verticeId);
	}

	@Override
	public void agregarArco(T verticeId1,T verticeId2, int etiqueta) {
		Arco a = new Arco(verticeId1, verticeId2, etiqueta);
		verticesF.get(verticeId1).add(a);
	}

	@Override
	public void borrarArco(T verticeId1, T verticeId2) {
		//si existe (puede no existir) tanto el v1 como el v1 con v2
		ArrayList<Arco<T>> arr = verticesF.get(verticeId1);
		if (!arr.isEmpty()) {
			for(Arco a : arr) {
				if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
					arr.remove(a);
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(T verticeId) {
		return verticesF.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(T verticeId1,T verticeId2) { 
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arr = verticesF.get(verticeId1);
			if (!arr.isEmpty()) {
				for(Arco a : arr) {
					if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(T verticeId1, T verticeId2) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arr = verticesF.get(verticeId1);
			if (!arr.isEmpty()) {
				for(Arco<T> a : arr) {
					if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
						return a;
					}
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return verticesF.size();
	}

	@Override
	public int cantidadArcos() {
		int contador = 0;
//		verticesF.forEach((k,v) -> {
//			contador += v.size();
//		});
		for (ArrayList<Arco<T>> arr : verticesF.values()) {
			if (!arr.isEmpty()) {
				contador += arr.size();
			}
		}
		return contador;
	}

	@Override
	public Iterator<T> obtenerVertices() {
		
		// Alternativa con lista de vertices --> O(n)
		/*
		ArrayList<Integer> listaAux = new ArrayList<>();
		for (Vertice<T> v: this.verticesJ)
			listaAux.add(v.getId());
		return listaAux.iterator(); 
		*/
		
//		// O(1)
//		Iterator<Vertice<T>> iteradorInterno = this.verticesJ.iterator(); // O(1)
//		return new IteradorVertice<T>(iteradorInterno);  // O(1)
//		

		// O(1)
		 return this.verticesF.keySet().iterator(); 
		
	}

	@Override
	public Iterator<T> obtenerAdyacentes(T verticeId) {
		//TODO si existe el vertice dado
		ArrayList<Arco<T>> arcosAd = verticesF.get(verticeId);
		ArrayList<T> adyacentes = new ArrayList<T>();
		for (Arco<T> a :arcosAd) {
			if(a != null) {
			adyacentes.add(a.getVerticeDestino());
			}
		}
		return adyacentes.iterator();
	}

	@Override 
	public Iterator<Arco<T>> obtenerArcos() {
		// Aca esta bien hacer un for y crear una lista auxiliar
		ArrayList<Arco<T>> adyacentes = new ArrayList<Arco<T>>();
		for(ArrayList<Arco<T>> arcos: verticesF.values()) {
			adyacentes.addAll(arcos);
		}
		return adyacentes.iterator();
	}

	@Override 
	public Iterator<Arco<T>> obtenerArcos(T verticeId) {	
		//TODO si existe el vertice dado
		return verticesF.get(verticeId).iterator();
	}
	
}
