package JavaLearn;


public class PalindromePracticeClient {
	public static void main(String[]args) {
		String palin ="hello";//"Malayalam";
		
		int num = 87656787;
		/*PalindromeChecker palindromeCheck = new PalindromeChecker();
		boolean result = palindromeCheck.isPalindromeString(palin);
		System.out.println("The string isPalindrome? " +result);
		*/
		
		PalindromeChecker palindromeCheck= new PalindromeChecker();
		boolean result = palindromeCheck.isPalindromeNumber(num);
		System.out.println("The number isPalindrome? " +result);
		
		BalancedParenthesisCheck parenthesisCheck = new BalancedParenthesisCheck();
		String exp = "[{[p+q] - {n*p}+(q+r)}] - (a+b*{c-d})";
		String exp2 = "{[a(b*c]s+4)}";
		boolean result2 = parenthesisCheck.isParenthesisBalanced(exp2);
		System.out.println("isParenthesisBalanced? "+result2);
	}
}

class PalindromeChecker {

	/**
	 * Checks if a string is palindrome
	 * @param str
	 * @return
	 */
	public boolean isPalindromeString(String str) {

		StackList<Character> l = new StackList<>();
		for (int i = 0; i < str.length(); i++) {
			l.push(str.charAt(i));
		}
		l.printStack();
		String reversedString = "";
		while (!l.isEmpty()) {
			char c = l.pop();
			reversedString += c;
		}
		// System.out.println(reversedString);
		if (str.equalsIgnoreCase(reversedString)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if a number is palindrome
	 * @param num
	 * @return
	 */
	public boolean isPalindromeNumber(int num) {
		int temp = num;
		int digit = 0;
		int reversed = 0;

		while (temp != 0) {

			digit = temp % 10;
			temp = temp / 10;
			reversed = (reversed * 10) + digit;

		}
		System.out.println(reversed);
		if (num == reversed) {
			return true;
		}

		return false;
	}
	
	public int numberOfDigits(int num){
		int c = 0;
		while(num!=0){
			num /= 10;
			c++;	
		}
		System.out.println(c);
		return c;
	}
}

class BalancedParenthesisCheck {
	boolean isParenthesisBalanced(String str) {

		StackList<Character> l = new StackList<>();
		char[] letters = str.toCharArray();
		Character lastBracket;
		for (char letter : letters) {
			System.out.println(letter);
			switch (letter) {
			case '(':
			case '{':
			case '[':
				l.push(letter);
				break;
			case ']':
				lastBracket = l.pop();
				if (lastBracket == null || lastBracket != '[') {
					return false;
				}
				break;
			case '}':
				lastBracket = l.pop();
				if (lastBracket == null || lastBracket != '{') {
					return false;
				}
				break;
			case ')':
				lastBracket = l.pop();
				if (lastBracket == null || lastBracket != '(') {
					return false;
				}
				break;
			default:
			}
		}
		if (l.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}