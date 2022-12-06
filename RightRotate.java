package JavaLearn;

/**
 * 
 * https://www.techiedelight.com/right-rotate-an-array-k-times/
 * 
 * NOTE ARRAY NEED NOT BE SORTED
 * 
 * This problem is about rotating an array in place. We are going to use array reversals
 *      
 *          /                  /
 *        /         --->     /
 *      /                        /
 *    /                        /
 *    sorted array         After rotation
 *    
 *    Example - right rotate ([1,2,3,4,5,6,7], 4) => [5,6,7,1,2,3,4]
 *    
 *    To achieve this we first reverse the whole array
 *    
 *                  \
 *                    \
 *                      \
 *                        \
 *              Reversed array
 *    Next we reverse the first half and second half separately
 *     
 *                      /
 *                    / 
 *                          /
 *                        /
 *    
 */


public class RightRotate {
	
	public static void main(String[]args) {
		/*int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7 };
		rightRotateArray(arr, 3);
		printArray(arr);*/
		
		
		int[] arr = new int[] {1, 2, 3, 4, 5};
		leftRotateArray(arr, 2);
		printArray(arr);
		
	}
	
	public static void rightRotateArray(int[] arr, int rotation_count) {
		reverseArray(arr, 0, arr.length - 1);
		/**
		 * In the original array rotation_point = array_length - rotation_count   (for right rotation)
		 * However, note we have the reversed array now. In the reversed array 
		 * rotation_point = rotation_count
		 */
		int rotation_point = rotation_count;
		reverseArray(arr, 0, rotation_point - 1);
		reverseArray(arr, rotation_point, arr.length - 1);
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		for(int i= start, j= end; i<j; i++, j--) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
	}
	
	public static void printArray(int[] arr) {
		for (int x: arr) {
			System.out.println(x);
		}
	}
	
	// left rotate ([1 , 2 , 3 , 4 , 5], 2) => [3, 4, 5, 1, 2]
	public static void leftRotateArray(int[] arr, int rotation_count) {
		reverseArray(arr, 0, arr.length - 1);
		// For left rotation , the initial rotation point was rotation_count and after array reversal 
		// the rotation point is arr.length - rotation_count
		int rotation_point = arr.length - rotation_count;
		reverseArray(arr, 0, rotation_point - 1);
		reverseArray(arr, rotation_point, arr.length - 1);
	}
}
