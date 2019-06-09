package JavaLearn.GeekForGeeks_Solution;

import java.util.Arrays;

//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

public class KSmallest {
  
	public static void main(String[]args) {
	  int[] a = new int[] {7, 10, 4, 3, 20, 15};
	  findKSmallest(a,3);
	  findKSmallest(a,4);
    }
	
	public static void findKSmallest(int[] arr, int k) {
		MaxKHeap mheap = new MaxKHeap(Arrays.copyOfRange(arr, 0, k));
		for(int i = k; i< arr.length; i++) {
			// replace the largest in the heap with the new smaller value
			if(arr[i] < mheap.getMax()) {
				mheap.replaceMax(arr[i]);
			}
		}
		
		System.out.println("K ("+k+") Smallest value is - "+mheap.getMax());
		
	}
	
}


class MaxKHeap {
	
	int[] heap;
	int k;
	
	MaxKHeap(int[] arr) {
		this.k = arr.length;
		heap = arr;
		buildHeap();
	}
	
	public void buildHeap() {
		int lastparent_index = k/2 - 1;
		while (lastparent_index>=0) {
			heapify(lastparent_index);
			lastparent_index--;
		}
	}
	
	public int getMax() {
		return heap[0];
	}
	
	public void replaceMax(int val) {
		heap[0] = val;
		heapify(0);
	}
	
	public void heapify(int current) {
		int max = heap[current];
		int max_index = current;
		// check if max is less than its left child
		if(isLeftChildPresent(current) && heap[2*current + 1] > max) {
			max = heap[2*current + 1];
			max_index = 2*current + 1; 
		} 
		
		// check if max is less than its right child
		if(isRightChildPresent(current) && heap[2*current + 2] > max) {
			max = heap[2*current + 2];
			max_index = 2*current + 2;
		} 
		
		if (max_index != current) {
			// one line swap
			heap[max_index] = ( heap[max_index] + heap[current] ) - ( heap[current] = heap[max_index] );
			// percolate
			heapify(max_index);
		}
	}
	
	public boolean isLeftChildPresent(int current) {
		return 2*current + 1 < k;
	}
	
	public boolean isRightChildPresent(int current) {
		return 2*current + 2 < k;
	}
}
