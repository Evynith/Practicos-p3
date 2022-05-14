package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Mochila {

	
	private ArrayList<Elemento> elementos;
	private float pesoMaximo;
	
	public Mochila (float pesoMaximo) {
		this.elementos = new ArrayList<Elemento>();
		this.pesoMaximo = pesoMaximo;
	}
	
	public void llenar(ArrayList<Elemento> posibles) {
		Collections.sort(posibles, Collections.reverseOrder());
		float pesoProvisorio = 0;
		for (Elemento e : posibles) {
			if (pesoProvisorio + e.getPeso() < this.pesoMaximo && (pesoProvisorio <= this.pesoMaximo)) {
				elementos.add(e);
				pesoProvisorio += e.getPeso();
			} else {
				float aux = (this.pesoMaximo - pesoProvisorio) / e.getPeso();
				float pesoSeleccionado = e.getPeso()*aux;
				if ((pesoProvisorio + pesoSeleccionado) <= this.pesoMaximo) {
					elementos.add(new Elemento(pesoSeleccionado, e.getValor()));
					pesoProvisorio += pesoSeleccionado;	
				}
			}
		}
//		System.out.print("peso alcanzado: " + pesoProvisorio);
	}
	
	public ArrayList<Elemento> getContenido (){
		return this.elementos; //TODO no devolver el array
	}
}
