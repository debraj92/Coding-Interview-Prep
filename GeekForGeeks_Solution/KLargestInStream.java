package JavaLearn.GeekForGeeks_Solution;

//import java.util.Collections;
import java.util.PriorityQueue;


public class KLargestInStream {
	
	public static void main(String[]args) {
		int[] arr = new int[] {10, 20, 11, 70, 50, 40, 100, 5, 63, 22, 28, 91, 4, 2, 8, 97, 74, 79, 45, 34};
		int K = 4;
		for(int i=0; i<arr.length; i++) {
			addElement(arr[i],K);
			
			// print K largest for every 6th position
			if(i>0 && (i+1)%6==0) {
				printKLargest();
			}
		}
		
		/**
		 * Output explanation
		 * output : 20 63 79
		 *
		 *
		 * 10, 20, 11, 70, 50, 40   -> 4th Largest = 20
		 * 
		 * 10, 20, 11, 70, 50, 40, 100, 5, 63, 22, 28, 91 -> 4th Largest = 63
		 * 
		 * 10, 20, 11, 70, 50, 40, 100, 5, 63, 22, 28, 91, 4, 2, 8, 97, 74, 79  -> 4th Largest = 79
		 * 
		 */
	}

	
	// min heap - PQ
	public static PriorityQueue<Integer> min_hp = new PriorityQueue<Integer>();
	
	// max heap - PQ
	//public static PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
	
	public static void addElement(int newElement, int k) {
		if(min_hp.size() == k) {
			// current element is larger than the kth largest, then current element belongs to the
			// pq.
			if(newElement > min_hp.peek()) {
				min_hp.poll();
				min_hp.offer(newElement);
			}
		} else {
			// there is still space left in the pq
			min_hp.offer(newElement);
		}
	}
	
	public static void printKLargest() {
		System.out.println(min_hp.peek());
	}
	
}
