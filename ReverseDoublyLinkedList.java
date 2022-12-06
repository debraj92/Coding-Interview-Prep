package JavaLearn;

import JavaLearn.MyDoublyLinkedList.NodeDouble;

public class ReverseDoublyLinkedList {
	public static void main (String[]args) {
		MyDoublyLinkedList dll = new MyDoublyLinkedList();
		for (int i=1; i<=10; i++) {
			dll.insertNodeDoubleInTheEnd(i);
		}
		printDLL(dll);
		reverseDLL(dll);
		printDLL(dll);
	}
	
	public static void reverseDLL (MyDoublyLinkedList dll) {
		System.out.println();
		System.out.println("REVERSING DLL");
		NodeDouble t = dll.head;
		NodeDouble temp;
		/**
		 *  For each node we swap the next and prev pointers.
		 */
		while(t != null) {
			temp = t.next;
			t.next = t.prev;
			t.prev = temp;
			// notice when t becomes null dll.head will point to the last element.
			dll.head = t;
			// since the next node is now in prev, we have to move to the next node using the prev pointer
			t = t.prev;
		}
	}
	
	public static void printDLL(MyDoublyLinkedList dll) {
		NodeDouble t = dll.head;
		for(; t!=null; t=t.next) {
			System.out.println(t.data);
		}
	}
}
