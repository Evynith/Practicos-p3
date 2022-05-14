package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Calendario {

	private ArrayList<Actividad> actividades;
	
	public Calendario ( ArrayList<Actividad> actividades) {
		this.actividades = actividades; //TODO no igualar, copiar
	}
	
	public  ArrayList<Actividad> actividadesCompatibles(){
		ArrayList<Actividad> rta = new ArrayList<Actividad>();
		Collections.sort(this.actividades);
		int fechaAgregadaIndex = -1;
		for(Actividad a: this.actividades) {
			if(rta.isEmpty()) {
				rta.add(a);
				fechaAgregadaIndex ++;
			} else {
				if (rta.get(fechaAgregadaIndex).getFin().compareTo(a.getInicio()) < 0) {//como fila
					rta.add(a);
					fechaAgregadaIndex ++;
				}
			}
		}
		return rta;
	}
}
