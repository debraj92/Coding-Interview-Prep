package JavaLearn.GeekForGeeks_Solution;

/**
 * https://www.geeksforgeeks.org/alternate-lower-upper-string-sort/
 * 
 * Alternate Lower Upper String Sort
 */
public class LowerUpperStr {
	
	public static void main(String[]args) {
		String s = "bAwuTndekWEdkd";
		char[] arr = s.toCharArray();
		int partition_point = partition(arr);
		
		// make the array alternate upper lower
		/**
		 * we start i from the first odd position and j from the partition point. i moves two position and j moves 1.
		 * The moment i catches j we should stop. There is no point to go further to the right of j as all the 
		 * elements to the right of j will be of lower case.
		 */
		for(int i=1, j=partition_point; i<j && j < arr.length ; i+=2, j++) {
			char c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
		}
		String result = new String(arr);
		System.out.println(result);
	}

	/**
	 *	Partition the char array such that left half has uppers and right half as lowers.
	 *	@return partition point
	 */
	public static int partition(char[] arr) {
		int i=0, j=arr.length - 1;
		
		while(i < j) {	
			if(Character.isUpperCase(arr[i])) {
				i++;
			}
			else if (Character.isLowerCase(arr[j])) {
				j--;
			}
			else {
				char c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
				i++;
				j--;
			}
			
		}
		return i;
	}
}
