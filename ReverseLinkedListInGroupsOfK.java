package JavaLearn;

import JavaLearn.CustomLinkedListPractice;

/**
 * 
 * The problem is about reversing nodes in groups of K of a linked list of size N. If there are 
 * some nodes remaining in the end which do not form a group of size k, keep them unreversed.
 */
public class ReverseLinkedListInGroupsOfK {
	public static void main(String[]args) {
		MyLinkedList2 mylist = new MyLinkedList2();
		mylist.insertNodeAtEnd(1);
		mylist.insertNodeAtEnd(2);
		mylist.insertNodeAtEnd(3);
		mylist.insertNodeAtEnd(4);
		mylist.insertNodeAtEnd(5);
		mylist.insertNodeAtEnd(6);
		mylist.insertNodeAtEnd(7);
		mylist.insertNodeAtEnd(8);
		mylist.insertNodeAtEnd(9);
		mylist.insertNodeAtEnd(10);
		mylist.insertNodeAtEnd(11);
		
		
		mylist.printList();
		mylist.reverseK(3);
		mylist.printList();
	}

}


class MyLinkedList2 {
	
	public Node head;
	
	public void insertNodeAtEnd(int data) {
		
		// List is empty, head should be modified
		if(head == null) {
			head = new Node(data);
			return;
		} 
		
		// otherwise traverse to the end and insert
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
	}
	
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data +"->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/**
	 * This algorithm visits each node only once. Time complexity O(N).
	 */
	public void reverseK(int k) {
		if(head == null) {
			return;
		}
		// no rotations for k <= 1
		if (k <= 1) {
			return;
		}
		// number of times we will rotate the nodes
		int countRotations = findSize()/k;
		// pointers to alter links
		Node prev = null, current = head , next = current.next;
		Node start = null;
		
		// count keeps track of nodes to be reversed in a set of k
		int count=0;
		
		while(current != null && countRotations>0) {
			
			/**
			 * Reverse links between current and previous node
			 */
			current.next = prev;
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
			count++;
			
			if(count == k) {
				if(start == null) {
					start = head;
					head.next = current;
					head = prev;
				} else {
					Node temp = start.next;
					if(start.next != null) {
						start.next.next = current;
					}
					start.next = prev;
					start = temp;
				}
				prev = current;
				current = next;
				if(next != null) {
					next = next.next;
				}
				count = 1;
				countRotations--;
			}
		}
		
	}
	
	/**
	 * This algorithm visits each node twice. Time complexity is still O(N).
	 */
	public void reverseK2(int k) {
		// no rotations for k <= 1
		if (k <= 1) {
			return;
		}
		// number of times we will rotate the nodes
		int countRotations = findSize()/k;
		
		// pointers to manipulate links
		Node start = head, end=head;
		Node before = null;
		while(countRotations > 0) {
			countRotations--;
			for(int i=0; i<k;i++) {
				end = end.next;
			}
			
			Node firstNode = reverseTheListWithoutRecursion(start, end);
			if(before != null) {
				before.next = firstNode;
			} else {
				head = firstNode;
			}
			start.next = end;
			before = start;
			start = end;
			
		}
		
	}
	
	public Node reverseTheListWithoutRecursion(Node start, Node end) {
		
		Node before, current, after;
		before = start;
		current = before.next;
		after = current.next;
		while (current != end) {
			current.next = before;
			before = current;
			current = after;
			if(after != null) {
				after = after.next;
			}
		}
		return before;
	}
	
	private int findSize() {
		int size=0;
		Node temp = head;
		while(temp != null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
}
