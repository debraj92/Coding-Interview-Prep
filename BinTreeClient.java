package JavaLearn;

public class BinTreeClient {
	public static void main(String[]args) {
		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		//binTree.printInorder();
		//binTree.printPreorder();
		System.out.println("Minimum is: "+binTree.findMinimum());
		System.out.println("Is Present 3?" +binTree.SearchElement(3));
		System.out.println("Is Present 2?" +binTree.SearchElement(2));
		System.out.println("Is Present 11?" +binTree.SearchElement(11));
		System.out.println("Height of tree "+binTree.findHeight());
		System.out.println("No. of Leaves in tree :"+binTree.countOfLeaves());
	}
}

class MyBinTree{
	private TreeNode root;
	
	/**
	 * 							13
	 * 						  /		 \
	 * 					18		12
	 * 				  /		\		/	\
	 * 				19	3 	  22   25
	 * 					  /  \     \
	 * 				   15   7    2
	 */
	
	public void createTree() {
		root = new TreeNode(13);
		root.leftChild = new TreeNode(18);
		root.leftChild.leftChild = new TreeNode(19);
		root.leftChild.rightChild = new TreeNode(3);
		root.leftChild.rightChild.leftChild = new TreeNode(15);
		root.leftChild.rightChild.rightChild = new TreeNode(7);
		root.rightChild = new TreeNode(12);
		root.rightChild.leftChild = new TreeNode(22);
		root.rightChild.leftChild.rightChild = new TreeNode(2);
		root.rightChild.rightChild = new TreeNode(25); 
	}
	
	public void printInorder() {
		printInorderInternal(root);
	}
	
	private void printInorderInternal(TreeNode temp) {
		if(temp == null) {
			return;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			System.out.println(temp.data);
		} else {
			printInorderInternal(temp.leftChild);
			System.out.println(temp.data);
			printInorderInternal(temp.rightChild);
		}
	}
	
	/**
	 * Print in preorder fashion
	 */
	public void printPreorder() {
		printPreorderInternal(root);
		
	}
		private void printPreorderInternal(TreeNode temp){
			if(temp == null) {
				return;
			} else if (temp.leftChild == null && temp.rightChild == null) {
				System.out.println(temp.data);
			} else {
				System.out.println(temp.data);
				printPreorderInternal(temp.leftChild);
				printPreorderInternal(temp.rightChild);
			}
		}
		
	
	/**
	 * Find the minimum element
	 * @return minimum element in the tree
	 */
	public int findMinimum() {
		int minimum = findMinimumInternal(root);
		return minimum;
	}
	
	private int findMinimumInternal(TreeNode temp) {
		int min =0;
		if(temp == null) {
			min = 1000;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			min = temp.data;
		} else {
			int minLeft = findMinimumInternal(temp.leftChild);
			int minRight = findMinimumInternal(temp.rightChild);
			min = temp.data;
			if(min>minLeft) {
				min = minLeft;
			}
			if(min>minRight) {
				min = minRight;
			}	
		}	
		return min;
	}
	
	/**
	 * Search an element in the tree
	 * @return true if search is successful
	 */
	public boolean SearchElement(int element) {
		return SearchElementInternal(root, element);
	}
	
	private boolean SearchElementInternal(TreeNode temp, int element) {
		if(temp == null) {
			return false;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			return temp.data == element;
		} else {
			boolean isPresentInLeftChild = SearchElementInternal(temp.leftChild,element);
			boolean isPresentInRightChild = SearchElementInternal(temp.rightChild,element);
			return isPresentInLeftChild || isPresentInRightChild || temp.data == element;	
		}
	}
	
	public int findHeight() {
		return findHeightInternal(root);
	}
	
	private int findHeightInternal(TreeNode temp) {
		if(temp == null) {
			return 0;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			return 1;
		} else {
			return 1 + Math.max(findHeightInternal(temp.leftChild), findHeightInternal(temp.rightChild));
		}
	}
	
	public int countOfLeaves() {
		return countOfLeavesInternal(root);
	}
	
	private int countOfLeavesInternal(TreeNode temp) {
		if (temp == null) {
			return 0;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			return 1;
		} else {
			int nl = countOfLeavesInternal(temp.leftChild);
			int nr = countOfLeavesInternal(temp.rightChild);
			return nl + nr;
		}
	}
}
class TreeNode{
	TreeNode leftChild;
	TreeNode rightChild;
	int data;
	TreeNode(int data) {
		this.data = data;
	}
}