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
		
		q.add(temp);
		while(!q.isEmpty()) {
		 
			int size = q.size();		
			width = Math.max(size, width);
			
			while(size -- > 0) {
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