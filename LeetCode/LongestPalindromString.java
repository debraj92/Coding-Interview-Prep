package Practice;

/**
 * The Question:
 *  https://leetcode.com/problems/longest-palindromic-substring/
 *
 *	We will use DP. Create a table T of size n X n where n is string size.
 *  Each element T[i][j] is true is the length of the string from i to j is a palindrome.
 *  
 *  Base case:
 *  All single characters are palindrome
 *  Check if 2 character strings are palindromes.
 *  
 *  Rule to check bigger strings.
 *  T[i][j] = T[i+1][j-1] and s[i]==s[j]
 *  S is the original string. We are talking about s[i..j] = s[i]s[i+1...j-1]s[j]
 *  To know if s[i+1...j-1] is palindrome, refer to T[i+1][j-1]
 */

public class LongestPalindromString {
	
	public static void main(String [] args) {
		String s = "dsahjvdjfmalayalamjshjadsads";
		boolean[][] T = new boolean[s.length()][s.length()];
		int n = s.length();
		int maxLength = 1;
		int start = 0;
		// base cases
		for(int i=0; i<n; i++) {
			T[i][i] = true;
		}
		
		for(int i=0; i<n-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				T[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}
		
		// iteratively check strings bigger than 2
		for(int k = 3; k<=n; k++) {
			for(int i=0; i<n && i + k - 1 < n; i++) {
				int j = i + k - 1;
				if(T[i+1][j-1] && s.charAt(i)==s.charAt(j)) {
					T[i][j] = true;
					maxLength = k;
					start = i;
				}
			}
		}
		
		System.out.println("Max length palindrome " + maxLength);
		System.out.println("Palindrome: "+s.substring(start, start + maxLength));
	}
}
