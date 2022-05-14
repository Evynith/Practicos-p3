package Backtraking;

import java.util.ArrayList;
import java.util.Iterator;

public class Persona {

	Grafo<Sala> salas;
	ArrayList<Sala> mejorCamino;
	public Persona(Grafo<Sala> salas) {
		this.salas = salas;
		this.mejorCamino = new ArrayList<Sala>();
	}
	
	public ArrayList<Sala> recorrerMaximoSalas(){
		salas.obtenerVertices().forEachRemaining((elem)->{
			if (elem.getNombre() == "entrada") {
				this.buscarCaminoLargo(elem, new ArrayList<Sala>());
			}
		});
		return this.mejorCamino;
	}
	
	private void buscarCaminoLargo (Sala s, ArrayList<Sala> salasProvisorias){
		salasProvisorias.add(s);
		if(s.getNombre() == "salida") {
			if (salasProvisorias.size() >= mejorCamino.size()) {
				this.mejorCamino = new ArrayList(salasProvisorias);
			}
		} else {
			Iterator<Sala> it = this.salas.obtenerAdyacentes(s);
			it.forEachRemaining((salaAdyacente)-> {
				this.buscarCaminoLargo(salaAdyacente, salasProvisorias);
				salasProvisorias.remove(salaAdyacente);
			});
		}
	}
}
