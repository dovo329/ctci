package DVQuestion2_7;

//public class DVLinkedListNode implements Cloneable {	
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
	
	/*public DVLinkedListNode clone() {
		try {
			return (DVLinkedListNode) super.clone();
		} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
			throw new RuntimeException();
		}
		//DVLinkedListNode cloneNode = new DVLinkedListNode(this.data, this.next);
		//return cloneNode;
	}*/
	
	public String toString() {
		return String.format("data=%d, next=%s", this.data, (this.next==null)?"null":"not null");
	}
}
