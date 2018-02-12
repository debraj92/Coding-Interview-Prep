package JavaLearn;

import java.util.HashSet;
import java.util.Iterator;



public class PairSumHashSet {
	public static void main(String[] args) {
		
		int arr[] = {1,4,6,2,3,8,5};
		int sum = 5;
		Hashset hs = new Hashset();
		hs.findPair(arr, sum);
		
	}
}

class Hashset{
	
	public void findPair(int[] arr,int sum) {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < arr.length; i++) 
		hs.add(arr[i]);
		
	/*Iterator iter = hs.iterator();
	while(iter.hasNext()) {
		int x = iter.next();
		}
		*/
		int counter = 0;
	for(int i : hs) {
		int x = sum - i;
		if(x>=0 && hs.contains(x)) {
			System.out.println("The pair is "+i+ ", "+x);
		    counter = 1;
		}
	}
	if(counter == 0)
		System.out.println("No pair exists");
	}
}
