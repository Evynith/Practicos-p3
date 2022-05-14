package Greedy;

import java.time.LocalTime;

public class Actividad implements Comparable{

	//de 0 a 23hs
	private LocalTime inicio, fin;
	
	public Actividad(LocalTime inicio, LocalTime fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public LocalTime getFin() {
		return fin;
	}

	@Override
	public int compareTo(Object arg0) {
		Actividad otro = (Actividad) arg0;
		return this.fin.compareTo(otro.fin);
	}

	@Override
	public String toString() {
		return "Actividad [inicio=" + inicio + ", fin=" + fin + "]";
	}
	
	
	
}
