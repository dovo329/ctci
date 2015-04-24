package DVQuestion2_4;

import DVQuestion2_4.*;
import java.util.Random;

public class DVQuestion {

	public static final int randSeed = 2;
	public static Random r = new Random(randSeed);
	
	public static int randInt(int min, int max) {
		r.nextInt();
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
		if (n==null) {
			System.out.printf("printLinkedList: first node is null");
		}
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
	// 1 -> 3 -> 1 -> 2 -> 4
	// for partition node of 3
	// 1 -> 1 -> 2 -> 3 -> 4
	// insert before or after current node?  to left of to right of
	// have to know if we've encountered the partition node yet?
	//
	// first step
	// 1 -> 3 -> 1 -> 2 -> 4 
	// 1 -> 1 -> 3 -> 2
	// swaps next and current nodes to move to right in linked list
	//
	/*public static void partitionAround(int partitionData, DVLinkedListNode n)
	{
		DVLinkedListNode prev = null;
		DVLinkedListNode next = null;
		DVLinkedListNode cur = n;
		DVLinkedListNode temp;
		int i=0;
		while (cur != null && i < 5) {
			System.out.printf("before: ");
			printLinkedList(n);
			next = cur.next;
			if (cur.data < partitionData) {
				// do nothing, it's already on the left of partitionData
				System.out.printf("iteration %d do nothing, node is already on left of partitionData\n", i);
			} else {
				
				// swap cur and next places
				System.out.printf("iteration %d swap current and next nodes\n", i);				
				if (prev != null) {
					System.out.printf("before prev.data = %d; cur.data = %d; next.data = %d\n", prev.data, cur.data, next.data);					
					prev.next = next;
					temp = new DVLinkedListNode(next.next.data, next.next.next);
					next.next = cur;
					cur.next = temp;					
					System.out.printf("after swap prev.data = %d; cur.data = %d; next.data = %d\n", prev.data, cur.data, next.data);
					System.out.printf("after swap prev.next = %s; cur.next = %s; next.next = %s\n", (prev.next==null)?"null":"notNull", (cur.next==null)?"null":"notNull", (next.next==null)?"null":"notNull");
				} else {
					System.out.printf("before cur.data = %d; next.data = %d\n", cur.data, next.data);
					temp = new DVLinkedListNode(next.data, next.next);
					next.next = cur;
					cur = temp;
					n = next;
					System.out.printf("after swap cur.data = %d; next.data = %d\n", cur.data, next.data);
					System.out.printf("after swap cur.next = %s; next.next = %s\n", (cur.data==null)?"null":"notNull", (next.next==null)?"null":"notNull");
				}
				System.out.printf("after: ");
				printLinkedList(n);
				
			}
			prev = cur;
			cur = next;
			i++;			
		}
	}*/
	
	// 1 -> 3 -> 1 -> 2 -> 4
	// make two new linked lists and either add to one or the other, then join both linked lists at the end
	//
	public static void partitionAround(int partitionData, DVLinkedListNode n, DVLinkedListPair pairLL)
	{
		DVLinkedListNode ltLLrun = null;
		DVLinkedListNode geLLrun = null;
		
		int i=0;
		while (n != null) {
			if (n.data < partitionData) {
				if (pairLL.ltLL == null) {
					pairLL.ltLL = new DVLinkedListNode(n.data, null);
					ltLLrun = pairLL.ltLL;
					System.out.printf("started ltLL with %s: ", n.toString());
				} else {
					// add n to ltLL
					ltLLrun.next = new DVLinkedListNode(n.data, null);
					ltLLrun = ltLLrun.next;
					System.out.printf("added to ltLL %s: ", n.toString());
				}
				printLinkedList(pairLL.ltLL);
			} else {
				if (pairLL.geLL == null) {
					pairLL.geLL = new DVLinkedListNode(n.data, null);
					geLLrun = pairLL.geLL;
					System.out.printf("started geLL with %s: ", n.toString());
				} else {
					// add n to ltLL
					geLLrun.next = new DVLinkedListNode(n.data, null);
					geLLrun = geLLrun.next;
					System.out.printf("added to geLL %s: ", n.toString());					
				}
				printLinkedList(pairLL.geLL);
			}
			n = n.next;
			i++;			
		}
	}
	
	public static void main (String [] args) {
		DVLinkedListNode n=makeRandomLinkedList(10);
		System.out.println("Before partitioning");
		printLinkedList(n);
		System.out.println("partitioning...");
		//DVLinkedListNode ltLL = null;
		//DVLinkedListNode geLL = null;
		DVLinkedListPair pairLL = new DVLinkedListPair(null, null);
		partitionAround(5, n, pairLL);
		System.out.printf("pairLL.ltLL: ");
		printLinkedList(pairLL.ltLL);
		System.out.printf("pariLL.geLL: ");
		printLinkedList(pairLL.geLL);
	}
}
