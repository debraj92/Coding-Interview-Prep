package JavaLearn;

public class IsHeightBalanaced {
	public static void main(String[] args){
		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		
		IsHeightBalancedTree hb = new IsHeightBalancedTree();
		boolean result = hb.findifbalanced(binTree.root);
		System.out.println("Is Tree is Balanced ?? " +result);
	}

}
// Better Solution: https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
class IsHeightBalancedTree{
	public boolean findifbalanced(TreeNode temp) {
		if(temp == null) {
			return true;
		}
		else if(temp.leftChild == null && temp.rightChild == null) {
			return true;
		}
		else {
			int leftDepth = findDepthRec(temp.leftChild);
			int rightDepth = findDepthRec(temp.rightChild);
			
			if(Math.abs(leftDepth - rightDepth) > 1) {
				// Math.abs finds the absolute value or mod
				return false;
			} else {
				boolean leftResult = findifbalanced(temp.leftChild);
				boolean rightResult = findifbalanced(temp.rightChild);
				
				if(leftResult && rightResult) {
					// both subtrees are balanced and so current node is balanced
					return true;
				} else {
					// at least one of the subtrees is not balanced
					return false;
				}
				
			}
		}
		
		
	}
	// finding height
	public int findDepthRec(TreeNode temp) {
		if (temp == null) {
			return 0;
		} else if (temp.leftChild == null && temp.rightChild == null) {
			return 1;
		} else {
			int leftLen = 1 + findDepthRec(temp.leftChild);
			int rightLen = 1 + findDepthRec(temp.rightChild);
			return Math.max(leftLen, rightLen);
		}
		
	}
	
}
