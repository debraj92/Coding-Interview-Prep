package JavaLearn.interviewbit;

// https://www.interviewbit.com/problems/grid-unique-paths/

public class GridPaths {
	public static int uniquePaths(int a, int b) {
        int[][] m = new int[a][b];
        m[0][0] = 0;
        int i,j;
        for (i=1; i<a; i++) {
            m[i][0] = 1;
        }
        for (i=1; i<b; i++) {
            m[0][i] = 1;
        }
        for (i=1; i<a; i++) {
            for (j=1; j<b; j++) {
                m[i][j] = m[i-1][j] + m[i][j-1];
            }
        }
        return m[a-1][b-1];
    }
	
	public static void main(String[]args) {
		System.out.println(uniquePaths(3,5));
	}
}
