package Greedy;

import java.util.ArrayList;

import grafo.Arco;

public class Ciudad<T> {

	private String id;
	private ArrayList<Arco<T>> arcos;
	private boolean contienePuerto;
	private Ciudad padre;
	private Integer distancia;
	
	
	public Ciudad(String verticeId) {
		this.setId(verticeId);
		this.contienePuerto = false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}
	public void setArcos(ArrayList<Arco<T>> arcos) {
		this.arcos = arcos;
	}
	public boolean isContienePuerto() {
		return contienePuerto;
	}
	public void setContienePuerto(boolean contienePuerto) {
		this.contienePuerto = contienePuerto;
	}
	public Ciudad getPadre() {
		return padre;
	}
	public void setPadre(Ciudad padre) {
		this.padre = padre;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	
	
}
