package Practice;

import java.util.*;
public class Interleaving {
	
	static String s1 = "";
	static String s2 = "";
	static String s3 = "";
	
	static HashMap<String, Boolean> hm = new HashMap<>();
	
	/**
	 * https://www.youtube.com/watch?v=EzQ_YEmR598&ab_channel=TECHDOSE
	 * 
	 * Q: https://leetcode.com/problems/interleaving-string/
	 */
	public static boolean checkInterleaving(int p1, int p2, int p3) {
		if (p3 == s3.length()) {
			return true;
		}
		
		String key = p1 + "-" + p2 + "-" + p3;
		
		if(hm.containsKey(key)) {
			return hm.get(key);
		}
		
		if (p1 == s1.length()) {
			hm.put(key, (s2.charAt(p2) == s3.charAt(p3)) && checkInterleaving(p1, p2 + 1, p3 + 1));
		} else if (p2 == s2.length()) {
			hm.put(key, (s1.charAt(p1) == s3.charAt(p3)) && checkInterleaving(p1 + 1, p2, p3 + 1));
		} else {
			boolean checkBothOptions = (s1.charAt(p1) == s3.charAt(p3)) && checkInterleaving(p1 + 1, p2, p3 + 1) || 
					(s2.charAt(p2) == s3.charAt(p3)) && checkInterleaving(p1, p2 + 1, p3 + 1);
			hm.put(key, checkBothOptions);
		}
		
		return hm.get(key);
	}
	
	public static void main(String[] args) {
		s1 = "aabcc";
		s2 = "dbbca";
		s3 = "aadbbcbcac";
		if (s1.length() + s2.length() != s3.length()) {
            System.out.println(false);
        } else {
        	System.out.println(checkInterleaving(0, 0, 0));
        }
	}
}
