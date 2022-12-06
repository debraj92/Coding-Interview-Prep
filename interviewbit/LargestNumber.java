package JavaLearn.interviewbit;

import java.util.*;

public class LargestNumber {

	/**
	 * To find the largest number we will have to sort the list. But for sorting we have to use append to 
	 * check which is greater. For example -
	 * In regular sort : 34 > 9
	 * But here we want 9 to appear before 34.
	 * So we use APPEND. We pick the greater from : { 349, 934}
	 */
	public static String largestNumber(final List<Integer> a) {
	    
	    Collections.sort(a, new Comparator<Integer>() {
	    	
	        public int compare(Integer a, Integer b) {
	            String ba = b.toString()+a.toString();
	            String ab = a.toString()+b.toString();
	            /**
	    		 	* Here we are sorting in descending order, so we are using the compareTo with 
	    		 	* ba first and then ab 
	    		 	*/
	            return (ba).compareTo(ab);
	        }
	    });
	    
	    /**
	     * We must use StringBuilder for efficiency as there will be a large number of concatenations.
	     */
	    StringBuilder sb = new StringBuilder();

	    /**
	     * In the final result we need to remove all leading zeroes.
	     * For example -> 00094 = 94
	     */
	    boolean non_zero_seen = false;
	    for(int x: a) {
	        if(non_zero_seen) {
	            sb.append(x);
	        } else {
	            if(x != 0) {
	                non_zero_seen = true;
	                sb.append(x);
	            } 
	        }
	        
	    }
	    String out = sb.toString();
	    /**
	     * If there are only zeroes our output string will be empty. So we need to return "0"
	     */
	    return out.equals("") ? "0" : out;   
	    }
	

	public static void main(String[] args) {
		ArrayList<Integer> alist = new ArrayList<>();
		//3, 30, 34, 5, 9
		alist.add(3);
		alist.add(30);
		alist.add(34);
		alist.add(5);
		alist.add(9);
		System.out.println(largestNumber(alist));
	}
	
}

