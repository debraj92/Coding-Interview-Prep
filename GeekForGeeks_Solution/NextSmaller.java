package JavaLearn.GeekForGeeks_Solution;

import java.util.*;

public class NextSmaller {
	
	public static void main(String[]args) {
		int[] data = new int[] {0, 18, 0, 13, 17, 16, 2, 12, 8};
		int[] nextSmallers = getNextSmallers(data);
		for(int x: nextSmallers) {
			System.out.print(x+"  ");
		}
	}
	
	public static int[] getNextSmallers(int[] data) {
		int[] result = new int[data.length];
		
		// The stack will contain pairs - {data, index} from the data array
		Stack<Pair<Integer, Integer>> st = new Stack<>();
		
		/**
		 * The idea is to traverse the data array and push elements to the stack provided they are greater than
		 * top. When an element is smaller than the top, we will pop elements from the stack until the top of 
		 * the stack is greater than the current element of data or the stack is empty. For all these popped elements, 
		 * we know the next smaller - it is the current element of data array, so we add the current element in the  
		 * index of the popped elements in the result array (which represents next smaller).
		 * 
		 * To note, for next smaller, the stack will be always stay arranged in ascending order (as the smaller values are used to 
		 * mark next smaller).
		 * 
		 * The algorithm is also O(n) as the values from data are only visited twice, once during pushing into the stack and once while
		 * popping from the stack. 2n operations = O(n) time complexity
		 */
		
		for(int i=0; i<data.length; i++) {
			int current = data[i];
			// check if current is next smaller than at least some elements
			while(!st.isEmpty() && st.peek().getKey()>current) {
				Pair<Integer, Integer> data_idx = st.pop();
				result[data_idx.getValue()] = current;
			}
			st.push(new Pair<Integer, Integer>(current, i));
		}
		
		// for the elements remaining in the stack there are no next smaller elements. We will have to make their
		// next smaller as -1
		
		while(!st.isEmpty()) {
			Pair<Integer, Integer> data_idx = st.pop();
			result[data_idx.getValue()] = -1;
		}
		
		return result;
	}
}

class Pair <K, V>{
	private K key;
	private V value;
	
	Pair(K k, V v) {
		key = k;
		value = v;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}


