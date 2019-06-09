package JavaLearn.GeekForGeeks_Solution;


/**
 * Find the longest increasing subsequence
 *
 */
class LIS_Solve {
	
	/**
	 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
	 * 
	 * Dynamic Programming based algorithm
	 * Algo: Consider the sequence - S: 10, 22, 9, 33, 21, 50, 41, 60, 80
	 * We define L(i) as the longest subsequence till the ith element.
	 * Now, L(0) = L({10}) = 1 -> The base condition
	 * Next we need a way to calculate L(i) given that we know the answers of all j < i
	 * Turns out, L(i) can be calculated as:
	 * L(i) = MAX(L(j) | j<i and S[j] < S[i]) + S[i]
	 * That is the longest subsequence ending at i is actually the longest subsequences seen till now with its tail
	 * less than i.
	 * 
	 * Input : 10, 22, 9, 33, 21, 50, 41, 60, 80
	 * Outputs:
	 * 10
	 * 10 22
	 * 9
	 * 10 22 33
	 * 9 21
	 * 10 22 33 50
	 * 10 22 33 41
	 * 10 22 33 41 60
	 * 10 22 33 41 60 80
	 * Longest increasing subsequence length 6
	 * 
	 * Input : 2,7,4,3,8
	 * Outputs:
	 * 2
	 * 2 7
	 * 2 4
	 * 2 3
	 * 2 3 8
	 * Longest increasing subsequence length 3
	 */
	public static void LIS_solve(int[] arr) {
		//in DP we need to maintain extra space to store the result
		int[] L = new int[arr.length];
		// for printing only
		String[] L_values = new String[arr.length];
		//base condition
		L[0] = 1;
		L_values[0] = ""+arr[0];
		// final answer
		int MAX_LIS = 0;
		for(int i=1; i < arr.length; i++) {
			// Length of longest subsequence till i excluding i
			int max = 0; 
			// for printing
			int max_index = -1;
			for (int j=i-1; j >= 0; j--) {
				if (arr[j]<arr[i] && L[j] > max) {
					max = L[j];
					max_index = j;
				}
			}
			L[i] = max + 1;
			L_values[i] = ( max_index >= 0) ? (L_values[max_index] + " " + arr[i]) : ("" + arr[i]);
			MAX_LIS = L[i] > MAX_LIS ? L[i]:MAX_LIS;
		}
		printUtil(L_values);
		System.out.println("Longest increasing subsequence length "+MAX_LIS);
	}
	
	public static void printUtil(String[] L_values) {
		for(String s: L_values) {
			System.out.println(s);
		}
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
	 * 
	 * Find maximum sum subsequence - MSS
	 * 
	 * input - 2,7,4,3,8
	 * output - 17
	 * Explain - 2 + 7 + 8 = 17
	 * 
	 * input - 10, 22, 9, 33, 21, 50, 41, 60, 80
	 * output - 10 + 22 + 33 + 50 + 60 + 80 = 255
	 * 
	 * input - 1 101 2 3 100 4 5
	 * output - 106
	 * explain - 1 2 3 100 = 106
	 */
	public static void MSS(int[] arr) {
		// Will contain max sum till i
		int[] S = new int[arr.length];
		S[0] = arr[0];
		int MAX_SUM= 0;
		for(int i=1; i < arr.length; i++) {
			// Length of longest subsequence till i excluding i
			int max = 0;
			for (int j=i-1; j >= 0; j--) {
				if (arr[j]<arr[i] && S[j] > max) {
					max = S[j];
				}
			}
			S[i] = max + arr[i];
			MAX_SUM = S[i] > MAX_SUM ? S[i]:MAX_SUM;
		}
		System.out.println("Maximum Sum "+MAX_SUM);
	}
}

public class LIS{
	public static void main(String[]args) {
		int[] arr = new int[] {1, 101, 2, 3, 100, 4, 5}; 
		LIS_Solve.LIS_solve(arr);
		LIS_Solve.MSS(arr);
		// Note the longest subsequence may not have the largest sum. So LIS answer may not match MSS answer.
	}
}
