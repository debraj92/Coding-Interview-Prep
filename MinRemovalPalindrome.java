package JavaLearn;

/**
 * https://www.geeksforgeeks.org/minimum-removal-make-palindrome-permutation/
 * 
 * Minimum removal to make palindrome permutation
 * 
 * Given a string S, we have to find minimum characters that we can remove to make any permutation of the string S a palindrome.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MinRemovalPalindrome {
    public static void main(String[] args) {
    //	String s = "geeksforgeeks";
    String s = "shubham";
    	MinPalin mPalin = new MinPalin();
    	int result =mPalin.minRemoval(s);
    	System.out.print(result);
    }
}

/**
 * LOGIC:
 * 
 * An even length palindrome has all characters even number of times. An odd length palindrome has just 1 character odd number of times.
 * We are not concerned about the pairs of characters as they need not be removed to form the palindrome. If there are multiple odd number characters
 * then we have to remove one of each to make them even. However we can keep one character of odd length.
 * 
 * So if there are a total of x odd length characters, then the number of palindrome strings that can be formed = x - 1
 *
 */

class MinPalin{
	
	public int minRemoval(String str) {
		
		int len = str.length();
		int count = 0;
		
		HashMap<Character, Integer> hMap = new HashMap<>();
		
		for(int i = 0; i <len; i++) {
			char c =str.charAt(i);
			if(hMap.containsKey(str.charAt(i)) ) {
				
				int val = hMap.get(str.charAt(i));
				val++;
				hMap.put(str.charAt(i),val);
			} else {
				hMap.put(c, 1);
				
			}
		System.out.println(hMap);
		}
		//Iterating Map
		Iterator entries = hMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		   
		    Integer value = (Integer)entry.getValue();
		
		    if(value%2 == 1)
		    	count++;
		}
		return count-1;
	}
}