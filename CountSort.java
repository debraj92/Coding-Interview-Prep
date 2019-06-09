package JavaLearn;

public class CountSort {

	static int[] sort(int[] a) {
		// we need an aux array. The array size = difference between max and min element in the array a
		int max = a[0], min = a[0], n = a.length;
		int i;
		for(i = 1; i<n ; i++) {
			max = Math.max(a[i], max);
			min = Math.min(a[i], min);
		}
		int d = max - min + 1;
		int[] aux = new int[d];
		// we will store the count of the elements in the aux array
		for (i=0; i<n; i++) {
			aux[a[i]-min]++;
		}
		// we will update the aux array to store cumulative sum.
		for (i = 1; i<d; i++ ) {
			aux[i] = aux[i]+aux[i-1];
		}
		
		// next we would shift the cumulative sums by one cell to the right. These values would then become the starting indices in 
		// the sorted array.
		for (i = d-1; i>0; i--) {
			aux[i] = aux[i-1];
		}
		aux[0] = 0;
		
		// store the sorted values in a result array
		int[] sorted = new int[n];
		
		// iterate over the original array
		for(i=0; i<n; i++) {
			
			// find the starting index of the element a[i] from the aux array. In the sorted array at this index, place the value a[i]
			// remember the aux array starts from 0. We are mapping min to max range in 0 to d. This means the value for 5 would be located
			// at 5 - min. Thus aux[a[i] - min]
			
			sorted[aux[a[i] - min]] = a[i];
			
			// increment the starting index for next placement
			aux[a[i] - min]++;
		}
		
		return sorted;
	}
	
	public static void main(String[]args) {
		int[] a = new int[] {5, 1, 2, 3, 4, 4, 3, 4, 1};
		//int[] a = new int[] {5, 5, 3, 3, 4, 3, 4, 0, 0};
		a = sort(a);
		for(int i: a) {
			System.out.print(i+" ,");
		}
	}
	
	
}
