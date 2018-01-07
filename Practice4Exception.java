package JavaLearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice4Exception {
	
	public static void main(String[]args) {
		ExceptionHandling ex = new ExceptionHandling();
		ex.caller();
		System.out.println("Hello");
	}
}


class CustomException extends Exception {
	CustomException(String errorMessage) {
		super(errorMessage);
	}
}

class ExceptionHandling {
	
	public void caller() {
		System.out.println("Caller invoked");
		try {
		callee1();
		callee2();
		callee3();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
			cancel();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			cancel();
		}
	}
	
	public void callee1() throws CustomException {
		System.out.println("Callee1 invoked");
		throw new CustomException("Some problem has happened, throwing CustomException from callee1");
	}
	
	public void callee2() throws CustomException {
		System.out.println("Callee2 invoked");
		throw new CustomException("Some problem has happened, throwing CustomException from callee2");
	}
	
	public void callee3() throws FileNotFoundException {
		System.out.println("Callee3 invoked");
		File file = new File("abc.txt");
		Scanner in = new Scanner(file);
	}
	
	public void cancel() {
		System.out.println("Resetting state of the application");
	}
}


