package JavaLearn;

import java.util.HashSet;

public class IsDisjointHashing {

	public static void main(String[] args) {
		int arr1[] = {5,7,3,9,10,4,2};
		int arr2[] = {1,6,12};
		IsDisjoint id = new IsDisjoint();
		id.findIfDisjoint(arr1, arr2);
		
	}
}

class IsDisjoint{
	
	public void findIfDisjoint(int[] arr1, int[] arr2) {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < arr2.length; i++) 
		hs.add(arr2[i]);
		
		int counter = 0;
		for(int i = 0; i < arr1.length; i++) 
			if(hs.contains(arr1[i])) {
				System.out.println("Not Disjoint");
				counter = 1;
				break;
			}
		if(counter == 0)
			System.out.println("Disjoint");
	}
}