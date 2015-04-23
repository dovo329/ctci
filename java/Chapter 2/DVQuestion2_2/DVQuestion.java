package DVQuestion2_2;

import DVQuestion2_2.*;
import java.util.Random;

/**
 * @author douglas
 *
 */
/**
 * @author douglas
 *
 */
/**
 * @author douglas
 *
 */
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
	
	public static DVLinkedListNode findKthToLastElement(int k, DVLinkedListNode n) {
		DVLinkedListNode runner1 =  n;
		DVLinkedListNode runner2 =  n;
		
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
	
	public static void main (String [] args) {
		System.out.println("Hello World!!!");
		
		DVLinkedListNode n=makeRandomLinkedList(10);
		printLinkedList(n);
		int k = 3;
		DVLinkedListNode kthToEndNode = findKthToLastElement(k, n);
		System.out.printf("%d ToEndNode is %d\n", k, kthToEndNode.data);
	}
}
