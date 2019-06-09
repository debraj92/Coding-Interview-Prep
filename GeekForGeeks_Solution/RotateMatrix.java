package JavaLearn.GeekForGeeks_Solution;

public class RotateMatrix {
	public static void main(String[]args) {
		/*int[][] mat = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		*/
		int[][] mat = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};
		int n = 5;
		RotateHelper r = new RotateHelper();
		System.out.println("Original matrix");
		r.printArr(mat, n);
		System.out.println();
		r.rotate90(mat, n);
		System.out.println("After rotation");
		r.printArr(mat, n);
		System.out.println();
		r.rotate90(mat, n);
		System.out.println("After rotation");
		r.printArr(mat, n);
	}
}

class RotateHelper{
	public void rotate90(int[][] mat, int n) {
		//concentric squares
		for(int x=0; x<n/2; x++) {
			//outermost square is x=0 
			// we have n/2 concentric squares
			//System.out.println("Square No.: "+x);
		for(int i=x; i<(n-1-x); i++) {
			// Note, the cells in square x which moves are in the range x to n-1-x (i bounded) 
				int t = mat[x][x+i];
				//System.out.println("t: "+t);
				/**
				 * We use the transformation :
				 * The element at (r,c) goes to (c,n-1-r)
				 */
				mat[x][x+i] = mat[x+i][n-1-x];
				mat[x+i][n-1-x] = mat[n-1-x][n-1-x-i];
				mat[n-1-x][n-1-x-i] = mat[n-1-x-i][x];
				mat[n-1-x-i][x] = t;
				//printArr(mat, n);
				//System.out.println();
			}
		}
	}
	
	public void printArr(int[][] mat, int n) {
		for(int i=0;i<n;i++) {
			for (int j=0; j<n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
