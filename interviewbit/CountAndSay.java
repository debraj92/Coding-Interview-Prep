package JavaLearn.interviewbit;

// https://www.interviewbit.com/problems/count-and-say/
/**
 * The count-and-say sequence is the sequence of integers beginning as follows: 
	1, 11, 21, 1211, 111221, ...
	1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
	21 is read off as one 2, then one 1 or 1211.
	
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.
 *
 */

public class CountAndSay {
	
	public static String countAndSay(int a) {
        String cur = "1";
        for(int i=2; i<=a; i++) {
        		System.out.println(cur);
            cur = findNext(cur);
        }
        System.out.println(cur);
        return cur;
    }
    
	//1, 11, 21, 1211, 111221,
	public static String findNext(String s) {
	    String next = "";
	    int i = 0,j = 0;
	    for(i=0; i< s.length()-1;i++) {
	        for(j=i+1; j<s.length(); j++) {
	            if(s.charAt(i)!=s.charAt(j)) break;
	        }
	        next += String.valueOf(j-i) + s.charAt(i);
	        i=j-1;
	    }
	    if(i == s.length()-1) {
	        next += "1"+s.charAt(s.length()-1);
	    }
	    return next;
	}
	
	public static void main(String[]args) {
		countAndSay(5);
	}
	    
}
