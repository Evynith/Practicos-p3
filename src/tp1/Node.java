package tp1;

public class Node {

	private Integer info;
	private Node next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(Integer o, Node n) {
		this.setInfo(o);
		this.setNext(n);
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return String.valueOf(this.info);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Node)obj).getInfo() == this.getInfo();
	}

}
