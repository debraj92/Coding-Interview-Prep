package JavaLearn;

/**
 * 
 *	https://www.techiedelight.com/find-odd-occurring-element-logn-time/
 *
 *	Find the odd occurring element in log(n) time. The even elements must occur in pairs (WHY?)
 *  WHY -> Consider the array :     [9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 1]. Say mid is index 6 (middle of array).
 *  At this position it is impossible to just check mid to know if the odd occurring element is to the left or right of 
 *  the array. So, the problem can be solved using binary search only if the even occurring are in pairs such as:
 *  [9, 9, 3, 3, 8, 8, 2, 1, 1, 3, 3]
 *
 *	We will use binary search for this. For this we need to know if the odd element is to the left of mid or 
 *	to the right.
 *	Notice if there were no odd occurring element all pairs would start at even position - 0,2,4,6 ...
 *  Once an odd number occurs, immediately after that the pairs will start from odd position (order reversed).
 *  Now, suppose mid is pointing to an even index and we see that the next element (odd index) is the same as mid 
 *  element. This means that the order reversal has not happened yet and hence the odd element must be to the right 
 *  of mid. If mid is pointing to an odd element, then for order reversing to have not happened yet, mid - 1 (even index) 
 *  must be equal to mid.
 */

public class BinarySearchOddOccurringElem {
	
	public static void main(String[]args) {
		int[] arr = new int[] {9, 9, 3 , 3, 8, 8, 2, 1, 1, 3, 3};
		System.out.println("odd element is "+arr[findPosOddElement(arr)]);
	}
	
	public static int findPosOddElement(int[] arr) {
		int begin = 0, end = arr.length -1;
		int mid = (begin + end) / 2;
		if(arr[0] != arr[1]) {
			return 0;
		}
		begin++;
		while (begin < end) {
			
			if(arr[mid - 1] != arr[mid] && arr[mid + 1] != arr[mid]) {
				// mid is neither equal to the previous nor next element. This is the odd occurring
				return mid;
			} else {
				if (mid % 2 == 0) {
					if (arr[mid + 1] == arr[mid]) {
						// search in right half
						begin = mid + 1;
					} else {
						end = mid - 1;
					}
					
				} else {
					if (arr[mid - 1] == arr[mid]) {
						// search in right half
						begin = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				
				mid = (begin + end) / 2;
			}
		}
		
		return mid;
	}
}
