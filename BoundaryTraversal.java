package JavaLearn;

public class BoundaryTraversal {
	public static void main(String[] args) {
	MyBinTree binTree = new MyBinTree();
	binTree.createTree();
     
	BoundaryTreeTraversal pb = new BoundaryTreeTraversal();
	pb.printBoundaryMethodCaller(binTree.root);
	}
	
		
}

class BoundaryTreeTraversal{
	
	public void printBoundaryMethodCaller(TreeNode temp){

		
		printLeftBoundary(temp);
		printLeaves(temp);
		printRightBoundaryInReverse(temp.rightChild);
		}
	
	public void printLeftBoundary(TreeNode temp) {
		
		if(temp == null) {
			System.out.println("Tree is empty");
		}
		else {
			while (temp.leftChild != null) {
				System.out.print(" "+temp.data);
				temp = temp.leftChild;
			}
		}	
	}
	
	public void printLeaves(TreeNode temp) {
		if(temp == null) {
			System.out.print("");
		}
		else if(temp.leftChild == null && temp.rightChild == null) {
			System.out.print(" "+ temp.data);
		}
		else {
			printLeaves(temp.leftChild);
			printLeaves(temp.rightChild);
		}
	}
	
	public void printRightBoundaryInReverse(TreeNode temp) {
		if(temp == null) {
			System.out.println(" I am null");
		} else if(temp.leftChild == null & temp.rightChild == null) {
			// we don't have to print the right boundary root as it is already printed during the leaves
			// traversal.
			System.out.print("");
		} else {
			printRightBoundaryInReverse(temp.rightChild);
			System.out.print(" "+temp.data);
		}
	}
	
}