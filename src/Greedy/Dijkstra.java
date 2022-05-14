package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Dijkstra<T> {

	private final Integer INFINITO = Integer.MAX_VALUE;
	private Grafo<T> grafo;
	private HashMap<T, T> padres;
	private TreeMap<T, Integer> distancias;
	private ArrayList<T> verticesFaltantes, verticesPasados;
	
	public Dijkstra(Grafo<T> grafo) {
		this.grafo = grafo;
		Iterator<T> it = this.grafo.obtenerVertices();
		this.padres = new HashMap<T, T>() ;
		this.distancias = new TreeMap<T, Integer>();
		this.verticesFaltantes = new ArrayList<T>();
		this.verticesPasados = new ArrayList<T>();

		it.forEachRemaining((verticeRecorrido) -> { 
			distancias.put(verticeRecorrido, INFINITO);
			padres.put(verticeRecorrido, null);
			verticesFaltantes.add(verticeRecorrido);
		});	
		this.verticesPasados = new ArrayList<T>();
	}
	
	public HashMap<T,T> caminoMasCorto(T verticeOrigen){
		this.distancias.put(verticeOrigen, 0);
		while (this.verticesFaltantes.size() != 0) {
			T verticeMenorDistancia = this.verticeMenorDistancia();
			this.verticesPasados.add(verticeMenorDistancia);
			this.verticesFaltantes.remove(verticeMenorDistancia);
			Iterator<T> it2 =this.grafo.obtenerAdyacentes(verticeMenorDistancia);
			
			it2.forEachRemaining((v) ->
			{
				int distanciaEntre = this.distancias.get(verticeMenorDistancia) + (Integer)this.grafo.obtenerArco(verticeMenorDistancia, v).getEtiqueta();
				if(distanciaEntre < this.distancias.get(v)){
					this.distancias.put(v, distanciaEntre);
					this.padres.put(v, verticeMenorDistancia);
				}
			});
//			};
		}
		return this.padres;
	}
	
	private T verticeMenorDistancia() {
		T verticeMenorDistancia = this.distancias.firstKey();
		T vertice = null;
		for(Entry<T, Integer> entry : this.distancias.entrySet()) {
			T key = entry.getKey(); 
			Integer value = entry.getValue();
			if(this.verticesFaltantes.contains(key)) {
				vertice = key;
			}
		}
		if (vertice == null) {
			return this.verticesFaltantes.get(0);
		}
		return vertice;
	}
	
	//TODO ...
//	public ArrayList<ArrayList<Ciudad>> caminosAlPuerto(){
//		ArrayList<HashMap<T,T>> rta = new ArrayList<HashMap<T,T>>();
//		Iterator<Ciudad> it = (Iterator<Ciudad>)this.grafo.obtenerVertices();
//		while( it.hasNext()) {
//			Ciudad value = it.next();
//			if(value.isContienePuerto() == true) {
//				rta.add( this.caminoMasCorto((T) value));
//			}
//		}
//		return this.revisarMenorPuerto();
//	}
//	
//	private ArrayList<Ciudad> seguirCamino(HashMap<T,T> camino) {
//		
//	}
//	
//	private ArrayList<ArrayList<Ciudad>> revisarMenorPuerto() {
//		
//	}
}
