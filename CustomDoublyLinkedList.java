package JavaLearn;

public class CustomDoublyLinkedList {
	
	public static void main(String[] args) {
		MyDoublyLinkedList  myDoublyLinkedList = new MyDoublyLinkedList();
		myDoublyLinkedList.insertNodeDoubleInTheEnd(10);
		myDoublyLinkedList.insertNodeDoubleInTheEnd(50);
		myDoublyLinkedList.insertNodeDoubleInTheEnd(60);
		myDoublyLinkedList.insertNodeDoubleInTheEnd(20);
		myDoublyLinkedList.printDoublyLinkedList();
		myDoublyLinkedList.insertNodeDoubleInTheBeginning(100);
		myDoublyLinkedList.printDoublyLinkedList();
		myDoublyLinkedList.deleteNodeDoubleFromTheEnd();
		myDoublyLinkedList.printDoublyLinkedList();		
		myDoublyLinkedList.deleteNodeDoubleFromBeginning();
		myDoublyLinkedList.printDoublyLinkedList();
		
		int length =myDoublyLinkedList.countNodeInDoublyLinkedList();
		System.out.println("length of the list is "+length);
	}

}

class MyDoublyLinkedList{
	
	public NodeDouble head;
	
	public void insertNodeDoubleInTheEnd(int data) {
		NodeDouble newNode = new NodeDouble(data); //creating new node for the new node to be added at the end
		NodeDouble temp = head;
		if(head==null) {
			head = newNode;
		} else {
			while(temp.next!=null) {
				temp=temp.next;
			} 
			temp.next = newNode;
			newNode.prev = temp; 			
		}
	}
	
	public void insertNodeDoubleInTheBeginning(int data) {
		NodeDouble newNode = new NodeDouble(data);
		NodeDouble temp = head;
		if(head==null) {
			head = newNode;
		} else {
			temp.prev = newNode;
			newNode.next = temp;
			head = newNode;
		}	
	}
	
	public void deleteNodeDoubleFromTheEnd() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		} else if (head.next == null) {
			System.out.println("One node");
			head = null;
		} else {
			System.out.println("Multiple nodes");
			NodeDouble temp = head;
			while(temp.next.next != null) { 
				temp = temp.next;
			}
			System.out.println("Deleting node (last node): "+temp.next.data);
			temp.next = null;
		}		
	}
	
	public void deleteNodeDoubleFromBeginning() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		} else if (head.next == null) {
			System.out.println("One node");
			head = null;
		} else {
			System.out.println("Multiple nodes");
			head= head.next;
			head.prev=null;
		}
	}
	public int countNodeInDoublyLinkedList() {
		NodeDouble temp = head;
		int counter = 0;
		while(temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}
	public void printDoublyLinkedList() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		NodeDouble temp = head;
		while(temp != null) {
			if(temp.next == null) {
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data+" -> ");
			}
			temp = temp.next;
		}
		System.out.println();
}	
	
	class NodeDouble {
		int data;
		NodeDouble next;
		NodeDouble prev;
		
		NodeDouble (int data) {
			// if we want to access the global "data" we need to use "this.data". "this" refers to the current object and "this.data" will mean the
			// member variable "data" present in the current object
			this.data = data;
		}		
}
}
