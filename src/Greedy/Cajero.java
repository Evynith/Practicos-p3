package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Cajero {

	private HashMap<Integer, Integer> monedas;
	
	public Cajero(HashMap<Integer, Integer> monedas) {
		this.monedas = monedas;
	}
	
	//TODO probar estructura TreeSet()
	public HashMap<Integer, Integer> dar(Integer monto){
		HashMap<Integer, Integer> rta = new HashMap<Integer, Integer>();
		ArrayList<Integer> ordenInsercion = this.ordenCriterioMayoraMenor();
		int cantidad = 0;
		int cantidadSobrante = 0;
		for (Integer moneda : ordenInsercion) {
			cantidad = monto/moneda;
			cantidadSobrante = this.monedas.get(moneda) - cantidad;
			if (cantidadSobrante < 0) {
				cantidad = this.monedas.get(moneda);
			} 
			this.monedas.put(moneda, cantidadSobrante);
			rta.put(moneda, cantidad);	
			monto = monto - (cantidad * moneda);
		}
		return rta;
	}
	
	private ArrayList<Integer> ordenCriterioMayoraMenor() {
		ArrayList<Integer> ordenInsercion = new ArrayList<Integer>(this.monedas.size());
		ordenInsercion.addAll(this.monedas.keySet());
		Collections.sort(ordenInsercion, Collections.reverseOrder());
		return ordenInsercion;
	}
}
