package JavaLearn;

import java.util.Stack;

public class TreeTraversalClient {
	public static void main(String[] args) {
		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		TreeTraversal obj = new TreeTraversal();
		System.out.println("Post order traversal");
		obj.postorderNoRecursion(binTree.root);
		System.out.println("\n\n");
		System.out.println("Isha preorder without recursion");
		obj.preorderTraversalNoRec(binTree.root);
		System.out.println("\n\n");
		System.out.println("Debraj preorder without recursion");
		obj.preorderNoRecursion(binTree.root);
		System.out.println("\n\n");
		System.out.println("Inorder without recursion");
		obj.inorderNoRecursion(binTree.root);
		System.out.println("\n\n");
		System.out.println("Inorder with recursion");
		obj.inorderRecursion(binTree.root);
	}
}

class TreeTraversal {
	
	public void inorderNoRecursion(TreeNode temp) {
		Stack<TreeNode> st = new Stack<>();
		st.push(temp);
		//Eq: all recursive calls have returned => stack is empty
		while (!st.isEmpty()) {
			// equivalent to inorder(temp.leftChild)
			while (temp != null) {
				//step 2: Go as far left as possible
				temp = temp.leftChild;
				//step 1: If left child is not present dont add it to stack. In recursion, this is equivalent to the null check immediately returning.
				if(temp != null) {
					st.push(temp);
				}
			}

			// step 3: Print the last successful not null left node (which is added in the stack).
			temp = st.pop();
			System.out.println(temp.data);

			//step 1
			while (temp.rightChild == null && !st.isEmpty()) {
				// !st.isEmpty() means pop until we reach the root node. If we have popped the root node we will not pop anymore elements
				temp = st.pop();
				System.out.println(temp.data);
			}

			if(temp.rightChild != null) {
				//step 4: If we have a right child until the root node, we can still traverse the tree. Call with the right child (i.e. add rightChild to the stack)
				temp = temp.rightChild;
				st.push(temp);
			}
		}
	}
	
	public void preorderTraversalNoRec(TreeNode temp) {
		Stack<TreeNode> st = new Stack<>();
		//TreeNode temp1;
		if(temp ==null) {
			System.out.println("Tree is empty");
		}
		st.push(temp);	
		while(!st.isEmpty()) {
			if(temp != null)
			 temp = st.pop();
			System.out.print(" "+temp.data);
			
			if(temp.rightChild != null) {
				st.push(temp.rightChild);
			}
			if(temp.leftChild != null) {
				st.push(temp.leftChild);
			}
		}
	}
	
	public void preorderNoRecursion(TreeNode temp) {
		// print the node before pushing to stack
		Stack<TreeNode> st = new Stack<>();
		System.out.println(temp.data);
		st.push(temp);
		//Eq: all recursive calls have returned => stack is empty
		while (!st.isEmpty()) {
			while (temp != null) {
				temp = temp.leftChild;
				if(temp != null) {
					System.out.println(temp.data);
					st.push(temp);
				}
			}

			// step 3: 
			temp = st.pop();

			//step 1
			while (temp.rightChild == null && !st.isEmpty()) {
				// !st.isEmpty() means pop until we reach the root node. If we have popped the root node we will not pop anymore elements
				temp = st.pop();
			}

			if(temp.rightChild != null) {
				//step 4: If we have a right child until the root node, we can still traverse the tree. Call with the right child (i.e. add rightChild to the stack)
				temp = temp.rightChild;
				System.out.println(temp.data);
				st.push(temp);
			}
		}
	}
	/**
	 * 
	 * Same algorithm as preorder, except for the change:
	 * <1> Instead of print, add it to an auxiliary stack
	 * <2> change all leftChild to rightChild and vice versa
	 * 
	 * Why it works?
	 *       3
	 *      / \
	 *     6   4
	 *    /\   /\
	 *   1  2  7 8
	 *   
	 *   Consider the above tree. We add the root to stack and then add all right childs. Stack : 3, 4, 8
	 *   We then add left child in bottom up manner (by popping elements). Stack : 3, 4, 8, 7
	 *   We then repeat this. So we add 6 and then all the elements to its right. 3, 4, 8, 7, 6, 2
	 *   Finally we add the left child of 6 in bottom up manner. 3, 4, 8, 7, 6, 2, 1
	 *   
	 *   When we print this stack, the result is a post order traversal: 1, 2, 6, 7, 8, 4, 3
	 *   
	 *   Alternate solution here:
	 *   
	 *   https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 *   
	 */
	public void postorderNoRecursion(TreeNode temp) {
		// print the node before pushing to stack
		Stack<TreeNode> st = new Stack<>();
		Stack<Integer> aux = new Stack<>();
		aux.push(temp.data);
		st.push(temp);
		
		while (!st.isEmpty()) {
			// add all right children
			while (temp != null) {
				temp = temp.rightChild;
				if(temp != null) {
					aux.push(temp.data);
					st.push(temp);
				}
			}

			temp = st.pop();

			// find if an element in the stack has a left child. (popping elements mean we are going up the tree)
			while (temp.leftChild == null && !st.isEmpty()) {
				// !st.isEmpty() means pop until we reach the root node. If we have popped the root node we will not pop anymore elements
				temp = st.pop();
			}

			if(temp.leftChild != null) {
				//step 4: If we have a left child. We need to add this to the aux array. We will also have to add its children so we set temp to the left child
				temp = temp.leftChild;
				aux.push(temp.data);
				st.push(temp);
			}
		}
		while(!aux.isEmpty()) {
			System.out.println(aux.pop());
		}
	}
	
	
	public void inorderRecursion(TreeNode temp) {
		/**
		 * Step 1 : Null check
		 */
		if(temp == null) {
			return;
		}
		/**
		 * Step 2 : Go left as much as possible
		 */
		inorderRecursion(temp.leftChild);
		/**
		 * Step 3: Print
		 */
		System.out.println(temp.data);
		/**
		 * Step 4: Go right and then go left again
		 */
		inorderRecursion(temp.rightChild);
	}

}
