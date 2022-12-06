package Practice;

// https://www.techiedelight.com/determine-nodes-lie-same-path-binary-tree/
public class BinTreeSamePath {

	static class TreeNode {
		
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int d) {
			data = d;
		}
	}
	
	/**
	 * Keep searching for both t1 and t2. If t1 is found, look for t2 and vice versa.
	 * First look in the left subtree, if not found look in the right subtree
	 */
	public static boolean isSamePath (BinTreeSamePath.TreeNode root, 
			BinTreeSamePath.TreeNode t1, BinTreeSamePath.TreeNode t2, 
			boolean isT1Found, boolean isT2Found) {
		
		
		if (root == null) {
			return false;
		}
		
		if ((!isT1Found) && (root == t1)) {
			// if t2 is already found and we just now found t1 then both on the same path
			if(isT2Found) {
				return true;
			}
			// look for t2 in descendants
			return isSamePath(root.left, t1, t2, true, false) || isSamePath(root.right, t1, t2, true, false);
			
		} else if ((!isT2Found) && (root == t2)) {
			// if t1 is already found and we just now found t2 then both on the same path
			if(isT1Found) {
				return true;
			}
			// look for t1 in descendants
			return isSamePath(root.left, t1, t2, false, true) || isSamePath(root.right, t1, t2, false, true);
			
		}
		
		// look for both
		return isSamePath(root.left, t1, t2, isT1Found, isT2Found) || isSamePath(root.right, t1, t2, isT1Found, isT2Found);
	}
	
	/**
	 *                  1
	 *               /    \
	 *              2      3
	 *             /\     / \
	 *            4  5   6   7
	 *           /\   \     /
	 *          8  9   10  11
	 *                  
	 *           
	 *            
	 *            
	 *            
	 *            
	 */
	
	public static BinTreeSamePath.TreeNode createTree() {
		BinTreeSamePath.TreeNode root = new BinTreeSamePath.TreeNode(1);
		root.left = new BinTreeSamePath.TreeNode(2);
		root.right = new BinTreeSamePath.TreeNode(3);
		root.left.left = new BinTreeSamePath.TreeNode(4);
		root.left.right = new BinTreeSamePath.TreeNode(5);
		root.left.left.left = new BinTreeSamePath.TreeNode(8);
		root.left.left.right = new BinTreeSamePath.TreeNode(9);
		root.left.right.right = new BinTreeSamePath.TreeNode(10);
		root.right.left = new BinTreeSamePath.TreeNode(6);
		root.right.right = new BinTreeSamePath.TreeNode(7);
		root.right.right.left = new BinTreeSamePath.TreeNode(11);
		return root;
		
	}
	
	public static void main(String[]args) {
		/**
		 * check 2 and 8
		 */
		BinTreeSamePath.TreeNode root = createTree();
		BinTreeSamePath.TreeNode t1 = root.left;
		BinTreeSamePath.TreeNode t2 = root.left.left.left;
		System.out.println("Checking for "+t1.data+" and "+t2.data);
		System.out.println(isSamePath(root, t1, t2, false, false));
		
		/**
		 * check 4 and 10
		 */
		t1 = root.left.left;
		t2 = root.left.right.right;
		System.out.println("Checking for "+t1.data+" and "+t2.data);
		System.out.println(isSamePath(root, t1, t2, false, false));
		
		/**
		 * check 4 and 6
		 */
		t1 = root.left.left;
		t2 = root.right.left;
		System.out.println("Checking for "+t1.data+" and "+t2.data);
		System.out.println(isSamePath(root, t1, t2, false, false));
		
		/**
		 * check 3 and 11
		 */
		t1 = root.right;
		t2 = root.right.right.left;
		System.out.println("Checking for "+t1.data+" and "+t2.data);
		System.out.println(isSamePath(root, t1, t2, false, false));
	}
}
