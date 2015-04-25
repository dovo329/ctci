package DVQuestion2_7;

import java.util.Random;
import java.util.Stack;

public class DVQuestion {

	public static final int randSeed = 7;
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
	
	public static DVLinkedListNode makeRandomPalindrome(int size) {
		int nodeIndex = 0;
		Stack <Integer> stack = new Stack <Integer> ();
		int newData = randInt(0,10);
		stack.push(newData);
		System.out.printf("pushing %d at node index %d\n", newData, nodeIndex);
		DVLinkedListNode start = new DVLinkedListNode(newData, null);
		DVLinkedListNode cur = start;
		nodeIndex++;
		int middleIndex = ((size % 2) == 1) ? ((size/2) + 1) : (size/2);
		
		for (int i=1; i<size/2; i++) {
			newData = randInt(0,10);
			stack.push(newData);
			System.out.printf("pushing %d at node index %d\n", newData, nodeIndex);
			cur.next = new DVLinkedListNode(newData, null);
			cur = cur.next;
			nodeIndex++;
		}
		if (size%2 == 1) {
			// odd number of elements in linked list.
			cur.next = new DVLinkedListNode(newData, null);
			cur = cur.next;
			System.out.printf("middle node, not pushing %d at node index %d\n", newData, nodeIndex);
			nodeIndex++;
		}
		for (int i=middleIndex; i<size; i++) {
			newData = stack.pop();
			System.out.printf("popping %d at node index %d\n", newData, nodeIndex);
			cur.next = new DVLinkedListNode(newData, null);
			cur = cur.next;
			nodeIndex++;
		}
		
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
	
	public static DVLinkedListNode getNodeInLinkedList(DVLinkedListNode n, int destIndex)
	{
		for (int i=0; i<destIndex && n != null; i++) {
			n = n.next;
		}
		return n;
	}

	public static boolean isPalindrome(DVLinkedListNode n) 
	{
		Stack <Integer> stack = new Stack<Integer>();
		
		DVLinkedListNode slowPtr = n;
		DVLinkedListNode fastPtr = n;
		
		int i=0;
		
		while (slowPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
			System.out.printf("node #: %d slowPtr.data == %d\n", i, slowPtr.data);
			stack.push(slowPtr.data);
			slowPtr = slowPtr.next;
			i++;
			fastPtr = fastPtr.next.next;
		}
		if (fastPtr.next == null) {
			// odd number of elements in linked list
			System.out.printf("odd number of elements in linked list\n");			
		} else {
			System.out.printf("even number of elements in linked list\n");
			stack.push(slowPtr.data);
			System.out.printf("node #: %d slowPtr.data == %d\n", i, slowPtr.data);
		}
		slowPtr = slowPtr.next; // ignore odd numbered middle element as there is nothing to compare with it for a palindrome
		i++;
		
		// go through reset of linked list and compare
		while (slowPtr != null) {
			System.out.printf("node #: %d slowPtr.data == %d\n", i, slowPtr.data);
			if (slowPtr.data != stack.pop()) {
				return false;
			}
			slowPtr = slowPtr.next;
			i++;
		}
		return true;
	}
	
	public static void main (String [] args) {
		int len = randInt(7,8);
		System.out.printf("len=%d; ", len);
		DVLinkedListNode n1=makeRandomPalindrome(len);
		//DVLinkedListNode n1=makeRandomLinkedList(len);
		System.out.printf("n1: ");
		printLinkedList(n1, len*2);
		if (isPalindrome(n1)) {
			System.out.printf("indeed is a palindrome");
		} else {
			System.out.printf("is not a palindrome");
		}
	}
}
