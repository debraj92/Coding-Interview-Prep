package JavaLearn;

import java.util.LinkedList;
import java.util.Queue;


// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

public class SumBinaryTree {

	public static void main(String[] args) {
		CreateSumTree binTree1 = new CreateSumTree();
		binTree1.createTree1();
		
		SumTree sumt = new SumTree();
		int sum = sumt.IsSumTree(binTree1.root);
		if(sum == 1)
		System.out.println("the given tree is sum tree" );
		else 
			System.out.println("the given tree is NOT sum tree" );
	}
}

class CreateSumTree{
	public TreeNode root;
/**
 *                26
 *              /    \
 *             10      3
 *           /    \      \
 *          4     6       3
 */
public void createTree1() {
	root = new TreeNode(26);
	root.leftChild = new TreeNode(10);
	root.leftChild.leftChild = new TreeNode(4);
	root.leftChild.rightChild = new TreeNode(6);
	root.leftChild.rightChild.leftChild = new TreeNode(15);

	root.rightChild = new TreeNode(3);
	root.rightChild.rightChild = new TreeNode(3);
	//root.rightChild.leftChild.rightChild = new TreeNode(2);
	//root.rightChild.rightChild = new TreeNode(25); 
}
}

class SumTree {
	
	public int sumTree(TreeNode temp) {
		if(temp == null)
			return 0;
		else
			return sumTree(temp.leftChild) + temp.data + sumTree(temp.rightChild);
	}
	

	public int IsSumTree(TreeNode temp) {
		if (temp == null || temp.leftChild == null && temp.rightChild == null) 
			return 1;
		
			int left = sumTree(temp.leftChild);
			int right = sumTree(temp.rightChild);

			if (temp.data == (left + right) && (IsSumTree(temp.leftChild)!=0) && (IsSumTree(temp.rightChild)!=0)) 
				return 1;
			
		return 0;
	}
}
