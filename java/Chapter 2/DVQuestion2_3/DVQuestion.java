package DVQuestion2_3;

import DVQuestion2_3.*;
import java.util.Random;

public class DVQuestion {

	public static int randInt(int min, int max) {
		Random r = new Random();
		return (int)r.nextInt(max-min+1) + min;
	}
	
	public static DVLinkedListNode makeRandomLinkedList(int size) {
		DVLinkedListNode start = new DVLinkedListNode(randInt(0,10), null);
		DVLinkedListNode cur = start;
		
		for (int i=0; i<size; i++) {
			cur.next = new DVLinkedListNode(randInt(0,10), null);
			cur = cur.next;
		}
		
		return start;
	}
	
	public static DVLinkedListNode findKthToLastElement(int k, DVLinkedListNode n, IntWrapper numIter) {
		DVLinkedListNode runner1 =  n;
		DVLinkedListNode runner2 =  n;
		
		numIter.value = 0;
		// advance runner2 a fixed "k" number of nodes ahead of runner 1
		for (int i=0; i<k; i++) {
			if (runner2 == null) {
				return null;
			}
			runner2 = runner2.next;			
		}
		// now advance to the end of the list, incrementing both runner1 and runner2, until runner2 reaches end of list
		// then runner1 will be at the kth to last element of the list
		while (runner2 != null) {
			runner1 = runner1.next;
			runner2 = runner2.next;
			numIter.value++;
		}
		return runner1;
	}
	
	public static void printLinkedList(DVLinkedListNode n) {
		int i=0;
		while (n != null) {
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

	public static DVLinkedListNode advanceXNodesInLinkedList(int x, DVLinkedListNode n)
	{
		int i=0;
		while (n != null && i<x) {
			n = n.next;
			i++;
		}
		return n;
	}
	
	public static boolean deleteNodeInMiddleOfSinglyLinkedList(DVLinkedListNode n) {
		DVLinkedListNode nNext = n.next;
		if (n==null) {
			return false;
		} else if (nNext==null) {
			n.data = 97238947;
			n.next = null;
			n = null;
			return true;
		} else {
			n.data = nNext.data;
			n.next = nNext.next;
			return true;
		}
	}
	
	public static void main (String [] args) {				
		DVLinkedListNode n=makeRandomLinkedList(10);
		System.out.println("Before deleting mid element");
		printLinkedList(n);
		
		DVLinkedListNode midNode = advanceXNodesInLinkedList(10, n);
		System.out.printf("midNode = %d\n", midNode.data);
		if (!deleteNodeInMiddleOfSinglyLinkedList(midNode))
		{
			System.out.println("midNode was too close to the end of the linked list to delete it");
		}
		System.out.println("After deleting mid element");
		printLinkedList(n);		
	}
}
