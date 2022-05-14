package Backtraking;

import java.util.ArrayList;

public class Sala<T> {

	private Integer id;
	private ArrayList<Arco<T>> arcos;
	private String nombre;
	
	
	public Sala(Integer verticeId, String nombre) {
		this.id = verticeId;
		this.nombre = nombre;
	}


	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}


	public void setArcos(ArrayList<Arco<T>> arcos) {
		this.arcos = arcos;
	}


	public Integer getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
