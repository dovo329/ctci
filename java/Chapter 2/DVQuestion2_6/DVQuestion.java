package DVQuestion2_6;

import java.util.Random;
import java.util.HashSet;

public class DVQuestion {

	public static final int randSeed = 125;
	//public static Random r = new Random(randSeed);
	public static Random r = new Random();
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
		for (int i=circStartIndex; i<size-1; i++) {
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
	
	/*public static int detectCircleStartNode(DVLinkedListNode n)
	{
		HashSet<DVLinkedListNode> nodeSet = new HashSet<DVLinkedListNode>(); 
		int circStartI = 0;
		while (n!=null && !nodeSet.contains(n)) {
			nodeSet.add(n);
			circStartI++;
			n=n.next;
		}
		return circStartI;
	}*/
	
	public static int detectCircleStartNode(DVLinkedListNode n)
	{
		DVLinkedListNode head = n;
		DVLinkedListNode slowPtr = n;
		DVLinkedListNode fastPtr = n;
		int k=1;
		
		if (slowPtr.next == null || fastPtr.next.next == null) {
			return -1;
		} else {
			do {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
				
				if (slowPtr == null || fastPtr == null) {
					return -1;
				}
			} while (slowPtr != fastPtr);
			// slow and fast ptr should now be "k" nodes away from the node at the start of the loop
			// through some fancy derivation
			// the definition of k is how many nodes from head the loop starts
			// so if we advance the slowPtr and the head ptr then when they collide is the start of the loop
			
			while (head != slowPtr) {
				head = head.next;
				slowPtr = slowPtr.next;
				k++;
			}
			return k;
		}
	}
	
	public static DVLinkedListNode getNodeInLinkedList(DVLinkedListNode n, int destIndex)
	{
		for (int i=0; i<destIndex && n != null; i++) {
			n = n.next;
		}
		return n;
	}

	public static void main (String [] args) {
		int k = randInt(3,4); // k is how many nodes before loop starts
		int loopLen = randInt(3,4);
		DVLinkedListNode n1=makeRandomCircularLinkedList(k+loopLen, k);
		System.out.printf("k=%d; loopLen=%d; ", k, loopLen);
		System.out.printf("n1: ");
		printLinkedList(n1, k+(loopLen*2));
		int circStartIndex = detectCircleStartNode(n1);
		DVLinkedListNode startCircNode = getNodeInLinkedList(n1, circStartIndex);
		System.out.printf("circle start node is node %d which is value %d\n", circStartIndex, startCircNode.data);
	}
}
