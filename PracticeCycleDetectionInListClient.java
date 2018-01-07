package JavaLearn;

import java.util.Random;

public class PracticeCycleDetectionInListClient {
	static final int NODE_COUNT = 15;
	public static void main(String[]args) {
		
		// we will create 20 nodes cyclic list
		Random random = new Random();
		CyclicLinkedList list = new CyclicLinkedList();
		for(int i = 1; i<= NODE_COUNT; i++) {
			int data = random.nextInt(100);
			list.insertNodeInTheEnd(data);
		}
		list.makeListCyclic(NODE_COUNT/2);
		list.printCyclicList(NODE_COUNT*2);
		System.out.println("is cycle present?"+list.detectCycle());
		System.out.println("Count of Nodes in the cycle "+list.countNodesInCycle());
		list.makeListAcyclic();
		list.printList();
	}
}


class CyclicLinkedList extends MyLinkedList {
	
	/**
	 * If the list contains a cycle then this node will hold reference of one node in the cycle
	 */
	Node meetingPoint;
	
	int countOfNodesInCycle;
	
	/**
	 * Checks if the list has a cycle using hare and tortoise algo
	 */
	public boolean detectCycle() {
		Node hare = head;
		Node tortoise = head;
		// need to check if hare != null and hare.next != null, because we are trying to access hare.next.next
		while (hare != null && hare.next != null) {
			// if hare can catch tortoise, then we have found the cycle
			if(hare.next.next == tortoise) {
				meetingPoint = tortoise;
				System.out.println("List is cyclic, meeting point "+meetingPoint.data);
				return true;
			} else {
				// we have still not found the cycle, each animal moves by their respective steps
				hare = hare.next.next;
				tortoise = tortoise.next;
				System.out.println("Hare: "+hare.data+" Tortoise "+tortoise.data);
			}
		}
		// The list terminates at null. There are no cycles
		return false;
	}
	
	/**
	 * Count the number of nodes in the cycle
	 */
	public int countNodesInCycle() {
		if(meetingPoint == null) {
			System.err.println("No cycle in the list or meetingPoint not set");
			return 0;
		}
		Node temp = meetingPoint;
		int count = 0;
		/**
		 * Notice the loop condition temp != meetingPoint will be false in the beginning. This is why
		 * while loop is not preferred for this. do while loop will check the condition after executing the
		 * loop body at least once. This means the loop condition will not be false after the first run in
		 * do while loop.
		 */
		do {
			temp = temp.next;
			count++;
		} while (temp != meetingPoint);
		countOfNodesInCycle = count;
		return count;
	}
	
	/**
	 * Point the last node of the cyclic list to null
	 */
	public void makeListAcyclic() {
		/**
		 * We have to find the first node of the cycle. Then we will use it to find the last node of the cycle. The last node is the one which points to the
		 * first node. After we get the last node, we just point the last node to null
		 */
		Node p1 = head;
		Node p2 = head;
		// The difference between p2 and p1 should be n. Since p1 is at 1, p2 should be at n+1, => p2 - p1 = n
		for(int i=2; i<=countOfNodesInCycle+1; i++) {
			//i=1 corresponds to p2 = head. Dry run for better understanding on why after this loop p2 is the n+1 th node
			p2 = p2.next;
		}
		while(p1 !=  p2) {
			//p1 and p2 each move one at a time
			System.out.println("p1 -"+p1.data+" p2 -"+p2.data);
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("P1 and P2 meet at node "+p1.data);
		//start of the cycle is at p1. We need to find the last node in the cycle, which is the node that points to p1
		Node temp = p1;
		do {
			temp = temp.next;
		} while(temp.next != p1); // we want to stop the temp pointer exactly one node before p1, in the cycle
		System.out.println("Last node of the acyclic list: "+temp.data);
		temp.next = null;
	}
	
	/**
	 * Make the list cyclic
	 * @param nodeNumber the node to which the last node of the list should point. Starts with 1
	 */
	public void makeListCyclic(int nodeNumber) {
		Node nodeToConnect  = head;
		while(nodeNumber > 1) {
			nodeToConnect  = nodeToConnect .next;
			nodeNumber --;
		}
		
		Node lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next =nodeToConnect;
	}
	
	/**
	 * Print cyclic list
	 * @param howManyNodes number of nodes to print
	 */
	public void printCyclicList(int howManyNodes) {
		System.out.println("printCyclicList");
		Node temp = head;
		for(int i=1; i<=howManyNodes; i++) {
			if(i == howManyNodes) {
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data+"->");
			}
			temp = temp.next;
		}
		System.out.println();
	}
}