package JavaLearn;


//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class IfBinarySearchTree {
     public static void main(String[] args) {

 		MyBinTree binTree = new MyBinTree();
 		binTree.createTree();
 		
 		IsBST isBST = new IsBST();
 		System.out.println( " Is the given tree Binary search Tree? "+isBST.BSTUtil(binTree.root));
     }
}

class IsBST{
	
	public boolean BSTUtil(TreeNode temp) {
		// here MIN_VALUE will have lowest -ve integer value and MAX_VALUE will have largest +ve integer value
		return FindIfBST(temp, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean FindIfBST(TreeNode temp, int min, int max) {
		if(temp == null) {
			System.out.println("Tree is empty");
			return true;
		}
		else if(temp.data < min || temp.data > max) {
			return false;
		}
		else {
			
		return	(FindIfBST(temp.leftChild, min, temp.data - 1) &&   FindIfBST(temp.rightChild, temp.data +1, max));
		
		}
	}
}
