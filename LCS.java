package JavaLearn;

/**
 * Longest Common Subsequence
 * https://www.geeksforgeeks.org/longest-common-subsequence/
 * No recursion - https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * 
 *                                                                           LCS(AGGTAB, GXTXAYB)             len = 0
 *                                                                                   /  \
 *                                                              LCS(GGTAB, GXTXAYB)    LCS(AGGTAB, XTXAYB)
 *                                                                       |
 *                                                                LCS(GTAB, XTXAYB)                           len = 1
 *                                                                     /    \  
 *                                                       LCS(TAB, XTXAYB)   LCS(GTAB, TXAYB)
 *                                                                             /  \
 *                                                                LCS(TAB, TXAYB)
 *                                                                       |
 *                                                               LCS(AB, XAYB)                                len = 2
 *                                                                          \
 *                                                                          LCS(AB, AYB)
 *                                                                               |
 *                                                                          LCS(B, YB)                        len = 3
 *                                                                             /    \
 *                                                                     LCS("", B)    LCS(B, B)
 *                                                                                      |
 *                                                                                LCS("", "")                 len = 4
 *                                                                                
 *                                                        
 *                                                        SEQUENCE : GTAB   (length = 4)
 *                                                                                              
 *                                                                     
 * 
 *    
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
