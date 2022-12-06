package JavaLearn;

import JavaLearn.MyBinTree;

public class MaxPathSumBinTree {
	
	public static void main(String[]args) {
		MaxPathBinTree ob = new MaxPathBinTree();
		ob.createTree();
		System.out.println(ob.getMaxPathSum());
		// output = 171
		// Max path - 5, 43, 15, 3, 18, 13, 12, 25, 6, 31
	}
}


class MaxPathBinTree extends MyBinTree {
	
	private int max_sum = 0;
	public int getMaxPathSum() {
		computeMaxPathSum(root);
		return max_sum;
	}
	
	/**
	 * This will work only if the tree contains only positive nodes. If the tree contains negative nodes then 
	 * we have to add an additional condition that the path starts from a leaf and end in a leaf despite the sum 
	 * path may be less than maximum (especially if the leaves contain negative values)
	 */
	// returns the maximum sum starting from root to any of the leaves
	private int computeMaxPathSum(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int maxLeftPathSum = computeMaxPathSum(root.leftChild);
		int maxRightPathSum = computeMaxPathSum(root.rightChild);
		
		// update the max_sum if needed
		max_sum = Math.max( maxLeftPathSum + maxRightPathSum + root.data, max_sum);
		
		// return the max sum from this node to the leaves on the left side or right side
		return root.data + Math.max(maxLeftPathSum, maxRightPathSum);
	}
}