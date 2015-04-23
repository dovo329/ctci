package Question2_1;

import Question2_1.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class Question {

	public static void removeDuplicatesLinkedList(Node <Integer> n) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		Node <Integer> prev = null;
		while (n != null) {			
			System.out.printf("node=%s\n", n.toString());
			if (hashSet.contains(n.getData())) {
				//duplicate, must remove
				System.out.printf("removing duplicate\n");
				prev.setNext(n.getNext());				
			} else {
				hashSet.add((Integer)n.getData());
				System.out.printf("no duplicate, adding %d to hashSet\n", (Integer)n.getData());
				prev = n;
			}				
			n = n.getNext();
		}
	}
	
	public static void traverseLinkedList(Node n) {
		while (n != null) {
			System.out.printf("node=%s\n", n.toString());
			n = n.getNext();
		}
	}
	
	public static int randInt(int min, int max) {
		Random r = new Random();
		if (max < min) {
			System.out.printf("Oh no! an error in randInt because max < min\n");
		}
		int returnInt = r.nextInt(max-min)+min;
		System.out.printf("returnInt=%d\n", returnInt);
		return returnInt;
	}
	
	public static void main (String [] args) {
		System.out.printf("Hello World\n");
		
		Node<Double> testNode = new Node<Double>(9.0187, null);
		System.out.printf("testNode=%s\n", testNode.toString());
		
		ArrayList<Node> nodeArr = new ArrayList<>();
		Node<Integer> prevNode = null;
		/*for (int i=0; i<10; i++) {
			nodeArr.add(i, null);
		}*/
		for (int i=9; i>=0; i--) {
			nodeArr.add(new Node<Integer>(randInt(0,9), prevNode));
			//nodeArr.add(new Node<Integer>(i, prevNode));
			prevNode = nodeArr.get((9-i));
		}
		
		/*for (int i=0; i<nodeArr.size(); i++) {
			System.out.printf("nodeArr[%d]=%s\n", i, nodeArr.get(i));
		}*/
		traverseLinkedList(nodeArr.get(nodeArr.size()-1));
		System.out.printf("\n\n");
		removeDuplicatesLinkedList(nodeArr.get(nodeArr.size()-1));
		System.out.printf("\n\nAfter removing duplicates\n\n");
		traverseLinkedList(nodeArr.get(nodeArr.size()-1));
	}
}

/*package Question2_1;

import java.util.HashSet;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {
	public static void deleteDupsA(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Int)eger>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static void deleteDupsC(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			LinkedListNode runner = head;
			while (runner != current) { 
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					// We know we can't have more than one dup preceding
					// our element since it would have been removed 
					// earlier.
				    break;
				}
				runner = runner.next;
			}
			
			// If runner == current, then we didn't find any duplicate 
			// elements in the previous for loop.  We then need to 
			// increment current.  
			// If runner != current, then we must have hit the �break� 
			// condition, in which case we found a dup and current has
			// already been incremented.
			if (runner == current) {
				previous = current;
		        current = current.next;
			}
		}
	}
	
	public static void deleteDupsB(LinkedListNode head) {
		if (head == null) return;
		
		LinkedListNode current = head;
		while (current != null) {
			// Remove all future nodes that have the same value
			LinkedListNode runner = current;
			while (runner.next != null) { 
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}	
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		LinkedListNode clone = head.clone();
		deleteDupsA(head);
		System.out.println(head.printForward());
		deleteDupsC(clone);
	}
}
*/
