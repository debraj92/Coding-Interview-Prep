package JavaLearn;

import java.util.HashSet;

public class Practice_Hashing {
		public static void main(String[]args) {
			solve1();
		}
		
		public static void demoHashFunction() {
			String isha = "isha";
			String ishan = "ishan";
			String ishe = "ishe";
			String debraj = "Debraj";
			//s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
			/**
			 * Good Hash Function Qualities
			 * ===================
			 * Easy to compute: It should be easy to compute and must not become an algorithm in itself.
			 * Uniform distribution: It should provide a uniform distribution across the hash table and should not result in clustering.
			 * Less collisions: Collisions occur when pairs of elements are mapped to the same hash value. These should be avoided.
			 *
			 *Hashing Tutorial in details:
			 *https://www.youtube.com/watch?v=Ke_tII6Y0GE&list=PLTZbNwgO5ebqw1v0ODk8cPLW9dQ99Te8f
			 */
			System.out.println("HashCode of isha "+isha.hashCode());
			System.out.println("HashCode of ishan "+ishan.hashCode());
			System.out.println("HashCode of ishe "+ishe.hashCode());
			System.out.println("HashCode of debraj "+debraj.hashCode());
		}
		
		public static void solve1() {
			ProblemHashing1 solve = new ProblemHashing1();
			boolean answer = solve.isDuplicatesAtKDistance(new int[] {
					1, 2, 3, 9, 12, 15, 5, 2, 9, 5, 8, 10
			}, 3);
			System.out.println("Duplicates at distance k? "+answer);
		}
}

class ProblemHashing1 {
	/**
	 * This is a solution to 
	 * https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
	 * using HashSet in Java
	 */
	
	/**
	 * The idea to solve this problem
	 * ==================
	 * We traverse the array - arr and add elements to the hash set. While adding we check if the hash set already contains the same element. If yes
	 * we return true. Now, we are expected to find duplicates withing a range of k elements. That means, we can drop the 0th element from consideration
	 * when we are adding the k+1th element (because even if the k+1th element is the same as the 0th element, they are at distance more than k apart).
	 * 
	 * To drop elements, we use a pointer called elementToRemoveIndex. It is initially set to -k-1. For example if k =3, it is set at -4. This pointer is 
	 * incremented with i (which is the pointer to traverse arr and add elements of arr to hash set). When i is at 4, this pointer is at 0. This means
	 * the hash set is now full and we want to remove the first element before adding a new element. In turns, we will remove the second, third, fourth 
	 * element from the array as and when we are adding new element. The element to remove is tracked using the elementToRemoveIndex pointer.
	 */
	
	public boolean isDuplicatesAtKDistance(int[] arr, int k) {
		//The hset will contain only the latest k elements from arr. The advantage of using hash set is that it can spot/find an element inside it in O(1) time
		HashSet<Integer> hset = new HashSet<>();
		int elementToRemoveIndex = -k-1; // originally set to -(k+1). This ensures we start deleting elements after the hashset is filled with k elements.
		/**
		 * Alternately, we can fill up the first k element in the hash set using a loop, and for the remaining elements we can remove an element before 
		 * adding a new element. In this case we would not need the elementToRemoveIndex pointer.
		 */
		int i = 0; // pointer to traverse arr and add elements to the hash set
		while(i<arr.length){
			if(hset.contains(arr[i])) {
				System.out.println("Duplicate in hash set found. Duplicate item is "+arr[i]);
				return true;
			} else {
				System.out.println("Adding to Hash Set "+arr[i]);
				hset.add(arr[i]);
			}
			elementToRemoveIndex++;
			i++;
			if(elementToRemoveIndex >=0 ) {
				// once elementToRemoveIndex crosses the 0th index, we want to remove the element  arr[elementToRemoveIndex] before adding a new
				// element to the hash set in the next iteration. Remember hash set is unordered.
				System.out.println("Removing from Hash Set "+arr[elementToRemoveIndex]);
				hset.remove(arr[elementToRemoveIndex]);
			}
		}
		return false;
	}
}


