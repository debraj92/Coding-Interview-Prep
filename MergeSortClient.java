package JavaLearn;

public class MergeSortClient {
	public static void main(String[] args) {
		System.out.println("Merge sort client");
		int[] arrToBeSorted = { 2, 4, 7, 10, 1, 3, 9, 16, 15, 5, 8 };
		Sorter sorter = new Sorter();
		sorter.mergeSort1(arrToBeSorted);
		// sorter.mergeSort2(arrToBeSorted);
		for (int elem : arrToBeSorted) {
			System.out.print(elem + " ");
		}
	}
}

class Sorter {

	private void merge(int[] arr, int[] aux, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = 0;
		if (arr[mid] < arr[mid + 1]) {
			System.out.println("Already sorted in order from " + l + " to " + r);
			return;
		}
		while (i <= mid && j <= r) {
			if (arr[i] < arr[j]) {
				System.out.println("Adding " + arr[i]);
				aux[k++] = arr[i++];
			} else {
				System.out.println("Adding " + arr[j]);
				aux[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			System.out.println("Adding " + arr[i]);
			aux[k++] = arr[i++];
		}
		while (j <= r) {
			System.out.println("Adding " + arr[j]);
			aux[k++] = arr[j++];
		}

		// copy the aux array into original array
		System.out.println("Copying aux into arr");
		for (i = l, k = 0; i <= r; i++) {
			System.out.println("Storing in arr at " + i + " value " + aux[k]);
			arr[i] = aux[k++];
		}

	}

	// we will avoid copying from aux to arr by switching their roles
	private void mergeSortInternal2(int[] arr, int[] aux, int l, int r) {
		if (r <= l) {
			System.out.println("l " + l + " r " + r);
			System.out.println("This is sorted");
			return;
		}
		int mid = l + (r - l) / 2;
		System.out.println("l " + l + " m " + mid + " r " + r);

		/**
		 * The logic of switching roles ---------------------------------
		 * mergeSortInternal = ms 
		 * 
		 *                            ms(arr, aux) (1) 
		 *                                  /            \
		 *                               /                \
		 *            ms(aux, arr) (2)           ms(aux, arr) (3) 
		 *             /                \  
		 *           /                   \
		 *  ms(arr, aux) (4)     ms(arr, aux) (5)
		 * 
		 * 4 and 5 sorts their part of arr and keeps their sorted data inside
		 * the aux array in 2. 2 is treating the aux array as its main array and keeps
		 * its sorted data inside arr (which according to 2 is the aux array)
		 * Same for 3. It keeps the sorted data inside arr thinking that this is
		 * the aux array. 1 merges the content obtained from 2 and 3,
		 * and keeps it inside aux
		 * 
		 * The final result is inside aux
		 * 
		 */
		mergeSortInternal2(aux, arr, l, mid);
		mergeSortInternal2(aux, arr, mid + 1, r);
		altMerge(arr, aux, l, mid, r); // we have to use the altMerge because
										// this ensures that we store the merged
										// parts of arr inside aux in same
										// indices
		System.out.println("After Merging");
		for (int x : aux) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	// we will avoid copying from aux to arr by switching their roles
	private void mergeSortInternal1(int[] arr, int[] aux, int l, int r) {
		if (r <= l) {
			System.out.println("l " + l + " r " + r);
			System.out.println("This is sorted");
			return;
		}
		int mid = l + (r - l) / 2;
		System.out.println("l " + l + " m " + mid + " r " + r);
		mergeSortInternal1(arr, aux, l, mid);
		mergeSortInternal1(arr, aux, mid + 1, r);
		merge(arr, aux, l, mid, r);
		System.out.println("After Merging");
	}

	// Simple
	public void mergeSort1(int[] arr) {
		int[] aux = new int[arr.length]; // passing the aux array ensure space
											// efficiency
		mergeSortInternal1(arr, aux, 0, arr.length - 1);
	}

	// Tricky
	public void mergeSort2(int[] arr) {
		/**
		 * Instead of copying aux back to arr we will switch their roles. For
		 * this aux must contain the same data as arr.
		 */
		int[] aux = arr.clone();
		mergeSortInternal2(arr, aux, 0, arr.length - 1);
		// final result is inside aux
		int i = 0;
		System.out.println("Copying aux into arr");
		for (int x : aux) {
			arr[i++] = x;
		}
	}

	/**
	 * This method ensures we are storing data inside aux exactly in the same
	 * place as arr, just in the sorted order. This is different from the other
	 * implementation of merge
	 * 
	 * @param arr
	 * @param aux
	 * @param l
	 * @param mid
	 * @param r
	 */
	public void altMerge(int[] arr, int[] aux, int l, int mid, int r) {
		int a1 = l;
		int a2 = mid + 1;
		for (int k = l; k <= r; k++) {
			if (a1 > mid) {
				// arr1 exhausted
				// copy the elements of arr2
				System.out.println("Arr1 Exhausted");
				System.out.println("Adding " + arr[a2]);
				aux[k] = arr[a2];
				a2++;
			} else if (a2 > r) {
				// arr2 exhausted
				// copy the elements of arr1
				System.out.println("Arr2 Exhausted");
				System.out.println("Adding " + arr[a1]);
				aux[k] = arr[a1];
				a1++;
			} else {
				if (arr[a1] < arr[a2]) {
					// put the smaller
					System.out.println("Arr1 is smaller");
					System.out.println("Adding " + arr[a1]);
					aux[k] = arr[a1];
					a1++;
				} else {
					System.out.println("Arr2 is smaller");
					System.out.println("Adding " + arr[a2]);
					aux[k] = arr[a2];
					a2++;
				}
			}
		}
	}
}
