package JavaLearn.GeekForGeeks_Solution;

public class MirrorTree {
	public static void main(String[]args) {
		MirrorBinTree mbt = new MirrorBinTree();
		mbt.createTrees();
		mbt.checkIfTreesMirror();
	}
}


class MirrorBinTree {
	
	public void checkIfTreesMirror() {
		System.out.println("Are the trees Mirror? "+isMirror(root1,root2));
	}
	
	
	private boolean isMirror(CharNode root1, CharNode root2) {
		
		// both null = mirror
		if(root1==null && root2==null) {
			return true;
		}
		
		// only one null = Not mirror
		if(root1==null || root2==null) {
			return false;
		}
		
		/**
		 * The current trees are Mirror if each others data match and the left subtree of one is equal to the right subtree of other and 
		 * vice versa
		 */
		return root1.d == root2.d 
				&& isMirror(root1.left, root2.right) 
				&& isMirror(root1.right, root2.left);
		
	}
	
	
	
	
	
	CharNode root1, root2;
	
	/**
	 *   Tree1                      mirror            Tree 2
	 *              a                 |                 a
	 *             /  \               |                /  \
	 *            b    c              |               c    b
	 *           / \    \             |              /    / \
	 *          d   e    f            |             f    e   d
	 *               \                |                 /
	 *                g               |                g
	 *                
	 *    
	 *               
	 */
	public void createTrees() {
		// create tree1
		
		root1 = new CharNode('a');
		root1.left = new CharNode('b');
		root1.right = new CharNode('c');
		root1.left.left = new CharNode('d');
		root1.left.right = new CharNode('e');
		root1.right.right = new CharNode('f');
		root1.left.right.right = new CharNode('g');
		
		root2 = new CharNode('a');
		root2.right = new CharNode('b');
		root2.left = new CharNode('c');
		root2.right.right = new CharNode('d');
		root2.right.left = new CharNode('e');
		root2.left.left = new CharNode('f');
		root2.right.left.left = new CharNode('g');
	}
	
	public void printTreeInorder(int treeNumber) {
		switch(treeNumber) {
		case 1:
			printTreeInorderInternal(root1);
			break;
		case 2:
			printTreeInorderInternal(root2);
			break;
		}
	}
	
	public void printTreeInorderInternal(CharNode temp) {
		if(temp == null) {
			return;
		}
		printTreeInorderInternal(temp.left);
		System.out.println(temp.d);
		printTreeInorderInternal(temp.right);
	}
}
