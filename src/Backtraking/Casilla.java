package Backtraking;

public class Casilla {

	private int valor, id;
	private boolean arriba, abajo, izquierda, derecha;
	
	public Casilla(int valor, boolean arriba, boolean abajo, boolean derecha, boolean izquierda) {
		this.abajo = abajo;
		this.arriba = arriba;
		this.derecha = derecha;
		this.izquierda = izquierda;
		this.valor = valor;
		this.id = valor; //TODO deberia pedirlo 
	}

	public int getValor() {
		return valor;
	}
	
	public int getId() {
		return id;
	}

	public boolean isArriba() {
		return arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public boolean isDerecha() {
		return derecha;
	}

	@Override
	public String toString() {
		return "Casilla [valor=" + valor + "]";
	}
	
	
}
