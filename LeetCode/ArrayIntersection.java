package Practice;

import java.util.*;

public class ArrayIntersection {
	
	//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
	
	public static int[] findIntersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int a: arr1) {
			if (hmap.containsKey(a)) {
				hmap.put(a, hmap.get(a) + 1);
			} else {
				hmap.put(a, 1);
			}
		}
		
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for(int a: arr2) {
			if (hmap.containsKey(a)) {
				resultList.add(a);
				if(hmap.get(a) == 1) {
					hmap.remove(a);
				} else {
					hmap.put(a, hmap.get(a) - 1);
				}
			}
		}
        
        int[] out = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            out[i] = resultList.get(i);
        }
        return out;
	}
	
	public static void main(String[]args) {
		int[] result = findIntersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
		for(int a: result) {
			System.out.println(a);
		}
	}
	
}
