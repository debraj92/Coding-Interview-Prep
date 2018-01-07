package JavaLearn;


public class Fibonacci {

	public static void main(String[] arg){
		FibonacciHelper f = new FibonacciHelper();
		int ans = f.getFibonacci(5);
		int ans1 = f.getFibonacciWR(5);
		System.out.println(ans);
		System.out.println(ans1);
	}
}

class FibonacciHelper{
	public int getFibonacci(int n){
		
		int a = 1;
		int b = 1;
		int fib=1;
		for (int i = 3; i <= n; i++) {
			fib = a + b;
			a= b;
			b= fib;
			//System.out.println(a+" "+b+" "+n);
		}
		return fib;
	}
	
	public int getFibonacciWR(int n){
		
		if(n == 1 || n ==2){
			return 1;
		}
		
		return getFibonacciWR(n-1) + getFibonacciWR(n-2);
		//return fib1
		
	}
}