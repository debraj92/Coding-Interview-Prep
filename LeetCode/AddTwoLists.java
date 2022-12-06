package Practice;

public class AddTwoLists {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/**
		 * If either list is empty, sum is the other list
		 */
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // carry
        int c = 0;
        ListNode head = null;
        ListNode current = null;
        /**
		 * Add numbers and keep track of carry
		 */
        while(l1 != null && l2 != null) {
            int v = c + l1.val + l2.val;
            if(v >= 10) {
              c = v/10;  
              v %= 10; 
            } else {
            	c = 0;
            }
            if (head == null) {
                head = new ListNode(v);
                current = head;
            } else {
                current.next = new ListNode(v);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        /**
		 * Cases when one list is longer than the other
		 */
        if (l1 == null) {
        	while(l2 != null) {
        		int v = c + l2.val;
        		if(v >= 10) {
                    c = v/10;  
                    v %= 10; 
                  } else {
                  	c = 0;
                  }
        		current.next = new ListNode(v);
                current = current.next;
                l2 = l2.next;
        	}
        }
        if (l2 == null) {
        	while(l1 != null) {
        		int v = c + l1.val;
        		if(v >= 10) {
                    c = v/10;  
                    v %= 10; 
                  } else {
                  	c = 0;
                  }
        		current.next = new ListNode(v);
                current = current.next;
                l1 = l1.next;
        	}
        }
        if(c > 0) {
        	current.next = new ListNode(c);
        }
        return head;
    }
	
	public static void main (String[]args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		
		ListNode l = addTwoNumbers(l1, l2);
		for(; l!=null; l=l.next) {
			System.out.println(l.val);
		}
		
	}
}
