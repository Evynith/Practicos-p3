package tp1;

import java.util.Iterator;

public class IteradorLista implements Iterator<Integer> {
	
	private int puntero;
	private Node node;
	
	public IteradorLista(Node n) {
		this.puntero = 0;
		this.node = n;
	}

	@Override
	public boolean hasNext() {
		return this.node.getNext() != null;
	}

	@Override
	public Integer next() {
		if (this.puntero == 0) {
			this.puntero++;
			return this.node.getInfo();
			// ya que no estoy recibiendo la estructura, preferí usaresto para que no tenga que acceder cada vez
		} else {
			Node sig = this.node.getNext();
			Integer dato = sig.getInfo();
			this.node = sig;
			this.puntero++;
			return dato;
		}
	}

}
