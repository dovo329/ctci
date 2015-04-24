package DVQuestion2_3;

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
