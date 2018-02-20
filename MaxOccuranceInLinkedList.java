package JavaLearn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//https://www.geeksforgeeks.org/maximum-occurring-character-linked-list/

public class MaxOccuranceInLinkedList {
	public static void main(String[] args) {

		LinkedListOperations listOperations = new LinkedListOperations();
		listOperations.addNodeInEnd('g');
		listOperations.addNodeInEnd('e');
		listOperations.addNodeInEnd('e');
		listOperations.addNodeInEnd('k');
		listOperations.addNodeInEnd('s');

		listOperations.printList();

		int result = listOperations.findMaxOccurance();
		System.out.println(" ");
		System.out.println(result);
	}
}

class ListNode {
	char data;
	ListNode next;

	public ListNode(char value) {
		// TODO Auto-generated constructor stub
		data = value;
		next = null;
	}
}

class LinkedListOperations {
	
	// very imp
	public ListNode head;
	HashMap<Character, Integer> hMap = new HashMap<>();
	int val, freq;

	public int findMaxOccurance() {

		ListNode temp = head;
		if (head == null)
			System.out.print("null list");
		while (temp.next != null) {
			if (hMap.containsKey(temp.data)) {
				val = hMap.get(temp.data);
				hMap.put(temp.data, ++val);
			} else {
				hMap.put(temp.data, 1);
			}
			temp = temp.next;
		}

		Iterator entry = hMap.entrySet().iterator();
		while (entry.hasNext()) {
			Map.Entry entry1 = (Map.Entry) entry.next();
			// char key = (Character)entry.getKey();
			Integer value = (Integer) entry1.getValue();
			//System.out.print(" "+value+" ");
			if (freq < value)
				freq = value;
        System.out.print(hMap);
		}
		return freq;
	}

	public void printList() {
		if (head == null)
			System.out.print("List is empty");
		ListNode temp = head;
		while (temp != null) {
			if (temp.next == null) {
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data + " -> ");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	public void addNodeInEnd(char c) {
		ListNode temp = new ListNode(c);

		if (head == null)
			head = temp;

		else {
			ListNode temp1 = head;
			while (temp1.next != null) {
				temp1 = temp1.next;
			}
			temp1.next = temp;
		}
	}
}