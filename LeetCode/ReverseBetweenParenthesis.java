package Practice;

import java.util.Stack;

public class ReverseBetweenParenthesis {

	/**
	 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
	 * 
	 * Consider the string : ab(cd(ef))gh
	 * 
	 * Lets use a place holder variable called : holder. This variable stores the final string between 
	 * two parenthesis. Initially it will contain ab. Then ab is stored in stack (T).
	 * T : ab |
	 * holder = cd -> T: ab | cd
	 * holder = ef. We encounter a closing parenthesis, so we reverse ef and append to cd. -> T: ab, holder = cdfe
	 * T: ,holder = abefdc
	 * holder = abefdcgh
	 * 	 
	 */
	public static void reverse(String s) {
		
		Stack<String> st = new Stack<>();
		
		String holder = "";
		
		for(int i= 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				st.push(holder);
				holder = "";
				break;
			case ')':
				holder = reverseString(holder);
				if(!st.isEmpty()) {
					holder = st.pop() + holder;
				}
				break;
				default:
					holder += c;
					
			}
		}
		
		if(!st.isEmpty()) {
			holder = st.pop() + holder;
		}
		
		System.out.println(holder);
	}
	
	public static String reverseString(String s) {
		String reversed = "";
		for(int i = s.length() - 1; i>=0; i--) {
			reversed += s.charAt(i);
		}
		return reversed;
	}
	
	public static void main(String[]args) {
		reverse("(skeeg(for)skeeg)"); 
		reverse( "((ng)ipm(ca))" ); 
		reverse( "ab(cd(ef))gh" ); 
	}
}
