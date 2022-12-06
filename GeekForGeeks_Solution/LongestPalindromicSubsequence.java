package JavaLearn.GeekForGeeks_Solution;

// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
public class LongestPalindromicSubsequence {

	public static void main(String[]args) {
		//String s = "XAPBCBQRALM";
		String s = "BBABCBCAB";
		int l = s.length();
		
		// Since this problem has overlapping substructure we are going to store solutions of smaller problems in a table (matrix)
		int[][] table = new int[l][l];
		
		// as explained in the interview concepts doc we will have the diagonal elements 1 (single character is a palindrom of length 1)
		int i, j;
		for(i=0; i<l;i++) {
			table[i][i] = 1;
		}
		
		// we have to fill up the entire upper half of the table. We have to fill diagonal by diagonal. The first one is all 1s. We have to fill the
		// next diagonal some of which will have value 2 if the two letters are the same, 0 otherwise
		// the outer loop will be for the number of diagonals.
		// the inner loop will be for the cells in each diagonal
		
		// The first diagonal table[i][i] is already calculated. we start from second diagonal (i=1)
		for(i=1; i<l; i++) {
			//System.out.println();
			for (j=0; j<=l-1-i; j++) {
				/**
				 * Now we need to decide the cell value of each diagonal. Clearly for each diagonal the rows will vary from 0 to l-1-i, 
				 * which means the row would be j. The column values will also vary as the row values but they start at an offset of i. cell = table[j][i+j]. For 
				 * first diagonal (i=0), the cells computed are of the form - table[j][j]. The second diagonal cells will be table[j][j+1], third - table[j][j+2].
				 * The last column would be i+j = i + (l-1-i) = l-1. You can see that this value is independent of i and would always run up to l-1. 
				 * The last row however is dependent on i would be l-1 for the first diagonal, l-2 for the next 
				 */
				int row = j;
				int col = i+j;
				//System.out.println("r "+row+" c "+col);
				
				// each cell of a diagonal - table[row][col]
				// remember table[row][col] represent the length of the palindromic subsequence S[row..col]. So to fill table[row][col] we need to check
				// s[row] and s[col]
				if(s.charAt(row) == s.charAt(col)) {
					
					// check if col = row+1 . This is the case of two character palindrome. The length is 2 (base case)
					if(col==row + 1) {
						table[row][col] = 2;
					} else {
						// diagonally opposite + 2
						table[row][col] = 2 + table[row + 1][col - 1]; 
					}
					
				} else {
					
					if(col==row + 1) {
						table[row][col] = 0;
					} else {
						// we have to find the max between the left and bottom values. Notice these values will already be filled from the way we are traversing
						// the matrix diagonal by diagonal
						table[row][col] = Math.max(table[row + 1][col] /*bottom*/, table[row][col - 1] /*left*/);
					}
				}
			}
		}
		
		printTable(table,l);
		
		System.out.println();
		
		System.out.println("Largest palindromic subsequence "+table[0][l-1]);
		
		
		
	}
	
	public static void printTable(int[][] arr, int sz) {
		
		for(int i=0; i<sz; i++) {
			for(int j=0; j<sz; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
}


