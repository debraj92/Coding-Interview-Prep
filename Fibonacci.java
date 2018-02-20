package JavaLearn;


public class Fibonacci {

	public static void main(String[] arg){
		FibonacciHelper f = new FibonacciHelper();
		//int ans = f.getFibonacci(9);
		
		for(int i = 0; i<9;i++) {
		int ans1 = f.getFibonacciWR(i);
		System.out.print(" "+ans1);
		}
		System.out.println();
		//System.out.println("the nth element in the series is "+ans);
		//System.out.println(ans1);
	}
}

class FibonacciHelper{
	public int getFibonacci(int n){
		
		int a = 0;
		int b = 1;
		int fib=1;
		System.out.print("0 1");
		for (int i = 2; i <= n; i++) {
			fib = a + b;
			System.out.print(" "+fib);
			a= b;
			b= fib;
		}
		return fib;
	}
	
	public int getFibonacciWR(int n){
		if(n == 0)
			return 0;
		if(n == 1 || n ==2){
			return 1;
		}
		int n1 = getFibonacciWR(n-1);
		int n2 = getFibonacciWR(n-2);

		return n1+n2;
	}
}