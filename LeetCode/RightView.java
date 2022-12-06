package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	/**
	 *     1
	 *   /   \
	 *   2    3
	 *       / \
	 *      4   8
	 *        \
	 *         5
	 *        / \
	 *        6  7   
	 */
	private static TreeNode createTree() {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.right.left = new TreeNode(4);
		t.right.left.right = new TreeNode(5);
		t.right.left.right.left = new TreeNode(6);
		t.right.left.right.right = new TreeNode(7);
		t.right.right = new TreeNode(8);
		return t;
	}
	
	/**
	 * We will traverse the tree in level order fashion.
	 * How?
	 * Note the Queue at any instant will contain nodes from the current level and nodes from the next level.
	 * Assume we have processed the current level completely, and now going to start processing the next level.
	 * In this situation the queue only has nodes from the next level.
	 * If we calculate q.size() = S it will give us all nodes in the next level.
	 * Now if we process only S nodes. Then we are again left with nodes in the next level.
	 * Doing this repeatedly will ensure level order traversal.
	 * 
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> output = new ArrayList<>();
		if(root == null) {
			return output;
		}
		q.offer(root);
		while(!q.isEmpty()) {
			// process a single level
			int levelSize = q.size();
			int rightMostValue = 0;
			for(int i=0; i<levelSize; i++) {
				TreeNode node = q.poll();
				if(node.left != null) {
					q.offer(node.left);
				}
				if(node.right != null) {
					q.offer(node.right);
				}
				rightMostValue = node.val;
			}
			output.add(rightMostValue);
		}
		return output;
        
    }
	
	public static void main(String[]args) {
		TreeNode root = createTree();
		List<Integer> output = rightSideView(root);
		for(int i: output) {
			System.out.println(i);
		}
	}
}
