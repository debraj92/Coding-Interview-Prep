package JavaLearn;

/**
 * https://www.techiedelight.com/add-two-linked-lists-without-using-extra-space/
 *
 * Given a linked list representation of two positive numbers, calculate and store their sum in a new list without 
 * using any extra space.
 */
public class AddTwoNumbersAsLists {
	public static void main(String[]args) {
		
		MyLinkedList num1 = new MyLinkedList();
		MyLinkedList num2 = new MyLinkedList();
		
		prepare(num1,num2);
		
		// to find the sum this is what we do:
		// 1. reverse both the lists (as we naturally do sum starting from right)
		// 2. add by keeping track of carry
		// 3. insert the result in the beginning of new list
		
		MyLinkedList ans = new MyLinkedList();
		num1.reverseTheListWithRecursion();
		num2.reverseTheListWithRecursion();
		// do the sum
		Node head1 = num1.head;
		Node head2 = num2.head;
		int carry = 0;
		int result;
		while (head1 != null || head2 != null) {
			
			if(head1 != null && head2 != null) {
				result = head1.data + head2.data;
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1 != null) {
				result = head1.data;
				head1 = head1.next;
			} else {
				result = head2.data;
				head2 = head2.next;
			}
			result += carry;
	
			if(result >= 10) {
				carry = result/10;
				result = result %10;
			} else {
				carry = 0;
			}
			
			ans.insertNodeInTheBeginning(result);
		}
		ans.printList();
	}
	
	/**
	 * create two lists representing 5734 and 946
	 * 5->7->3->4-||
	 * 9->4->6-||
	 * 
	 * Answer of adding should be:
	 * 6->6->8->0-||
	 */
	public static void prepare(MyLinkedList l1, MyLinkedList l2) {
		l1.insertNodeInTheEnd(5);
		l1.insertNodeInTheEnd(7);
		l1.insertNodeInTheEnd(3);
		l1.insertNodeInTheEnd(4);
		
		l2.insertNodeInTheEnd(9);
		l2.insertNodeInTheEnd(4);
		l2.insertNodeInTheEnd(6);
	}

}
