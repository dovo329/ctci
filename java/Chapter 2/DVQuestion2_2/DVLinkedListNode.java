package DVQuestion2_2;

public class DVLinkedListNode {	
	public Integer data;
	public DVLinkedListNode next;
	
	DVLinkedListNode(Integer d, DVLinkedListNode n) {
		this.data = d;
		this.next = n;
	}
	
	DVLinkedListNode() {
		this.data = 0;
		this.next = null;
	}
}
