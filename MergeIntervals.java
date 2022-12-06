package JavaLearn;

import java.util.Stack;

/**
 * https://www.techiedelight.com/merging-overlapping-intervals/
 * 
 * Input:  {1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
 *
 * Intervals after merging overlapping intervals are {1, 6}, {7, 10}, {12, 15}.
 */

public class MergeIntervals {
	public static void main(String args[]) {
		/**
		 * The start array must be sorted. Otherwise we have to sort the array.
		 */
		int[] starts = new int[] {1,2,4,7,8,12};
		int[] ends = new int[] {5,3,6,8,10,15};
		merge(starts, ends);
	}
	
	public static void merge(int[] starts, int[] ends) {
		// The stack will contain the merged intervals. For each interval there will be two entries
		// inserted into the stack. The first is start and the second is end.
		Stack<Integer> st = new Stack<>();
		int count = starts.length;
		int start, end, prev_start, prev_end;
		st.push(starts[0]);
		st.push(ends[0]);
		for(int i=1; i<count; i++) {
			start = starts[i];
			end = ends[i];
			// check if the new interval can be merged with the previous interval in the stack
			prev_end = st.pop();
			prev_start = st.pop();
			/**
			 *    prev_st     prev_end
			 *    <----------->
			 *         <------------>
			 *         strt        end
			 * merged:
			 *    <----------------->
			 *    
			 *         s   e
			 *         <--->
			 * merged:
			 *     <---------->
			 */
			if(start <= prev_end) {
				// merge is needed
				start = prev_start;
				if(end <= prev_end) {
					end = prev_end; 
				}
			} else {
				// new interval. we need to keep the previous interval intact
				st.push(prev_start);
				st.push(prev_end);
			}
			// The new interval or the merged interval is added to stack
			st.push(start);
			st.push(end);
			
		}
		
		while(!st.isEmpty()) {
			end = st.pop();
			start = st.pop();
			System.out.println("("+start+", "+end+")");
		}
	}
}
