package JavaLearn;

/**
 * 
 *          a
 *       /     \
 *      b       c
 *     / \     / \
 *    d   e   f   h
 *             \
 *              g
 *   
 *   In order : d b e a f g c h
 *   Threads connect nodes to in order successor
 *   d->b  e->a  g->c
 *   
 *   Notice only nodes that don't have a right child uses the right link to point to the in order successor.
 *   Also note threads always connect lower level nodes to higher level. Hence no higher level node would ever connect to a leaf
 *   node.
 *   
 *
 */

public class ThreadedBinTree {
	public static void main(String[]args) {
		ThreadBinTree threadT = new ThreadBinTree();
		threadT.createTree();
		// geeksforgeeks version
		//threadT.createTree2();
		threadT.printInorderRegular();
		threadT.convertToThreadedTree();
		System.out.println("Verify if Links are created correctly");
		System.out.println("e->"+threadT.root.leftChild.rightChild.rightChild.data2);
		System.out.println("g->"+threadT.root.rightChild.leftChild.rightChild.rightChild.data2);
		System.out.println("d->"+threadT.root.leftChild.leftChild.rightChild.data2);
		
		// verify geeksforgeeks version
		//System.out.println(threadT.root.leftChild.leftChild.rightChild.data + "  " +threadT.root.leftChild.rightChild.rightChild.data
		//		 + "   " + threadT.root.rightChild.leftChild.rightChild.data +"   "+ threadT.root.rightChild.rightChild.leftChild.rightChild.data);
	}
}

class  ThreadBinTree {

	TreeNode root;
	
	public void createTree() {
		root = new TreeNode('a');
		root.leftChild = new TreeNode('b');
		root.rightChild = new TreeNode('c');
		root.leftChild.leftChild = new TreeNode('d');
		root.leftChild.rightChild = new TreeNode('e');
		root.rightChild.leftChild = new TreeNode('f');
		root.rightChild.rightChild = new TreeNode('h');
		root.rightChild.leftChild.rightChild = new TreeNode('g');
	}
	
	/**
    *   (GEEKSFORGEEKS version)
    *         6
    *        / \
    *       3    8
    *      / \  / \
    *     1  5  7  11
    *              / \
    *             9   13 
	 */
	public void createTree2() {
		root = new TreeNode(6);
		root.leftChild = new TreeNode(3);
		root.rightChild = new TreeNode(8);
		root.leftChild.leftChild = new TreeNode(1);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild.leftChild = new TreeNode(7);
		root.rightChild.rightChild = new TreeNode(11);
		root.rightChild.rightChild.leftChild = new TreeNode(9);
		root.rightChild.rightChild.rightChild = new TreeNode(13);
	
	}
	
	
	
	public void printInorderRegular() {
		printInorderRegular_(root);
	}
	
	private void printInorderRegular_(TreeNode t) {
		if(t==null) return;
		if(t.leftChild != null) {
			printInorderRegular_(t.leftChild);
		}
		System.out.println(t.data2);
		if(t.rightChild != null) {
			printInorderRegular_(t.rightChild);
		}
	}
	
	public void convertToThreadedTree() {
		TreeNode t = root;
		convertToThreadedTree_(t);
	}
	
    private TreeNode convertToThreadedTree_(TreeNode t) {
    	      // This function will return the in order predecessor of the the parent node
    	      // Once we have the predecessor we can connect it to the parent node to form the threaded tree.
    	   
    	     // The base cases are most important
    	     // for a leaf node no thread would connect to it. It will be an in order predecessor
    	     if (t.leftChild == null && t.rightChild == null) {
    	    	     return t;
    	     }
    	     
    	     if(t.leftChild != null) {
    	    	    // Find the in order predecessor in the left subtree. Thread the predecessor to this node
    	    	    convertToThreadedTree_(t.leftChild).rightChild = t;
    	     }
    	     
    	     if(t.rightChild != null) {
    	    	    // The in order predecessor that we get from the right subtree would be the predecessor of one of the parents of this
    	    	    // node. So we have to propagate it up. Right subtree cannot provide in order predecessor of the current node.
    	    	    return convertToThreadedTree_(t.rightChild);
    	     }
    	
    	     // Notice we are going to propagate in order predecessor only for the case where the current node has a right child.
    	     // In all other case the current node would be the in order predecessor.
    	     return t;
	}
    
	
}
