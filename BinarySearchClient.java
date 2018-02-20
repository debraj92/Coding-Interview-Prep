package JavaLearn;

import java.util.Random;

public class BinarySearchClient {
	public static void main(String[] args) {
		MyBinarySearch binarysearch = new MyBinarySearch();
		binarysearch.binarySearchCallerForInt();
		binarysearch.binarySearchCallerForString();
			
	}
}

 class MyBinarySearch{
	 
	 public void binarySearchCallerForString() {
		 String stringToBeSearched = "bob";
			String[] str = {"ankit","bob","claire","david","isha"};
		    int resultIndex1 = binarySearchforString(str,0,str.length-1,stringToBeSearched);
		    System.out.println("the name "+stringToBeSearched+" is at "+resultIndex1+" index of array");
		 
	 }
	 
	 public void binarySearchCallerForInt() {
		 int[] arr = new int[10];
			int[] arr1 = {10,20,30,40,50,60,70,80,90,100};
		 Random random = new Random();
			for(int i = 0; i<10;i++) {
				arr[i] = random.nextInt(50);
			}
			int elementToBeSearched = 30;
			Sorting sorting = new Sorting();
			sorting.selectionSort(arr);
			sorting.printArray(arr);
			
			int resultIndex = binarySearchForInt(arr1, 0, 9, elementToBeSearched);
			System.out.println("the data is at "+resultIndex+"th index of array");
		 
	 }
	 /**
	  * method to search element in array
	  * @param arr array in which search will be done
	  * @param l lower index of the array
	  * @param r last index of the array
	  * @param x the element to be searched
	  * @return the index at which the element is present, if not present then return -1.
	  */
	 public int binarySearchForInt(int[] arr, int l, int r, int x) {
		 if(r>=l) {
		 int mid;
		 mid = l + (r-l)/2;
		 if(arr[mid]==x) {
			 return mid;
		 } 
		  if( arr[mid]<x) {
			return binarySearchForInt(arr,mid+1,r,x);
		 } else {
			return binarySearchForInt(arr,l,mid-1,x);
		 }
		 
	 } return -1;
	 }
	
	 public int binarySearchforString(String[] str, int l, int r, String s) {
		 if(r>=l) {
			 int mid = l + (r-l)/2;
			
			 if(s.compareToIgnoreCase(str[mid])==0) {
				 return mid;
			 }
			 if (s.compareToIgnoreCase(str[mid])<0) {
				return binarySearchforString(str,l,mid-1,s);
			 } else {
				 return binarySearchforString(str,mid+1,r,s);
			 }
		 }
		 	 return -1;
	 }
}