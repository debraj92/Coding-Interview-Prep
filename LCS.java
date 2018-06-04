package JavaLearn;

/**
 * Longest Common Subsequence
 * https://www.geeksforgeeks.org/longest-common-subsequence/
 */

public class LCS {
	public static void main(String[]args) {
		String s1 = "AGGTAB";//"ABCDGH";
		String s2 = "GXTXAYB";//"AEDFHR";
		System.out.println(FindLengthLCS(s1,s2,0,0,0));
	}
	
	public static int FindLengthLCS (String s1, String s2, int i1, int i2, int len) {
		if(i1 == s1.length() || i2 == s2.length()) {
			return len;
		}
		if(s1.charAt(i1) == s2.charAt(i2)) {
			return FindLengthLCS(s1,s2,i1+1,i2+1,len+1);
		} else {
			return Math.max(
					FindLengthLCS(s1,s2,i1+1,i2,len),
					FindLengthLCS(s1,s2,i1,i2+1,len)
					);
		}
	}
 }
