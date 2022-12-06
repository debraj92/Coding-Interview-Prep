package JavaLearn;

/**
 * Implement from here:
 * https://algs4.cs.princeton.edu/23quicksort/
 * https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 *
 */
public class QuickSort {
	
	public static void main(String[]args) {
		int[] arr = new int[] {5, 4, 2, -2, -100, 100, 3, 1, 7, 3, -14};
		quickSort(0, arr.length - 1, arr);
		
		// print the array
		String result ="";
		for(int x:arr) {
			result += x+" , ";
		}
		System.out.print(result.substring(0, result.lastIndexOf(',')));
	}
	
	/**
	 * 
	 * In each quick sort call we will place one element at its right place and then repeat for the subset of the array before 
	 * the correctly placed element and after the correctly placed element.
	 */
	public static void quickSort(int start, int end, int[] arr) {
		
		/**
		 * base case
		 */
		if(start>=end) {
			return;
		}
		int partition_point = partition(start, end, arr);
		// The element at partition_point is ... Sorted
		quickSort(start, partition_point-1, arr);
		quickSort(partition_point+1, end, arr);
	}
	
	public static int partition (int start, int end, int[] arr) {
		// We should consider the pivot as the first or the last element.
		// We will them partition the remaining array to find the perfect position of the pivot.
		// Lets consider the pivot as the first element.
		
		int pivot = start;
		// partition will be applied on the remaining array to find the perfect place for pivot.
		start++;
		int t;
		// partitioning is complete when start and end cross over each other and not when they are equal
		while(start <= end) {
			if(arr[start]<=arr[pivot]) {
				start++;
			} else if (arr[end]>arr[pivot]) {
				end--;
			} else {
				t = arr[start];
				arr[start] = arr[end];
				arr[end] = t;
				start++;
				end--;
			}
		}
		// notice the ideal place of pivot element can be anywhere in the array from 0 to n-1. Only end has this range.
		// start can point to values only from 1 to n-1.
		t = arr[pivot];
		arr[pivot] = arr[end];
		arr[end] = t;
		return end;
	}

}
