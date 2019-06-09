package JavaLearn.GeekForGeeks_Solution;

import static java.lang.System.*;

public class Permutations {
  public static void main(String[]args) {
	  String x1 = "abcd";
	  String x2 = "aabc";
	  String x3 = "aab";
	  Permute p = new Permute();
	  p.permuteWithoutDuplicates(x1);
	  //p.permuteWithDuplicates(x2);
	  //p.permuteWithDuplicates(x3);
  }
  
}

class Permute {
	
	/**
	 * Method : Consider string abc
	 * Fix, first, then fix second
	 *        
	 *        a b c
	 *         / | \  
	 *      a__  b__ c__
	 *      / \
	 *     ab_ ac_
	 *     |   |
	 *    abc  acb
	 */
	
	public void permuteWithoutDuplicates(String s) {
		// result string to hold the final output
		String result = "";
		_permute(s, result);
	}
	
	public void permuteWithDuplicates(String s) {
		// result string to hold the final output
		String result = "";
		_permute2(s, result);
	}
	
	// internal : does not handle duplicates
	private void _permute (String original, String res) {
		
		if (original.equals("")) {
			out.println(res);
		   	return;
		}
		
		for(int i=0; i<original.length(); i++) {
			// use different available chars from the original string at this level
			char ch = original.charAt(i);
			// at each level we are going to call the next level with reduced character set (these characters are fixed)
			// Note: We are not modifying the original. It is needed for choosing another possible character at this location.
			// Also see how remove is returning a new String and not the original string. If we used the original string then
			// it will get exhausted once we get a complete string like - abc or acb or bca
			String modified = remove(original, i);
			_permute(modified,res+ch);
			
		}
	}
	
	// internal : handle duplicates (check _permute first)
    private void _permute2 (String original, String res) {
		
		if (original.equals("")) {
			out.println(res);
		   	return;
		}
		// The idea is that each level should have unique characters from the original string.
		// So if we have placed a character already in a position, we are not going to place it again in that position
		// even if the original string has duplicates.
		
		// we can consider using simple hashing to check if a character is already inserted
		int[] charset = new int[26];
		
		for(int i=0; i<original.length(); i++) {
			// use different available chars from the original string at this level
			char ch = original.charAt(i);
			
			// dont consider if the character is already considered for this position
			if(charset[ch-'a'] == 1) continue;
			charset[ch-'a'] = 1;
			
			String modified = remove(original, i);
			_permute2(modified,res+ch);
			
		}
	}
	
	private String remove(String s, int idx) {
		if(idx==s.length()-1) {
			return s.substring(0, idx);
		}
		return s.substring(0, idx) + s.substring(idx+1);
	}
	
}
