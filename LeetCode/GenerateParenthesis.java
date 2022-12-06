package JavaLearn.LeetCode;

import java.util.ArrayList;
import java.util.List;

/// https://leetcode.com/problems/generate-parentheses/submissions/
/**
 * The idea is to create balanced parenthesis strings. To ensure balance, we need to track count of open brackets. 
 * Each function call can produce 2 child calls:
 *  i. string + (
 *  ii. string + )
 *  
 *  If we call i, we do not reduce n and if we call ii we reduce n.
 *  Also for i we increase value of countOpenBrackets and for ii we reduce value of countOpenBrackets
 *  ii is allowed only if countOpenBrackets > 0 so that balance is maintained.
 *  
 *  We have two base case:
 *  1. All open brackets used up and all closed brackets used up (n == 0) => result stored in array list
 *  2. All open brackets used up (countOpenBrackets == n) => close all brackets and store
 *
 */
public class GenerateParenthesis {
	
	public static String closeAllBrackets(String original, int countOpenBrackets) {
		String result = original;
		while (countOpenBrackets > 0) {
			result += ")";
			countOpenBrackets--;
		}
		return result;
	}

	public static void generateParenthesis(int countOpenBrackets, int n, String result, List<String> list) {
        
		if (n == 0) {
            list.add(result);
            return;
        }
		
		if (countOpenBrackets == n) {
			result = closeAllBrackets(result, countOpenBrackets);
			list.add(result);
            return;
		}
        
		if (countOpenBrackets > 0) {
			generateParenthesis(countOpenBrackets - 1, n - 1, result + ")", list);
		}
		
		generateParenthesis(countOpenBrackets + 1, n, result + "(", list);
        
    }
    
    
    public static List<String> generateParenthesis(int n) {
    		List<String> list = new ArrayList<>();
    		generateParenthesis(0, n, "", list);
        return list;
    }
    
    public static void main(String[] args) {
    		List<String> l = generateParenthesis(3);
    		System.out.println(l);
    }
}
