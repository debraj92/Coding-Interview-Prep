package JavaLearn;
import java.util.HashMap;
import java.util.Map;

/**
 * Problems: https://www.testdome.com/d/java-interview-questions/4\
 *
 */

public class TestDome {
	public static void main(String[] args) {
        /*Path path = new Path("/a");
        path.cd("..");
        System.out.println(path.getPath());*/
		//System.out.println(SortedSearch.countNumbers(new int[] { 3, 5}, 4));
		
		int[] indices = TwoSum.findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}

/**
 * Write a function that provides change directory (cd) function for an abstract file system.

Notes:

Root path is '/'.
Path separator is '/'.
Parent directory is addressable as "..".
Directory names consist only of English alphabet letters (A-Z and a-z).
The function should support both relative and absolute paths.
The function will not be passed any invalid paths.
 *
 */
class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd2(String n) {
        if (n.equals("..")) {
            if(!path.equals("/")) {
            		int lastSlash = path.lastIndexOf("/");
            		if (lastSlash == 0) {
            			path = "/";
            		} else {
            			path = path.substring(0,lastSlash);
            		}
            }
        } else {
            path += "/" + n;
        }
    }
    
    public void cd(String n) {
        String[] s = n.split("/");
        for(String p: s){
            cd2(p);
        }
    }

}

/**
 * Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to 
 * time used, counts the number of array elements that are less than the parameter lessThan.
 *
 */
class SortedSearch {
	public static int countNumbers(int[] a, int lessThan) {
        int l=0;
        int h=a.length-1;
        /**
         * We first check the base cases.
         * All elements greater than given element. Answer = length of array
         * All elements less than given element. Answer = 0
         * 
         */
        if(a[h]<lessThan) return a.length;
        if(a[l]>=lessThan) return 0;
        
        // Now, notice we have already checked the case for the 0th element. That is the 0th element can be the partition 
        // only if it is greater than or equal to the given element. Thus we will exclude it from the binary search.
        // However, the nth element has not yet been completely checked whether it can be the partition. As of now 
        // we know that if the nth element is smaller than the given element it will be the partition. However, it will 
        // also be the partition if the element before it is smaller than the given element and it is larger. This case 
        // is not checked in the base case and hence we cannot remove the nth element from the binary search.
        l++;
        int m = (l+h)/2; // count
        while(l<h && !(a[m-1] < lessThan && a[m] >= lessThan))
        {
        	    /**
        	     * if mid is less than given element then partition is to the right half of the array.
        	     */
            if(a[m] < lessThan) l = m+1;
            /**
    	     	* if mid is greater than given element then partition is to the left half of the array. If mid is equal to the 
    	     	* given element we still have to go left to find the first element equal to the given element.
    	     	*/
            else if (a[m] >= lessThan) h = m-1;
            m = (l+h)/2;
        }
        return m;
    }
}

/**
 * Write a function that, when passed a list and a target sum, returns, efficiently with respect to time used, 
 * two distinct zero-based indices of any two of the numbers, whose sum is equal to the target sum. 
 * If there are no two numbers, the function should return null.
 *
 */
class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> s = new HashMap<>();
        int[] y = new int[2];
        int c=-1;
        boolean f=false;
        for (int x: list) {
            c++;
            if(s.containsKey(sum - x)) {
                y[0] = s.get(sum - x);
                y[1] = c;
                f=true;
                break;
            }
            s.put(x,c);
        }
        if(f) return y;
        return null;
    }

}


