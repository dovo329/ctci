package DVQuestion2_5;

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

	/*
	public static int convertLinkedListToInt(DVLinkedListNode node, boolean bigEndian) {
		Stack <Integer> stack = new Stack();
		int ax = 0;
		
		if (bigEndian) {
			while (node != null) {
				stack.push(node.data);
				node = node.next;
			}
			while (!stack.empty()) {
				ax *= 10;
				ax += stack.pop();
			}
		} else {
			while (node != null) {
				ax *= 10;
				ax += node.data;
				node = node.next;				
			}
		}
		return ax;
	}
	
	public static DVLinkedListNode convertIntToLinkedList(int num, boolean bigEndian) {
		DVLinkedListNode head = new DVLinkedListNode(num % 10, null); // get ones digit
		DVLinkedListNode tail = head, temp = head;
		Stack <Integer> stack = new Stack();
		
		int ax = num/10;
		
		if (bigEndian) {
			
		} else {
			while (ax != 0) {
				tail = new DVLinkedListNode(ax % 10, null); // get ones digit
				temp.next = tail;
				temp = tail;
				ax /= 10;
			}
		}
		return head;
	}
	*/
	
	/*public static int convertLinkedListToInt(DVLinkedListNode node, boolean bigEndian) {
		Stack <Integer> stack = new Stack();
		int ax = 0;
		
		if (bigEndian) {
			while (node != null) {
				stack.push(node.data);
				node = node.next;
			}
			while (!stack.empty()) {
				ax *= 10;
				ax += stack.pop();
			}
		} else {
			while (node != null) {
				ax *= 10;
				ax += node.data;
				node = node.next;				
			}
		}
		return ax;
	}
	
	public static DVLinkedListNode convertIntToLinkedList(int num, boolean bigEndian) {
		String numStr = String.format("%d", num);
		
		DVLinkedListNode head = new DVLinkedListNode(num, null);
				
		return head;
	}
	*/
	
	public static int convertLinkedListToInt(DVLinkedListNode node, boolean bigEndian) {
		StringBuilder numStrBld = new StringBuilder();
		
		while (node != null) {
			numStrBld.append(String.format("%d", node.data));
			node = node.next;
		}
		
		if (bigEndian) {
			numStrBld.reverse();
		}
		
		String numStr = numStrBld.toString();
		return Integer.parseInt(numStr, 10);
	}
	
	public static DVLinkedListNode convertIntToLinkedList(int num, boolean bigEndian) {
		StringBuilder numStrBld = new StringBuilder(String.format("%d", num));
		if (bigEndian) {
			numStrBld.reverse();
		}
		
		DVLinkedListNode head = new DVLinkedListNode(Integer.parseInt(numStrBld.substring(0, 1), 10), null);
		DVLinkedListNode node = head;			
		
		for (int i=1; i<numStrBld.length(); i++) {
			node.next = new DVLinkedListNode(Integer.parseInt(numStrBld.substring(i, i+1), 10), null);
			node = node.next;
		}
				
		return head;
	}
	
	public static DVLinkedListNode addLinkedListNumbers(DVLinkedListNode n1, DVLinkedListNode n2) {		
		int num1 = convertLinkedListToInt(n1, bigEndian);
		int num2 = convertLinkedListToInt(n2, bigEndian);
		
		System.out.printf("num1=%d; num2=%d; num1+num2=%d\n", num1, num2, num1+num2);
		
		DVLinkedListNode backToN1 = convertIntToLinkedList(num1, bigEndian); 
		DVLinkedListNode backToN2 = convertIntToLinkedList(num2, bigEndian); 
		System.out.printf("n1=");
		printLinkedList(backToN1);
		System.out.printf("n2=");
		printLinkedList(backToN2);
		
		return convertIntToLinkedList(num1+num2, bigEndian);
	}
	
	public static void main (String [] args) {
		DVLinkedListNode n1=makeRandomLinkedList(3);
		System.out.printf("n1: ");
		printLinkedList(n1);
		DVLinkedListNode n2=makeRandomLinkedList(3);
		System.out.printf("n2: ");
		printLinkedList(n2);
		
		DVLinkedListNode n3 = addLinkedListNumbers(n1, n2);
		System.out.printf("n3=n1+n2: ");
		printLinkedList(n3);
	}
}
