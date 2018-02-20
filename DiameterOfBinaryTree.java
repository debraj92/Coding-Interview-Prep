package JavaLearn;

public class DiameterOfBinaryTree {
public static void main(String[] args) {
	MyBinTree binTree = new MyBinTree();
	binTree.createTree();
	
	DiameterOfTree dia= new DiameterOfTree();
	int height = dia.maxDepth(binTree.root);
	System.out.println("Height of the tree is "+height);
	
	int diameter = dia.findDiameter(binTree.root);
	System.out.println("Diameter of the tree is "+diameter);
}
}

class DiameterOfTree{
	
	public int findDiameter(TreeNode temp) {
		if(temp == null) {
			return 0;
		}
		
		else {
			int left1 = maxDepth(temp.leftChild);
			int right1 = maxDepth(temp.rightChild);
			
			int left2 = findDiameter(temp.leftChild);
			int right2 = findDiameter(temp.rightChild);
			
			return Math.max(left1 + right1 + 1, Math.max(left2,right2));
		}
	}
	
	
	
	public int maxDepth(TreeNode temp){
		if(temp == null) {
			return 0;
		} else if(temp.leftChild == null && temp.rightChild == null) {
			return 1;
		}
		else {
			int leftLen = 1+ maxDepth(temp.leftChild);
			int rightLen =1+ maxDepth(temp.rightChild);
			return Math.max(leftLen, rightLen);
		}
	}
}