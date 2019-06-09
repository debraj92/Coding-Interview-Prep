package JavaLearn.GeekForGeeks_Solution;

import java.util.Stack;

class SimpleProblems{
	
	/**
	 * https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
	 */
	public void findLeaders() {
		int[] arr = new int[] {7, 4, 5, 7, 3}; // 7 7 3
				//{1, 2, 3, 4, 0}; // 4 0 
				//{16, 17, 4, 3, 5, 2}; // 2 5 17
		int max = arr[arr.length - 1];
		for(int j= arr.length -1 ;j>=0; j--) {
			if(arr[j]>=max) {
				System.out.println(arr[j]);
				max = arr[j];
			}
		}
	}
	
}


public class Simple {
	public static void main(String[]args) {
		SimpleProblems ob = new SimpleProblems();
		ob.findLeaders();
	}
}


