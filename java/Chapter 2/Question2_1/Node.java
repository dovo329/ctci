package Question2_1;

public class Node <T> {
	private T data;
	private Node <T> next;
	
	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	public Node() {
		this.data = null;
		this.next = null;
	}
	
	public void setNext(Node <T> next) {
		this.next = next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node <T> getNext() {
		return this.next;
	}
	
	public T getData() {
		return this.data;
	}
	
	public String toStringRecursive() {
		return String.format("data==" + this.data + " next==" + this.next);
	}
	
	public String toString() {
		return String.format("data==%s next %s null", this.data, (this.next==null)?"is indeed": "is not");
	}
}
