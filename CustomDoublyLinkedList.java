package JavaLearn;

public class CustomDoublyLinkedList {
	static MyDoublyLinkedList  myDoublyLinkedList;
	public static void main(String[] args) {
		myDoublyLinkedList = new MyDoublyLinkedList();
		int[] arr = new int[]{ 10, 15, 20, 25, 30, 35, 40, 45, 50};
		for(int x: arr) {
			myDoublyLinkedList.insertNodeDoubleInTheEnd(x);
		}
		myDoublyLinkedList.printDoublyLinkedList();
		testDelete();
		int length =myDoublyLinkedList.countNodeInDoublyLinkedList();
		System.out.println("length of the list is "+length);
	}
	
	public static void testDelete () {
		myDoublyLinkedList.deleteANode(19);
		myDoublyLinkedList = new MyDoublyLinkedList();
		myDoublyLinkedList.insertNodeDoubleInTheBeginning(4);
		myDoublyLinkedList.printDoublyLinkedList();
		myDoublyLinkedList.deleteANode(1);
		myDoublyLinkedList.insertNodeDoubleInTheBeginning(2);
		myDoublyLinkedList.insertNodeDoubleInTheBeginning(7);
		myDoublyLinkedList.printDoublyLinkedList();
		myDoublyLinkedList.deleteANode(2);
		myDoublyLinkedList.printDoublyLinkedList();
	}

}

class MyDoublyLinkedList{
	
	public NodeDouble head;
	public NodeDouble tail;
	
	public void insertNodeDoubleInTheEnd(int data) {
		System.out.println("insertNodeDoubleInTheEnd "+data);
		NodeDouble newNode = new NodeDouble(data); //creating new node for the new node to be added at the end
		NodeDouble temp = head;
		if(head==null) {
			System.out.println("head is null, making "+data+" head and tail");
			head = newNode;
			tail = newNode;
		} else {
			System.out.println("Adding after "+tail.data);
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public void insertNodeDoubleInTheBeginning(int data) {
		NodeDouble newNode = new NodeDouble(data);
		if(head==null) {
			System.out.println("head is null, making "+data+" head and tail");
			head = newNode;
			tail = newNode;
		} else {
			System.out.println("Adding before "+head.data);
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}	
	}
	
	public void insertBeforeAGivenNode(int nodeNumber, int data) {
		NodeDouble newNode = new NodeDouble(data);
		NodeDouble node = getNodeAtNumber(nodeNumber);
		if(node == null) {
			return;
		}
		NodeDouble prevNode = node.prev;
		if(prevNode == null) {
			System.out.println("No prev node");
			newNode.next = node;
			node.prev = newNode;
			head = newNode;
		} else {
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = node;
			node.prev = newNode;
		}
	}
	
	public void deleteANode(int nodeNumber) {
		NodeDouble nodeToDelete = getNodeAtNumber(nodeNumber);
		if(nodeToDelete == null) {
			return;
		}
		NodeDouble prevNode = nodeToDelete.prev;
		NodeDouble nextNode = nodeToDelete.next;
		if(prevNode == null && nextNode == null) {
			// There is only one node
			System.out.println("Single node in the list");
			System.out.println("Deleting head and tail "+nodeToDelete.data);
			head = null;
			tail = null;
		} else if(prevNode == null) {
			//The head node should be deleted
			System.out.println("Deleting node "+head.data);
			head = head.next;
			head.prev = null;
		} else if (nextNode == null) {
			// The tail node should be deleted
			System.out.println("Deleting node "+tail.data);
			tail = tail.prev;
			tail.next = null;
		} else {
			System.out.println("Deleting Node "+nodeToDelete.data);
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
	}
	
	private NodeDouble getNodeAtNumber(int nodeNumber) {
		NodeDouble temp = head;
		
		for(int i=1; i<nodeNumber;i++) {
			if(temp == null) {
				System.out.println("Not enough nodes");
				return null;
			}
			temp = temp.next;
		}
		return temp;
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
		System.out.println("Print from start to end");
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
		System.out.println("Print from end to start");
		temp = tail;
		String result = "";
		while(temp != null) {
			if(result.equals("")) {
				result = temp.data+"";
			} else {
				result = temp.data +" <- "+ result;
			}
			temp = temp.prev;
		}
		System.out.println(result);
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
		
		@Override
		public void finalize() {
			/**
			 * The finalize method is called when an object is about to get garbage collected. 
			 * That can be at any time after it has become eligible for garbage collection. 
			 * Note that it's entirely possible that an object never gets garbage collected 
			 * (and thus finalize is never called)
			 */
			System.out.println("Node "+data+" will now be garbage collected");
		}
}
}
