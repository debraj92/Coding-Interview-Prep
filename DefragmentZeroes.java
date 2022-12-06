package JavaLearn;

/**
 * https://www.careercup.com/question?id=5682803648757760
 *
 * Move all non-zero elements to the left of an array
 * 
 * Alternate way to solve this problem could be partitioning
 */
public class DefragmentZeroes {

	public static void main(String[]args) {
		int[] arr = new int[] {2, 2, 0, 3, 0, 0, 4, 5, 7, 0, 8};
		rearrange(arr);
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 *  Lets consider the array : [2 2 0 3 0 0 4 5 7 0 8]
	 *  
	 *  We have i which moves over each element. We have another pointer p which aggregates the zeroes and 
	 *  shift to the right. 
	 *  Consider - p->0 (2nd elem) and i->3 (3rd elem). We swap p and i , and we get - [2 2 3 0 0 0 0 4 5 7 0 8].
	 *  Remember, the space between p and i will always be only zeroes. So we need to swap if p and i are not pointing to the
	 *  same position, in which case there are no zeroes.
	 * 
	 */
	public static void rearrange(int[] arr) {
		int p = 0, i=0;
		
		for(;i<arr.length; i++) {
			
			// if the current element is zero, we let i increment and p stay at this position
			// if the current element is non-zero, we would also have to consider the swap. Note, there is no point 
			// swapping when current element is 0 (and p -> 0)
			
			if(arr[i] != 0) {
				if(i!=p) {
					arr[i] = arr[i] + arr[p] - (arr[p] = arr[i]);
				}
				p++;
			} 
			
		}
	}

}
