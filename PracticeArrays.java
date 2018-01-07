
public class PracticeArrays {
	public static void main(String[]args) {
		int[][] a = new int[3][];
		a[0] = new int[] {1,2};
		a[1] = new int[] {3,4,5};
		a[2] = new int[] {6,7,8,9};
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c<a[r].length;c++) {
				System.out.print(a[r][c]+" ");
			}
			System.out.println();
		}
	}
}
