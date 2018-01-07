package JavaLearn;


public class CustomStackClient {
	
	public static void main(String[] args) {
		System.out.println("Stack Implementation\n");
		createStackWithArray();
		System.out.println();
		createStackWithList();
		System.out.println();
		testPeekEmptyStack();
	}

	public static void createStackWithArray() {
		System.out.println("createStackWithArray");
		StackOperations l = new StackArray();
		try {
			l.push(10);
			l.printStack();
			l.push(20);
			l.push(30);
			l.push(50);
			System.out.println("peeked element " + l.peek());
		} catch (OverflowException o) {
			System.out.println(o.getMessage());
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
		l.printStack();
		System.out.println("Popping all the elements");
		try {
			while (!l.isEmpty()) {
				int poppedElement = l.pop();
				System.out.println("Popped element: " + poppedElement);
			}
		} catch (UnderflowException u) {
			System.out.println(u.getMessage());
		}
	}

	public static void createStackWithList() {
		System.out.println("createStackWithList");
		StackList<String> l = new StackList<>();
		l.push("Isha");
		l.push("Dipu");
		l.push("Debraj");
		l.push("Rath");
		l.printStack();
		System.out.println("peeked element " + l.peek());
		System.out.println("Popping all the elements");
		while (!l.isEmpty()) {
			String poppedName = l.pop();
			System.out.println("Popped Name: " + poppedName);
		}
	}

	public static void testPeekEmptyStack() {
		System.out.println("testPeekEmptyStack");
		StackOperations l = new StackArray();
		try {
			l.peek();
		} catch (UnderflowException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

interface StackOperations {
	public void push(int data) throws OverflowException;

	public boolean isEmpty();

	public int pop() throws UnderflowException;

	public void printStack();

	public int peek() throws UnderflowException;
}

class StackList<E> {
	private Node top;

	/**
	 * Insert in the beginning of the list
	 * 
	 * @param data
	 */
	public void push(E data) {
		Node node = new Node(data);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}

	}

	/**
	 * 
	 * @return data at top of stack, null if stack is empty
	 */
	public E peek() {
		if (top != null) {
			return top.data;
		} else {
			return null;
		}
	}

	/**
	 * Checks if the stack is empty
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		if (top == null) {
			// System.out.println("Stack is Empty");
			return true;
		} else {
			// System.out.println("Stack is not Empty");
			return false;
		}

	}

	/**
	 * Delete from the beginning
	 * 
	 * @return the element on top of stack. null if stack is empty
	 */
	public E pop() {
		E result = null;
		/**
		 * Check if the list is uninitialized
		 */
		if (top != null) {
			result = top.data;
			top = top.next;
		}
		return result;
	}

	public void printStack() {
		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}
		Node temp = top;
		System.out.print("TOP ->");
		while (temp != null) {
			System.out.println(temp.data);
			// The switching node using temp by following the next pointer is
			// absolutely crucial
			temp = temp.next;
		}
		System.out.println();
	}

	class Node {
		E data;
		Node next;
		
		/**
		 * Nodes of a linked list
		 *@param data The content of the Node.
		 */
		Node(E data) {
			// if we want to access the global "data" we need to use
			// "this.data". "this" refers to the current object and "this.data"
			// will mean the
			// member variable "data" present in the current object
			this.data = data;
		}
	}

}

class StackArray implements StackOperations {

	static final int MAX = 100;

	int arr[] = new int[MAX];
	int top;

	StackArray() {
		// top = -1;
		top = 0;
	}

	/**
	 * Implement overflow exception Client should call isFull
	 */
	public void push(int x) throws OverflowException {
		if (top < MAX) {
			arr[top] = x;
			top = top + 1;
		} else {
			throw new OverflowException("Stack is Full exception");
		}

	}

	public boolean isEmpty() {
		if (top <= 0) {
			// System.out.println("stack is empty");
			return true;
		}
		// System.out.println("Stack is NOT empty");
		else {
			return false;
		}
	}

	/**
	 * Implement underflow exception Client should call isEmpty before calling
	 * pop
	 */
	public int pop() throws UnderflowException {
		if (top == 0) {
			// System.out.println("empty");
			throw new UnderflowException("Stack is empty exception");
			// return 0;
		} else {
			top--;
			int data = arr[top];
			return data;

		}
	}

	public void printStack() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.print("Top->");

		for (int i = top - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}

	}

	@Override
	public int peek() throws UnderflowException {
		if (top == 0) {
			throw new UnderflowException("Stack is empty so cannot peek");
		} else {
			return arr[top - 1];
		}
	}
}

class OverflowException extends Exception {

	/**
	 *  This exception is thrown when the DS is full
	 * @param errorMessage error to be shown
	 */
	OverflowException(String errorMessage) {
		super(errorMessage);
	}
}

class UnderflowException extends Exception {

	/**
	 * This exception is thrown when the DS is empty
	 * @param errorMessage error to be shown
	 */
	UnderflowException(String errorMessage) {
		super(errorMessage);
	}
}