package JavaLearn;

public class Isha_Heap {
      public static void main(String[] args) {
    	//  int heap_arr1[] = {3,6,5,2,8,9,1,10};
    	 
    	  Heap_functions hf = new Heap_functions();
    	 // hf.heapify(heap_arr1);
  	/*	for(int i = 0; i<heap_arr1.length;i++)
  	       System.out.print(" "+heap_arr1[i]);
  		  System.out.println();*/
     	  hf.insert(3);
    	  hf.printHeap();
    	  hf.insert(9);
    	  
    	  hf.insert(1);
    	  hf.insert(8);
    	  hf.insert(7);
    	  hf.printHeap();
    	   hf.insert(4);
    	  hf.insert(5);
    	  hf.insert(10);
    	  hf.insert(11);
    	  hf.printHeap(); 	  
      }
}


class Heap_functions{
	
	
	
	public void heapify(int[] arr) {
		swim(0);
	}
	
	private int[] arr = new int[40];
	int position = -1;
	public boolean isEmpty() {
		return position == 0;
	}
	public void insert(int element) {
		
		System.out.println("position"+position);
		arr[++position] = element;
		//int n = position;
		swim(position);
	}
	
	private void swim(int k) {
		while(k >=1  && less( k/2, k)) {
			exchange(k, k/2);
			k = k/2;
		}
	}
	private boolean less(int x, int y) {
		System.out.println("inside less");
		if(arr[x]<arr[y])
			return true;
		if(arr[x]>arr[y])
			return false;
		return false;
	}	
	private void exchange(int x, int y) {
		
		int temp = arr[x];
		arr[x]= arr[y];
		arr[y] = temp;
		System.out.println("inside exchange"+arr[x] +" "+arr[y]);
	}
	
	public void printHeap() {
		int n = arr.length;
		for(int i = 0; i<n;i++)
	       System.out.print(" "+arr[i]);
		  System.out.println();
	}
}






























/*class Heap_functions{
	public void max_heapify(int i, int[] arr) {
		int l, r, max,len, temp;
		len = arr.length;
		
		l = leftChild(len , i);
		r = rightChild(len , i);
		if(l < 0 && arr[l] > arr[i] )
			max = l;
		else max = i;
		if(r < len && arr[r] > arr[max])
			max = r;
		
		temp = arr[i];
		arr[i] = arr[max];
		arr[max] = temp;
		
		max_heapify(max, arr);
		
	}
	public int parent(int len, int i) {
		if(i <= 0 || i>= len)
			return -1;
		else {
		int parent = i-1/2;
		return parent;
		}
	}
	
	public int leftChild(int len, int i) {
		if(i < 0 || i>= len)
			return -1;
		else {
		int leftChild = 2*i+1;
		return leftChild;
		}
	}
	
	public int rightChild(int len, int i) {
		if(i < 0 || i>= len)
			return -1;
		else {
		int rightChild = 2*i+2;
		return rightChild;
		}
	}
}*/