package JavaLearn;

/**
 * Largest Sum Contiguous Subarray
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * Logic :
 * Let the array be -2, -3, 7, 12, -25, 100, 5, -2, 7, -15, 10, 13, -32
 *
 * The point is that there is no point to add an element to the contiguous subarray when adding that element
 * makes the sum till that element negative.
 * For example: subarray : 7, 12 (sum = 19)
 * Adding -25: 7, 12, -25 (sum = -6)
 * Even though we have a 100 as the next element, there is no point starting from 7 as the sum from 7 till 100
 * is 94. Its better to just start from 100.
 * 
 * Also, consider the subarray 100, 5. The next element is -2. It is completely okay to consider the subarray 
 * 100, 5, -2 because when we reach the next element 7, the previous subarray (100, 5 and -2) increases the total 
 * sum.
 * 
 * We consider two variables : max_sum_till_index and max_contiguous_sum (for recording the greatest max_sum_till_index)
 * The max_sum_till_index will continue to grow as long as it is positive. Otherwise it will be reset to 0
 * 
 * 
 * 
 */
public class LargestContiguousSum {
	public static void main(String[]args) {
		int[] arr = new int[] {-2, -3, 7, 12, -25, 100, 5, -2, 7, -15, 10, 13, -32};
		int max_sum_till_index = 0, max_contiguous_sum = -10000;
		for(int i=0; i< arr.length; i++) {
			max_sum_till_index += arr[i];
			if(max_sum_till_index > max_contiguous_sum) {
				max_contiguous_sum = max_sum_till_index;
			}
			if (max_sum_till_index < 0) {
				max_sum_till_index = 0;
			}
		}
		System.out.println(max_contiguous_sum);
	}
}
