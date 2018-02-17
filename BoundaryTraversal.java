package JavaLearn;

import java.util.LinkedList;
import java.util.Queue;

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
			while(temp.leftChild != null & temp.rightChild != null) {
				System.out.print(" "+temp.data);
				temp = temp.leftChild;
			}
		}	
	}
	
	public void printLeaves(TreeNode temp) {
		if(temp == null) {
			System.out.print("");
		}
		else if(temp.leftChild == null & temp.rightChild == null) {
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
			System.out.print(" ");
		} else {
			printRightBoundaryInReverse(temp.rightChild);
			System.out.print(" "+temp.data);
		}
	}
	
	
	/*public void printRightBoundaryInReverse(TreeNode temp) {
		if(temp == null) {
			System.out.println();
		} else {
			Queue<TreeNode> q = new LinkedList<>();
			while(temp.leftChild != null & temp.rightChild != null) {
				q.add(temp);
				temp = temp.rightChild;
			}
			while(!q.isEmpty()) {
				TreeNode temp1 = q.remove();
				System.out.print(" "+ temp1.data);
			}
		}
	} */
	
	
	
	
}