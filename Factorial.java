package JavaLearn;


public class Factorial {
	public static void main(String[]args){
		FactorialHepler factHelp = new FactorialHepler();
		int answer = factHelp.findFactorialWithRecursion(5);
		int answer2 = factHelp.findFactorialWithoutRecursion(5);
		System.out.println(answer);
		System.out.println(answer2);
	}
}

class FactorialHepler{
	/**
	 * f(n) = {n*f(n-1) if n > 1} || {1 if n==1}
	 * @param n
	 * @return
	 */
	public int findFactorialWithRecursion(int n) {
		//System.out.println(n);
		if(n<1) {
			//throw an error
			System.out.println("Factorial of 0 or negative numbers is undefined");
			return -1;
		}
		if(n==1) {
			return 1;
		} else {
			return n * findFactorialWithRecursion(n-1);
		}
	}
	
	public int findFactorialWithoutRecursion(int n) {
		if(n<1) {
			//throw an error
			System.out.println("Factorial of 0 or negative numbers is undefined");
			return -1;
		}
		int ans = 1;
		while(n>1) {
			ans = n * ans;
			n--;
		}
		return ans;
	}
}