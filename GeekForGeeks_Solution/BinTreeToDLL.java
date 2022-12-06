package JavaLearn.GeekForGeeks_Solution;


public class BinTreeToDLL {
	
	static BinTree b = new BinTree();
	
	public static void main(String[]args) {
		
		b.createTree();
		//b.inorderRecursion(b.root);
		b.convertToDLL();
	}


	
static class BinTree {
	CharNode root;
	
	/**
	 *      a
	 *     /  \
	 *    b     c
	 *   / \   /
	 *  d   e f  
	 */
	public void createTree() {
		root = new CharNode('a');
		root.left = new CharNode('b');
		root.right = new CharNode('c');
		root.left.left = new CharNode('d');
		root.left.right = new CharNode('e');
		root.right.left = new CharNode('f');
	}
	
	public void inorderRecursion(CharNode temp) {
		if(temp == null) {
			return;
		}
		inorderRecursion(temp.left);
		System.out.println(temp.d);
		inorderRecursion(temp.right);
	}
	
	
	public void convertToDLL() {
		// convert to DLL
		_convertToDLL(root);
		
		// Print the DLL traversing forward
		CharNode t = head;
		CharNode tail = null;
		while(t!=null) {
			System.out.println(t.d);
			tail = t;
			t = t.right;
		}
		System.out.println();
		// Print the DLL traversing backward
		while(tail != null) {
			System.out.println(tail.d);
			tail = tail.left;
		}
	}
	
	CharNode prev;
	CharNode head;
	
	/**
	 * To convert to DLL we will keep track of the last visited node using prev while doing in order traversal.
	 * The final output would be :    d=b=e=a=f=c
	 */
	private void _convertToDLL(CharNode temp) {
		if(temp == null) return;
		
		_convertToDLL(temp.left);
		// if prev is not null set up the links.
		if(prev != null) {
			prev.right = temp;
			temp.left = prev;
		} else {
			// we set the head of the DLL when for the first time prev is getting set.
			head = temp;
		}
		prev=temp;
		_convertToDLL(temp.right);
	}
}
	
}

class CharNode {
	char d;
	CharNode left;
	CharNode right;
	CharNode(char d) {
		this.d = d;
	}
}
