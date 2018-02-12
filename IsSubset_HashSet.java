package JavaLearn;

import java.util.HashSet;

public class IsSubset_HashSet {
	public static void main(String[] args) {
		
		//int arr[] = new int[6];
		int arr1[] = {1,6,4,3,2,8};
		int arr2[] = {4,3,6,8};
		int n = arr1.length;
		int m = arr2.length;
		
		IsSubset is = new IsSubset();
		//int result = is.findIsSubsetMethod(arr1,arr2,n,m);
		if(is.findIsSubsetMethod(arr1,arr2,n,m))
			System.out.println("array2 is subset of array1");
		else
			System.out.println("array2 is NOT subset of array1");
		
	}

}

class IsSubset{
	
	public boolean findIsSubsetMethod(int[] arr1, int[] arr2, int n, int m) {
		//int counter = -1;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i <n; i++) {
			while(!hs.contains(arr1[i]))
				hs.add(arr1[i]);
			}
		
		for(int i = 0; i <m; i++) {
			if(!hs.contains(arr2[i]))
				return false;
		}
        return true;
		
	}
}