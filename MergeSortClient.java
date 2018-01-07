package JavaLearn;

public class MergeSortClient {
	public static void main(String[] args) {
		System.out.println("Merge sort client");
		int[] arrToBeSorted = { 2, 4, 7, 10, 1, 3, 9};//, 16, 15, 5, 8 };
		Sorter sorter = new Sorter();
		sorter.mergeSort(arrToBeSorted);
		for(int elem:arrToBeSorted) {
			System.out.print(elem+" ");
		}
	}
}

class Sorter {
	private void merge(int[] arr, int[] aux, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = 0;

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
			System.out.println("Storing in arr at "+i+" value "+aux[k]);
			arr[i] = aux[k++];
		}
	}

	private void mergeSortInternal(int[] arr, int[] aux, int l, int r) {
		if (r <= l)
			return;
		int mid = l + (r - l) / 2;
		System.out.println("l " + l + " m " + mid + " r " + r);
		mergeSortInternal(arr, aux, l, mid);
		mergeSortInternal(arr, aux, mid + 1, r);
		merge(arr, aux, l, mid, r);
	}

	public void mergeSort(int[] arr) {
		int[] aux = new int[arr.length];
		mergeSortInternal(arr, aux, 0, arr.length - 1);

	}

	/**
	 * Alternate logic to merge two arrays
	 * 
	 * @param arr1
	 *            first array (sorted)
	 * @param arr2
	 *            second array (sorted)
	 */
	public void altMerge(int[] arr1, int[] arr2) {
		int combinedLength = arr1.length + arr2.length;
		int[] c = new int[combinedLength];
		int a1 = 0; // counter for arr1
		int a2 = 0; // counter for arr2
		for (int k = 0; k < combinedLength; k++) {
			if (a1 >= arr1.length) {
				// arr1 exhausted
				// copy the elements of arr2
				System.out.println("Arr1 Exhausted");
				System.out.println("Adding " + arr2[a2]);
				c[k] = arr2[a2];
				a2++;
			} else if (a2 >= arr2.length) {
				// arr2 exhausted
				// copy the elements of arr1
				System.out.println("Arr2 Exhausted");
				System.out.println("Adding " + arr1[a1]);
				c[k] = arr1[a1];
				a1++;
			} else {
				if (arr1[a1] < arr2[a2]) {
					// put the smaller
					System.out.println("Arr1 is smaller");
					System.out.println("Adding " + arr1[a1]);
					c[k] = arr1[a1];
					a1++;
				} else {
					System.out.println("Arr2 is smaller");
					System.out.println("Adding " + arr2[a2]);
					c[k] = arr2[a2];
					a2++;
				}
			}
		}
		System.out.println("Merged array");
		for (int x : c) {
			System.out.print(x + " ");
		}
	}
}
