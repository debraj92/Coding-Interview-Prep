package Practice;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/submissions/
public class PathToLeaf {
	
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
	
	private static void binaryTreePathsInternal(TreeNode root, String path, List<String> output) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
        	path = (path.isEmpty()? path : path + "->") + root.val;
        	output.add(path);
        	return;
        }
        
        binaryTreePathsInternal(root.left, (path.isEmpty()? path : path + "->") + root.val, output);
        binaryTreePathsInternal(root.right, (path.isEmpty()? path : path + "->") + root.val, output);
    }
	
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        binaryTreePathsInternal(root, "", output);
        return output;
    }
	
	/**
	 *      1
	 *    /   \
	 *   2     3
	 *    \   / \
	 *     4  5  6  
	 */
	private static TreeNode createTree() {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right.left = new TreeNode(5);
		t.right.right = new TreeNode(6);
		return t;
	}
	
	public static void main(String[]args) {
		TreeNode root = createTree();
		List<String> output = binaryTreePaths(root);
		for(String s: output) {
			System.out.println(s);
		}
	}
}
