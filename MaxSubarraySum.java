package JavaLearn;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySum {
	
	// start and end index of max sum subarray
	public static int low, high;
	
	/**
	 * 
	 * https://www.techiedelight.com/find-maximum-length-sub-array-having-given-sum/
	 * 
	 * Find max length subarray having given sum.
	 */
	public static void main(String[]args) {
		
		int[] arr = new int[] {5, 6, -5, 5, 3, 5, 3, -2, 0};
		int sum = 8;
		findMaxSumSubarray(arr,sum);
		
		System.out.println("Index range is : ["+low+", "+high+"]");
	}
	
	/**
	 * The idea is to calculate max sum so far and keep adding into a hashmap. Explained in detail in interview concepts doc. Read:
	 * Print all subarray with Zero sum
	 * 
	 * The difference between sum sofar of two indices indicates the sum of the range.
	 */
	public static void findMaxSumSubarray(int[] arr, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		int sumsofar = 0, start_index, range;
		for(int i=0; i<arr.length; i++) {
			sumsofar += arr[i];
			
			/**
			 * We intend to find ranges with sum = "sum" (for example 8). So if the sum to the current index i = x, then we should
			 * look for a previous index j whose sum sofar is x-sum. Then the sum of the range would be => i - j = x - (x-sum) = sum.
			 */
			if(map.containsKey(sumsofar - sum)) {
				start_index = map.get(sumsofar - sum);
				range = i - start_index + 1; //(start_index, i] read interview concepts
				if (range > (high - low)) {
					low = start_index + 1;
					high = i;
				}
			}
			
			// Notice we will not update the sumsofar index in case it already exists in the hashmap. This will ensure 
			// sumsofar has the smallest index and hence we get the largest range.
			if(!map.containsKey(sumsofar)) {
				map.put(sumsofar, i);
			}
		}
	}
}
