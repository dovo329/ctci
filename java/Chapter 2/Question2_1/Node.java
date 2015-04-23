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
	
	public String toString() {
		return String.format("data==" + this.data + " next==" + this.next);
	}
}
