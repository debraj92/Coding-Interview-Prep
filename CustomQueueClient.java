public class CustomQueueClient {
	public static void main(String[] args) {
		//queueOperationsWithList();
		//testQueueEmpty();
		//testPrintQueueEmpty();
		//testcaseforString();
		queueWithArray();
	}
	
	/**
	 * method to run test cases for string data type
	 */
	public static void testcaseforString() {
		QueueList<String> queuelist = new QueueList<>();
		queuelist.enQueue("Isha");
		queuelist.enQueue("loves");
		queuelist.enQueue("deb");
		queuelist.printQueue();
		queuelist.deQueue();
		queuelist.printQueue();
	}
	
	/**
	 * method to perform general queue operations
	 */
	public static void queueOperationsWithList() {
		QueueList<Integer> queuelist = new QueueList<>();
		queuelist.enQueue(10);
		queuelist.enQueue(20);
		queuelist.enQueue(30);
		queuelist.printQueue();
		System.out.println("Dequed element:" +queuelist.deQueue());
		System.out.println("Front element is "+queuelist.getFront());
		System.out.println("Rear element is "+queuelist.getRear());
		System.out.println("Is Queue empty ? "+queuelist.isEmpty());
		queuelist.printQueue();
	}
	
	/**
	 * method to run test case when queue is empty
	 */
	public static void testQueueEmpty() {
		QueueList<Integer> queuelist = new QueueList<>();
		queuelist.deQueue();
	}
	
	public static void testPrintQueueEmpty() {
		QueueList<Integer> queuelist = new QueueList<>();
		queuelist.printQueue();
		queuelist .enQueue(5);
		queuelist .printQueue();
		System.out.println("Dequed: "+queuelist.deQueue());
		queuelist .printQueue();
	}
	
	public static void queueWithArray() {
		QueueArray q = new QueueArray();
		try {
			q.enQueue(1);
			q.enQueue(2);
			q.enQueue(3);
			q.enQueue(4);
			q.enQueue(5);
		} catch (OverflowException e) {
			System.out.println("error: " + e.getMessage());
		}
		q.printQueue();
		try {
			q.deQueue();
			q.deQueue();
			q.enQueue(6);
			q.enQueue(7);
		} catch (UnderflowException e) {
			System.out.println("error: " + e.getMessage());
		} catch (OverflowException e) {
			System.out.println("error: " + e.getMessage());
		}
		q.printQueue();
		try {
			System.out.println("Front:"+q.getFront());
			System.out.println("Rear:"+q.getRear());
			while(!q.isEmpty()) {
				
				q.deQueue();
			}
			q.printQueue();
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

class QueueArray {
	//Actual size of the Queue is one less than SIZE. We need a boundary element
	static final int SIZE = 5;
	int arr[] = new int[SIZE];
	int front = 0;
	int rear = 0;

	/**
	 * Removes an element from the front of the queue
	 * 
	 * @return removed element
	 * @throws UnderflowException
	 *             if no element is present
	 */
	public int deQueue() throws UnderflowException {
		if (front == rear) {
			throw new UnderflowException("array is empty");
		} else {
			int deletedElement = arr[front];
			front = (front + 1) % (SIZE);
			System.out.println("Dequed element: "+deletedElement);
			return deletedElement;
		}
	}

	/**
	 * Add an element at the rear of the queue
	 * 
	 * @param data
	 *            to be added to queue
	 * @throws OverflowException
	 *             when queue is already full
	 */
	public void enQueue(int data) throws OverflowException {
		if ((rear + 1) % SIZE == front) {
			throw new OverflowException("Queue is full");
		} else {
			arr[rear] = data;
			System.out.println("enQueue: "+data);
			rear = (rear + 1) % (SIZE);
		}
	}

	/**
	 * prints the elements of the queue
	 */
	public void printQueue() {
		System.out.println("printQueue");
		if (front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		int i = front;
		System.out.print("Front ->");
		while (i != rear) {
			if((i+1)%SIZE == rear) {
				System.out.print("Rear ->" + arr[i]);
			} else {
				System.out.println(arr[i]);
			}
			i = (i + 1) % SIZE;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public int getFront() throws UnderflowException {
		if (front == rear) {
			throw new UnderflowException("Queue is empty so no data at front");
		} else {
			return arr[front];
		}
	}

	public int getRear() throws UnderflowException {
		if (front == rear) {
			throw new UnderflowException("Queue is empty so no data at rear");
		} else if (rear == 0) {
			return arr[SIZE - 1];
		} else {
			return arr[rear - 1];
		}
	}
}

















class QueueList<E> {
	Node rear = null;
	Node front = null;

	/**
	 * enQ will add elements at the rear of the list
	 * @param x element to be added
	 */
	public void enQueue(E x) {
		System.out.println("enQueue "+x);
		Node node = new Node(x);
		if (rear == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = rear.next;
		}
	}

	/**
	 * 
	 * @return the front element. Null if empty
	 */
	public E deQueue() {
		Node result;
		if (front == null) {
			return null;
		} else if (front == rear) {
			result = front;
			front = null;
			rear = null;
			return result.data;
		} else {
			result = front;
			front = front.next;
			return result.data;
		}
	}
	
    /**
     * prints the elements of the queue
     */
	public void printQueue() {
		System.out.println("printQueue");
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		Node temp = front;
		System.out.print("Front ->");
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.print("Rear ->"+temp.data);
		System.out.println();
	}
	/**
	 * Checks if the list is empty or not
	 * @return true if empty
	 */
	public boolean isEmpty() {
		if(front==null){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return the data at front, if queue empty then return null
	 */
	public E getFront() {
		if(front==null){
			return null;
		}
		return front.data;
	}
	
	/**
	 * 
	 * @return the data at rear, if queue empty then return null
	 */
	public E getRear() {
		if(rear==null){
			return null;
		}
		return rear.data;
	}
	
	class Node {
		E data;
		Node next;
		
		/**
		 * Nodes of a Queue list
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