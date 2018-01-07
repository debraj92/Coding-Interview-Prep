import java.util.Random;

public class PracticeSorting {
	public static void main(String[]args){
		int totalElements = 20;
		// I will use random to generate random integers between 0 to 100
		int[] myArray = new int[totalElements];
		//https://www.geeksforgeeks.org/generating-random-numbers-in-java/
		Random random = new Random();
		for(int i=0; i < totalElements; i++) {
			myArray[i] = random.nextInt(100);
		}
		Sorting sorting = new Sorting();
		System.out.println("Array is:");
		sorting.printArray(myArray);
		//sorting.insertionSort(myArray);
		sorting.selectionSort(myArray);
		//see I am not returning myArray from the insertionSort method as Java passes objects by reference and 
		//any change to the reference is reflected everywhere
		System.out.println("After sorting:");
		sorting.printArray(myArray);
		
	}
}

class Sorting {
	public void insertionSort(int[] arr) {
		int n = arr.length;
		//This loop will select each item from the array.
		for (int i = 1; i < n; i++) {
			/**
			 * For insertion sort, the elements between 0 to i-1 is already sorted (WHY?)
			 * To maintain this property (that is keep 0 to i elements sorted) we have to find the right place for i
			 * in the array [0 to i-1]. To make space for i in its perfect place, we keep shifting the elements greater than i
			 * to their right. The array is expected to be sorted in ascending order.
			 */
			//store the current value of i for putting it in the right place. We need to store this i because the location of i 
			//will be over written by the operation arr[j+1] = arr[j] when j = i-1
			int currentElement = arr[i];
			int j = -1;
			for (j = i-1; j >= 0; j--) {
				if(arr[j]>currentElement) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			// here we have the perfect place for i. The place is j+1 
			//(Do you see why? Because the loop breaks for the element (j) less than or equal to i)
			arr[j+1] = currentElement;
		}
		System.out.println("Sorting is complete");
	}
	
	public void selectionSort(int arr[]) {
		System.out.println("Selection sort");
		int n= arr.length;
		for(int i=0; i<n-1; i++){
			int min = i;
			for(int j= i+1; j<n; j++){
				
				if(arr[min]>arr[j]){
					min=j;
				}
			}
			swap(min, i, arr);
		}
	}
	
	/**
	 * Swap the elements in index x and index y of the array arr
	 * @param x first index
	 * @param y second index
	 * @param arr array whose indices need to be swapped
	 */
	private void swap(int x, int y, int[] arr) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp; 
	}
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
