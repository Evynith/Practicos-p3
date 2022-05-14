package Greedy;

public class Elemento implements Comparable{
	
	private float peso, valor;
	
	public Elemento (float peso, float valor) {
		this.peso = peso;
		this.valor = valor;
	}

	public float getPeso() {
		return peso;
	}

	public float getValor() {
		return valor;
	}

	@Override
	public int compareTo(Object arg0) {
		Elemento otro = (Elemento) arg0;
		float rta = (this.valor/ this.peso) - (otro.valor/ otro.getPeso());
//		si a1> a2, devuelve un número negativo
//		si a1 <a2, devuelve un número positivo
//		si a1 == a2, devuelve 0

		if (rta == 0) {
			return 0;
		} else if (rta > 0 ) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Elemento [peso=" + peso + ", valor=" + valor + "]";
	}
	
	
	
}
