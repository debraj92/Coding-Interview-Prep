package JavaLearn.GeekForGeeks_Solution;

public class RotationPoint {
	public static void main(String[]args) {
		int[] a = new int[] {6,7,8,9,2,3,4};
		int r = pointOfRotation(a);
		System.out.println("index "+r+" value "+a[r]);
		
		// point of rotation 0
		a = new int[] {2,3,4,6,7,8,9};
		r = pointOfRotation(a);
		System.out.println("Point of rotation "+r);
		
	}
	
	/**
	 * We will do this using binary search. Consider an array A and rotation point r. Once we find mid, we need to decide if we should move 
	 * left or right. One thing to note is A[0]>A[n-1] and A[r-1]>A[r]. 
	 *         
	 *             /9
	 *           /8
	 *          /7
	 *        /6
	 *        ------------
	 *                  /4
	 *                 /3
	 *                /2
	 *          m1  r   m2
	 *       low          high  
	 *    
	 *  If mid is somewhere like m1 then we need to binary search in the right subarray and if mid is like m2 we need to search in the 
	 *  left sub array. Notice if mid is m1 then A[m1] > A[high] and if mid is m2, A[m2] < A[low]. This way we can determine where mid is 
	 *  and accordingly search in the proper half of the array.
	 *      
	 */
	public static int pointOfRotation(int[] arr) {
		int low = 0;
		int high = arr.length -1;
		int mid = (low+high)/2;
		
		while(low<=high && mid > 0 && arr[mid-1]<arr[mid]) {
			// check if m1
			if(arr[mid] > arr[high]) {
				// m1
				low = mid + 1;
			} else {
				// m2
				high = mid - 1;
			}
			mid = (low+high)/2;
		}
		if(low>high) {
			return -1;
		}
		return mid;
		
	}
}
