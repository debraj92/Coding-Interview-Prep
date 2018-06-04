package JavaLearn;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidhtOfBinaryTree {

	public static void main(String[] args) {
		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		
		MaxWidth wid = new MaxWidth();
		System.out.println("Max width of the tree is "+wid.findMaxWidth(binTree.root));
	}
}

class MaxWidth{	
	int width = 0;
	public int findMaxWidth(TreeNode temp) {
		Queue<TreeNode> q = new LinkedList<>();
		if(temp == null) {
			return 0;
		}
		
		/**
		 * Logic: The q will contain a single level each time. So, size of q will tell the width of the tree.
		 */
		q.add(temp);
		// level order traversal
		while(!q.isEmpty()) {
		 
			int size = q.size();	
			//keeping the width updated with the largest width seen in any level
			width = Math.max(size, width);
			// size contain the number of elements in the level currently in the q
			while(size -- > 0) {
				//remove the current level and enqueue the next level
				TreeNode temp1 =q.remove();
				if(temp1.leftChild != null)
				q.add(temp1.leftChild);
				if(temp1.rightChild!= null)
				q.add(temp1.rightChild);
			}
			
		}
		return width;
	
	}
}