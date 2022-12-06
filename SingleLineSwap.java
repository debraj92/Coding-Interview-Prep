package JavaLearn;

public class SingleLineSwap {
	public static void main(String [] args) {
		int a = 5, b =6;
		System.out.println("Before Swap");
		System.out.println("a "+a);
		System.out.println("b "+b);
		a = a + b - (b=a);
		System.out.println("After Swap");
		System.out.println("a "+a);
		System.out.println("b "+b);
	}
}
