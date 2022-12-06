package JavaLearn;

public class HeapClient {
      public static void main(String[] args) {
    	  int heap_arr1[] = {3,6,5,2,8,9,1,10,30};
    	 
    	  Heap_ hf = new Heap_(heap_arr1);
    	  hf.heapify();
    	  System.out.println("Max Heap1");
    	  hf.printHeap();
    	  
    	  int heap_arr2[] = {3,6,2,8,22,54,20,18,73}; 
    	  hf = new Heap_(heap_arr2);
    	  
    	  for(int i = 0; i<heap_arr1.length;i++) {
    		  hf.insert(heap_arr2[i]);
    	  }
    	  System.out.println("Max Heap1");
    	  hf.printHeap();
    	  System.out.println();
    	  System.out.println("++++++ Heap Sort ++++++");
    	  hf.heapsort();
    	  hf.printHeap();
      }
}


class Heap_{
	
	private int[] arr;
	int position = -1;
	int size;
	Heap_(int[] ar) {
		arr = ar;
		size = arr.length-1;
	}
	
	private int leftChild(int parent_index) {
		return arr[2*parent_index + 1]; // indexing starts from 0
	}
	
	private int rightChild(int parent_index) {
		return arr[2*parent_index + 2]; // indexing starts from 0
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	
	private void swim(int k) {
		while(k >=1  && isGreater( k, k/2)) {
			//the inserted element is greater than its parent
			exchange(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		//sink till k is the last parent. (when k is the last parent 2*k +1 will be the last child at index size -1)
		while(2*k + 1<=size) {
			int leftChildIndex = 2*k+1;
			int rightChildIndex = 2*k+2;
			if(2*k + 2 <= size) {
				//right child exists
				int greater_child_index = isGreater(leftChildIndex,rightChildIndex)? leftChildIndex:rightChildIndex;
				if(arr[k]<arr[greater_child_index]) {
					exchange(k,greater_child_index);
					k = greater_child_index;
				} else {
					//already heap
					break;
				}
			} else {
				//need to check if last child is greater than parent
				if(arr[k]<leftChild(k)) {
					exchange(k,leftChildIndex );
					k = leftChildIndex;
				}
			}
		}
	}
	
	/**
	 * heapify proceeds with sinking elements. We start from the last parent and sink it to its appropriate position. We move up parent by parent and convert each subtree to heap
	 */
	public void heapify() {
		/**
		 * start from the last parent and heapify each tree
		 */
		for(int parent = size/2; parent>=0; parent--) {
			sink(parent);
		}
	}
	
	/**
	 * We insert the element in the end of the array and swim it up at the appropriate position. This is the case when the original array before the insertion is already a heap
	 */
	public void insert(int element) {
		
		arr[++position] = element;
		swim(position);
	}
	
	/**
	 * Checks if x is greater than y
	 * 
	 */
	private boolean isGreater(int x, int y) {
		if(arr[x]> arr[y]) {
			return true;
		} else {
			return false;
		}
	}
	
	private void exchange(int x, int y) {
		int temp = arr[x];
		arr[x]= arr[y];
		arr[y] = temp;
	}
	
	public void printHeap() {
		int n = arr.length;
		for(int i = 0; i<n;i++)
	       System.out.print(" "+arr[i]);
		  System.out.println();
	}
	
	public void heapsort() {
		while(size>0) {
			// The max element is at root (or index 0), we first move it to the end of the array
			exchange(0,size);
			//the heap is now one less
			size--;
			// the root element now violates the heap property. Sink it to its appropriate location.
			sink(0);
		}
	}
}
