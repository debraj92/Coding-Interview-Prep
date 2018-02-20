package JavaLearn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MinRemovalPalindrome {
    public static void main(String[] args) {
    	//String s = "geeksforgeeks";
    	String s = "shubham";
    	MinPalin mPalin = new MinPalin();
    	int result =mPalin.minRemoval(s);
    	System.out.print(result);
    }
}

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