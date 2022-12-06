package JavaLearn.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-sum-path-in-triangle/
 */
public class MinSumPathTriangleClient {
	public static void main(String[]args) {
		MinSumPathTriangle obj = new MinSumPathTriangle();
		System.out.println(obj.minimumTotal(getInput1()));
		System.out.println(obj.minimumTotal(getInput2()));
		System.out.println(obj.minimumTotal(getInput3()));
	}
	
	/**
	 * 
	 *                2
	 *               / \
	 *             3     4
	 *            / \   / \
	 *           6    5    7
	 *          / \  / \  / \
	 *         4    1    8   3
	 *         
	 * 
	 * 	Expected output = 2 + 3 + 5 + 1 = 11
	 */
	public static ArrayList<ArrayList<Integer>> getInput1() {
		ArrayList<Integer> r1, r2, r3, r4;
		r1 = new ArrayList<>();
		r2 = new ArrayList<>();
		r3 = new ArrayList<>();
		r4 = new ArrayList<>();
		r1.add(2);
		r2.add(3);
		r2.add(4);
		r3.add(6);
		r3.add(5);
		r3.add(7);
		r4.add(4);
		r4.add(1);
		r4.add(8);
		r4.add(3);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(r1);
		result.add(r2);
		result.add(r3);
		result.add(r4);
		return result;
	}
	
	/**
	 * 
	 *                   3
	 *                  6 4
	 *                 5 2 7
	 *                9 1 8 6
	 *         
	 *  Expected output = 3 + 4 + 2 + 1 = 10
	 * 	
	 */
	public static ArrayList<ArrayList<Integer>> getInput2() {
		ArrayList<Integer> r1, r2, r3, r4;
		r1 = new ArrayList<>();
		r2 = new ArrayList<>();
		r3 = new ArrayList<>();
		r4 = new ArrayList<>();
		r1.add(3);
		r2.add(6);
		r2.add(4);
		r3.add(5);
		r3.add(2);
		r3.add(7);
		r4.add(9);
		r4.add(1);
		r4.add(8);
		r4.add(6);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(r1);
		result.add(r2);
		result.add(r3);
		result.add(r4);
		return result;
	}
	
	/**
	 * 
	 *                   1
	 *                  2 3
	 *         
	 *  Expected output = 1 + 2 = 3
	 * 	
	 */
	public static ArrayList<ArrayList<Integer>> getInput3() {
		ArrayList<Integer> r1, r2;
		r1 = new ArrayList<>();
		r2 = new ArrayList<>();
		r1.add(1);
		r2.add(2);
		r2.add(3);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(r1);
		result.add(r2);
		return result;
	}
}

class MinSumPathTriangle {
	
	/**
	 * Concept:

	 *                2                      ---- level 1
	 *               / \                     ---- level 2
	 *             3     4
	 *            / \   / \
	 *           6    5    7
	 *          / \  / \  / \
	 *         4    1    8   3
	 *   mem[_,_,_, _,_, _,_,_,_]   {BEFORE}
	 *   
	  mem[INF,15,11,11,10,18,13,16,INF] {AFTER}
	 *         
	 *         
	 *  We will use DP to solve this problem. For this, we create a memory array of size 2 X last_row + 1.
	 *  Each cell of the memory indicates the minimum sum path to reach that element. Also note, the mem array is actually a projection of the input two dimensional array into one dimension.
	 *  This means, we have to process the elements in the memory in the same sequence as level-order traversal of the input array.
	 *  So, first we update mem[middle] for level 1. For, level 2, we update mem[middle - 1] and mem[middle + 1].
	 *  
	 *  Core concept: Lets consider the element 5. The minimum path to this element would be 5 + min_of_different_paths_to_5 = 5 + min (5,6) = 5 + 5 = 10
	 *  When we update element x of mem, we do so as :
	 *  mem[x] = element + min(mem[x-1], mem[x+1])
	 *  
	 *  Also note, while mem[x] belongs to the current row, mem[x-1] and mem[x+1] will belong to the previous row           
	 * 
	 */
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> list) {

		/**
		 * We need a memory array of size = 2 * last_row_size + 1. In this case, 4 * 2 + 1 = 9
		 */
		int[] mem = new int[list.size() * 2 + 1];
		// Populate memory with infinity
		for(int i=0; i<mem.length; i++) {
			mem[i] = Integer.MAX_VALUE;
		}
		int middleIndex = list.size();
		// The top element sits at the middle of this array
		mem[middleIndex] = list.get(0).get(0);
		int memPointer;
		/**
		 * Iterate for all rows and all elements in each row
		 */
		for(int row=1; row < list.size(); row++) {
			memPointer = middleIndex - row;
			for(int rowElemIdx=0; rowElemIdx < list.get(row).size(); rowElemIdx++) {
				int rowElem = list.get(row).get(rowElemIdx);
				mem[memPointer] = rowElem + Math.min(mem[memPointer-1], mem[memPointer+1]);
				memPointer += 2;
			}
		}
		
		// Last row elements will start from index 1 in the mem array. We have to find the minimum
		int min = mem[1];
		for(int i=1; i<mem.length; i+=2) {
			min = Math.min(min, mem[i]);
		}
		
		return min;
    }
	

}


