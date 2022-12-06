package JavaLearn;

import java.util.HashSet;
import java.util.Iterator;



public class PairSumHashSet {
	public static void main(String[] args) {
		
		int arr[] = {1,4,6,2,3,0,8,5};
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
	
	int counter = 0;
	/**
	 * We need to use an iterator because we are removing elements from the hash set.
	 * Directly removing elements from hs while traversing over it will cause 
	 * ConcurrentModificationException
	 */
	Iterator<Integer> it = hs.iterator();
	while(it.hasNext()) {
		int elem = it.next();
		int x = sum - elem;
		if(x>=0 && hs.contains(x)) {
			System.out.println("The pair is "+elem+ ", "+x);
			// remove the pair from hash set, so that we dont print again
			// iterator.remove() removes the last element returned by the iterator from the 
			// underlying collection.
			it.remove();
			counter = 1;
		}
		
	}
	if(counter == 0)
		System.out.println("No pair exists");
	}
}
