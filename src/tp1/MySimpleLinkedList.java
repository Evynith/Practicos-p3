package tp1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Integer>{
	
	protected Node first;
	protected int size;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(Integer o) {
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size += 1;
	}
	
	public Integer extractFront() {
		Node tmp = this.first;
		this.first = this.first.getNext();
		this.size -= 1;
		return tmp.getInfo();
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		return this.size;
	}
	
	public Integer get(int index) {
		if (index < this.size && index >= 0) {
			Node num = this.getNode(index);
			if (num != null) {
				return num.getInfo();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private Node getNode(int index) {
		Node tmp = this.first;
		for (int i= 0; i<index; i++) {
			tmp = tmp.getNext();
		}
		return tmp;
	}
	
	public int indexOf(Integer o) {
		int rta = -1;
		for(int i = 0; i < this.size; i++) {
			if ( this.getNode(i).getInfo().equals(o)) {
				rta = i;
			}
		}
		return rta;
	}
	
	public MySimpleLinkedList comunesA(MySimpleLinkedList m) {
		this.ordenar();
		m.ordenar();
		return this.comunesOrdenados(this, m);
	}
	
	private MySimpleLinkedList comunesOrdenados(MySimpleLinkedList c1, MySimpleLinkedList c2) {
		MySimpleLinkedList resultantes = new MySimpleLinkedList();
		Iterator it = c1.iterator();
		Iterator it2 = c2.iterator();

		int val1 = ((Integer)it.next());
		int val2 = ((Integer)it2.next());
		while (it.hasNext() && it2.hasNext()) {
			if (val1 < val2) {
				val1 = ((Integer)it.next());
			} else if(val1 == val2) {
				resultantes.insertFront(val1);
				val1 = ((Integer)it.next());
				val2 = ((Integer)it2.next());
			} else {
				val2 = ((Integer)it2.next());
			}
		}
		return resultantes; //los devuelve al reves, darlos vuelta TODO
	}
	
	public void ordenar() {
		//cortar si ya esta ordendo TODO
		Node nodo = this.first;
		Node prev = null;
		int limite = this.size();
		for(int inic = 0; inic < this.size(); inic++) {
			prev = null;
			nodo = this.first;
			for(int i = 0; i < limite && nodo.getNext() != null; i++) {
				if (nodo.getInfo() > nodo.getNext().getInfo()) {

					Integer val1 = nodo.getInfo();
					Integer val2 = nodo.getNext().getInfo();
					
					nodo.setInfo(val2);
					nodo.getNext().setInfo(val1);
				}
				prev = nodo;
				nodo = nodo.getNext();
			}
			limite--;
		}
	}
	
	public boolean buscarRecursivo(Integer buscar) {
		if (this.busqueda(this.first, -1, buscar) != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	private int busqueda(Node nodo, int lugar, Integer num) {
		if (nodo.getInfo() == num) {
			return lugar +1;
		} else {
			if(nodo.getNext() != null) {
				return this.busqueda(nodo.getNext(), lugar+1, num);
			} else {
				return -1;
			}		
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteradorLista(this.first);
	} 

}
