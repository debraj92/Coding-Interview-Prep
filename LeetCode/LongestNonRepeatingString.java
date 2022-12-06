package Practice;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
/**
 * Logic: Store character, index in a hashmap.
 * Scan till you find a clashing character.
 * Start next string from after the index of the clashing character
 * 
 * The use of start and end is important. Once we find a clash, end is set to that index of the clash.
 * We are sure all the characters before start are outside the window and must be updated in the hashmap.
 * Note the characters between start and end can never cause clash because in the previous scan we would have set end 
 * to this clashing index instead. Therefore all characters between start and end need to be updated in the hashmap.
 * 
 * Once we have passed end, characters can clash with those we have in the hashmap.
 * The hashmap also has stale data, but they won't pass the check: chars.get(s.charAt(i)) - start >= 0
 * So, in this case the data is refreshed.
 * 
 */
public class LongestNonRepeatingString {
	public static void main(String[]args) {
		String s = "abcabcbb";
		Map<Character, Integer> chars = new HashMap<>();
		int maxLength = 0;
		int start = 0;
		int end = 0;
		int i;
		for (i=0; i<s.length(); i++) {
			if(chars.containsKey(s.charAt(i)) && chars.get(s.charAt(i)) - start >= 0 && i >= end) {
				
				maxLength = i - start > maxLength ? i - start : maxLength;
				end = i;
            	i = chars.get(s.charAt(i));
            	start = i + 1;
            } else {
            	chars.put(s.charAt(i), i);
            }
			
		}
		
		maxLength = i - start > maxLength ? i - start : maxLength;
        
        System.out.println(maxLength);
        System.out.println(start);
	}
}
