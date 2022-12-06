package JavaLearn;

public class CustomLinkedListPractice {
	public static void main(String[]args) {
		MyLinkedList list = new MyLinkedList();
		System.out.println("Inserting Nodes in the beginning");
		list.insertNodeInTheBeginning(7);
		list.printList();
		list.insertNodeInTheBeginning(5);
		list.printList();
		list.insertNodeInTheBeginning(3);
		list.printList();
		System.out.println("Inserting Nodes in the end");
		list.insertNodeInTheEnd(10);
		list.printList();
		list.insertNodeInTheEnd(16);
		list.printList();
		list.insertNodeInTheEnd(35);
		list.printList();
		System.out.println("Deleting from the beginning");
		list.deleteNodeFromTheBeginning();
		list.printList();
		System.out.println("Size of the linked list (recursion): "+ list.findLengthOfTheListWithRecursion());
		System.out.println("Size of the linked list: "+list.findLengthOfTheList());
		System.out.println("Reversing the linked list");
		list.reverseTheListWithRecursion();
		list.printList();
		
		/*
		System.out.println("Deleting in the end");
		list.deleteNodeInTheEnd();
		list.printList();
		list.reverseTheListWithoutRecursion();
		list.printList();
		*/
	}
}

class MyLinkedList {
	// Since clients should not know about head of the linked list, we want to make the head private member variable
	public Node head;
	
	public void insertNodeInTheBeginning(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			/**
			 * []        []-[]-[]-[]-[]-|null
			 * node     head
			 * We want to point node.next to current head and change head to node
			 * 
			 * After the change:
			 * []--------[]-[]-[]-[]-[]-|null
			 * head
			 */
			node.next = head;
			head = node;
		}
		/**
		 * Notice inserting node in the beginning takes constant time operation to add a new node
		 */
	}
	
	public void insertNodeInTheEnd(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			/**
			 * []-[]-[]-[]-[]-|null     []
			 * head        last         node
			 * We want to point last.next to the node to be added. For this we need to find the last by iterating through the list  
			 * 
			 * After the change:
			 * []-[]-[]-[]-[]-----------[]-|null
			 * head                     node
			 */
			
			Node temp = head; // Now temp points to the same node as head. Since we don't want to change the head while traversing the list
			// this extra variable will solve the purpose. We will just assign the reference of each node to temp in the process of traversal
			while(temp.next != null) {
				// The switching of node in temp by following the next pointer is absolutely crucial
				temp = temp.next;
			}
			//After this loop is exited, temp stops at the last node
			temp.next = node; // done, node added in the end
		}
		/**
		 * Notice inserting node in the end takes linear time operations to add a new node
		 */
	}
	
	/**
	 *  Delete Node from the beginning
	 */
	public void deleteNodeFromTheBeginning() {
		/**
		 * Check if the list is uninitialized
		 */
		if (head == null) {
			// Null check is very important here. If this check is not present then the program will crash with a NullPointerException if head = null in the line head = head.next
			return;
		} else {
			head = head.next;
		}
	}
	
	/**
	 * Delete Node in the end
	 */
	public void deleteNodeInTheEnd() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		} else if (head.next == null) {
			System.out.println("One node");
			head = null;
		} else {
			System.out.println("Multiple nodes");
			Node temp = head;
			while(temp.next.next != null) { // single traversal
				temp = temp.next;
			}
			// temp is stopped at the last but one node
			System.out.println("Deleting node (last node): "+temp.next.data);
			temp.next = null;
		}
	}
	
	public void printList() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp != null) {
			//Notice here we want to go till temp is null and not stop at temp.next != null (WHY?)
			if(temp.next == null) {
				//for the last node we don't print the arrow
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data+" -> ");
			}
			// The switching node using temp by following the next pointer is absolutely crucial
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int findLengthOfTheList() {
		Node temp = head;
		int counter = 0;
		while(temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}
	
	/**
	 * Length of linked list using recursion.
	 * @return length of the list
	 */
	public int findLengthOfTheListWithRecursion() {
		return findLengthOfTheListWithRecursionInternal(head);
	}
	
	private int findLengthOfTheListWithRecursionInternal (Node temp) {
		return temp == null ? 0 : 1 + findLengthOfTheListWithRecursionInternal(temp.next);
	}
	
	public void reverseTheListWithRecursion() {
		Node oldHead = reverseTheListInternal(head);
		oldHead.next = null; // We need to do this. The reverseTheListInternal call returns the old head after the first recursion call returns.
		// Since the old head is still pointing to the next node, we have to explicitly point it to null. Otherwise if we try to print the list
		// we will get stuck in a cycle
	}
	
	public Node reverseTheListInternal (Node current) {
		//Terminating condition
		if(current == null) {
			return null;
		}
		/**
		 * We will recurse the list in a bottom up fashion.
		 * Bottom-up
		 * ---------
		 * Break the problem until the smallest piece is found. Then start combining the solution for each piece.
		 * 
		 * Top-Down
		 * ---------
		 * Solve the problem partially. Then in the next call solve some other parts of the problems. Here we first solve the part then we break 
		 * it into pieces
		 */
		Node nextNode = reverseTheListInternal(current.next); // we first recursively reach the last node (Bottom-up)
		if(nextNode != null) {
			/**
			 * Will represent nextNode as next
			 * []-[]-[]-[]-[]-[]-[]-[]-[]-[]-[]-[]
			 *                                  cur (<-head)
			 *                               cur next
			 *                            cur next
			 *                         cur next
			 *                         
			 * As each recursive call returns we need to point the nextNode to the current to reverse the list.
			 * Note: How we are traversing the list in a reverse order? We are using the function stack of Recursion(as I explained earlier)
			 * to travel backwards. In the process we are changing the pointers while traversing backwards.       
			 */
			nextNode.next = current;
		} else {
			//This is the last node. We need to set the head to this node as this will be our new head for the reversed list
			head = current;
		}
		return current; // returning current to the previous node. The current will appear as the nextNode to the previousNode (which will then be the new current)
	}
	
	/**
	 * Complete this method. You need to reverse the list without recursion
	 */
	public void reverseTheListWithoutRecursion() {
		System.out.println("reverseTheListWithoutRecursion");
		Node before, current, after;
		before = head;
		current = head.next;
		after = current.next;
		before.next = null;
		while (current != null) {
			current.next = before;
			before = current;
			current = after;
			if(after != null) {
				after = after.next;
			}
		}
		head = before;
	}
	
}

/**
 * Nodes of a linked list
 *
 */
class Node {
	int data;
	Node next;
	
	Node (int data) {
		// if we want to access the global "data" we need to use "this.data". "this" refers to the current object and "this.data" will mean the
		// member variable "data" present in the current object
		this.data = data;
	}
}
