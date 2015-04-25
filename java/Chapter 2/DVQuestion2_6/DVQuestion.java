package DVQuestion2_6;

import java.util.Random;

public class DVQuestion {

	public static final int randSeed = 2;
	public static Random r = new Random(randSeed);
	public static boolean bigEndian = true;
	
	public static int randInt(int min, int max) {
		r.nextInt();
		return (int)r.nextInt(max-min+1) + min;
	}
	
	public static DVLinkedListNode makeRandomLinkedList(int size) {
		DVLinkedListNode start = new DVLinkedListNode(randInt(0,10), null);
		DVLinkedListNode cur = start;
		
		for (int i=0; i<size-1; i++) {
			cur.next = new DVLinkedListNode(randInt(0,10), null);
			cur = cur.next;
		}
		
		return start;
	}
	
	public static DVLinkedListNode makeRandomCircularLinkedList(int size, int circStartIndex) {
		DVLinkedListNode start = new DVLinkedListNode(randInt(0,10), null);
		DVLinkedListNode cur = start;
		DVLinkedListNode circNode = null;
		
		for (int i=1; i<circStartIndex; i++) {
			cur.next = new DVLinkedListNode(randInt(0,10), null);
			cur = cur.next;
		}
		circNode = cur;
		for (int i=circStartIndex; i<size; i++) {
			cur.next = new DVLinkedListNode(randInt(0,10), null);
			cur = cur.next;
		}
		cur.next = circNode;
		
		return start;
	}
	
	public static void printLinkedList(DVLinkedListNode n, int limit) {
		int i=0;
		if (n==null) {
			System.out.printf("printLinkedList: first node is null");
		}
		while (n != null && i < limit) {
			System.out.print(i+":");
			System.out.print(n.data);
			n = n.next;
			i++;
			if (n != null) {
				System.out.print("->");
			}			
		}	
		System.out.print("\n");
	}

	public static void main (String [] args) {
		DVLinkedListNode n1=makeRandomCircularLinkedList(10, 5);
		System.out.printf("n1: ");
		printLinkedList(n1, 20);
		
	}
}
