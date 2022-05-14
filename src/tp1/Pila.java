package tp1;

public class Pila {

	protected MySimpleLinkedList pila;
	
	public Pila() {
		this.pila = new MySimpleLinkedList();
	}
	
	public void push(Integer o) {
		this.pila.insertFront(o);
	}
	
	public Object pop() {
		return this.pila.extractFront();
	}
	
	public Object top() {
		return this.pila.get(0);
	}
	
	public void reverse() {
		MySimpleLinkedList pilaAux = new MySimpleLinkedList();
		pilaAux.insertFront(this.pila.extractFront());
		this.pila = pilaAux;
	}
}
