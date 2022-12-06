package JavaLearn.GeekForGeeks_Solution;

import java.util.*;

// https://www.geeksforgeeks.org/reversing-first-k-elements-queue/

public class ReversingFirstKElementsInQ {
	
	
	public static void main(String[]args) {
		Deque<Integer> q = new ArrayDeque<>();
		
		// insert elements
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		q.offer(60);
		q.offer(70);
		q.offer(80);
		q.offer(90);
		q.offer(100);
		
		reverseKQ(q, 5);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}
	
	/**
	 * Remove the first k elements and push into a stack. When we pop from stack, we will get the elements in reverse order.
	 * Enqueue the elements. So now, the Q has all the elements in the right order (first k reversed, the remaining are as it is).
	 * However the first k is currently in the back of the Q. We will bring it to the front by dequeuing the n-k elements and enqueuing 
	 * them in the back of the Q.
	 */
	public static void reverseKQ(Deque<Integer> q, int k) {
		
		Stack<Integer> st = new Stack<>();
		int remaining = q.size() - k;
		int i;
		
		// push into stack
		for(i=1; i<=k; i++) {
			st.push(q.poll());
		}
		// enqueue k from the stack
		while(!st.isEmpty()) {
			q.offer(st.pop());
		}
		
		// dequeue and enqueue remaining
		for(i=1; i<=remaining; i++) {
			q.offer(q.poll());
		}
		// done
		
	}
}
