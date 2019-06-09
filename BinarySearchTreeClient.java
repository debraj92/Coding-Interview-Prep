package JavaLearn;

public class BinarySearchTreeClient {
	public static void main(String[] args) {
		BinarySearchTreeClass bst = new BinarySearchTreeClass();
		bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        
        bst.inorder();
        System.out.println();
         System.out.println("is present?"+bst.SearchElement(60));
         
         bst.insert(10);
         bst.insert(75);
         bst.inorder();
         
         bst.delete(40);
         System.out.println();
         System.out.println("printing tree after deleting 40 (leaf)");
         bst.inorder();
         bst.delete(70);
         System.out.println();
         System.out.println("printing tree after deleting 70 (two children)");
         bst.inorder();
         bst.delete(50);
         System.out.println();
         System.out.println("printing tree after deleting 50 (root)");
         bst.inorder();
         
	}

}

class BinarySearchTreeClass{
	TreeNode root;
	
     BinarySearchTreeClass(){
    	 root = null;
     }
     
     public void delete(int element) {
    	 	 TreeNode resultNode = deleteRec(root, element);
    	 	 if(resultNode == null) {
    	 		 System.out.println("Did not find the node to delete");
    	 	 }
     }
     
     public TreeNode deleteRec(TreeNode temp, int element) {
    	 /**
    	  * see the theory from here
    	  * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
    	  */
    	 
    	 if(temp == null) {
    		 // we did not find the element to delete. Remember this case is hit after we have reached the leaf and still did not find the element.
    		 // this could also be the case when root is null or the tree is not yet created (which is unlikely)
    		 return null;
    	 }
    	 
    	 
    	 /**
    	  * The logic to delete is, for the node to delete - we will change the value of this node to the value of an appropriate replacement child node and then assign this node to its parent.
    	  * For other nodes (which are not to be deleted) we will assign the same nodes to its parent
    	  */
    	 
    	 if(temp.data > element) {
    		 // current node is bigger than the element to be deleted. The element must be to its left
    		 temp.left = deleteRec(temp.left, element);
    	 }
    	 else if(temp.data < element) {
    		 temp.right = deleteRec(temp.right, element);
    	 }
    	 else {
    		 // we found the element to delete
    		 if(temp.left == null && temp.right == null) {
    			 // leaf node. We can just delete it by replacing the deleted node with null
    			 return null;
    		 }
    		 else if(temp.left == null) {
    			 // only one child -> right child. The right child should take the place of this deleted node. So just return the right child
    			 return temp.right;
    		 }
    		 else if(temp.right == null) {
    			 return temp.left;
    		 } 
    		 else {
    			 /**
    			  * case where the deleted node has both left and right child.
    			  * We find the minimum node in its right subtree (inorder successor) and make that node as the replacement of the deleted node.
    			  * We also have to delete the minimum node from the right subtree. The minimum node can be the left most leaf of the right subtree in which case
    			  * the case for leaf node of deleteRec will remove it. The minimum node can also be the leftmost node with a right child in which case the one child
    			  * case of deleteRec will remove it
    			  */
    			 int min = findMinElem(temp.right);
    			 temp.data = min; // changing the value of the deleted node to the minimum of its right subtree
    			 temp.right = deleteRec(temp.right,min);
    			 return temp;
    		 }
    		 
    	 }
    	 // This ensures other nodes which are not deleted are unaltered. Do you see WHY?
    	 return temp;
     }
     
     public int findMinElem(TreeNode root) {
    	 TreeNode temp = root;
    	 int min = temp.data;
    	 while(temp != null) {
    		 min = temp.data;
    		 temp = temp.left;
    	 }
    	 return min;
     }
     
     

     
	public void insert(int data) {
		root = insertRec(root, data);
		
	}
	
	
	public TreeNode insertRec(TreeNode temp, int data) {
		//use temp for traversal of the tree
		if(temp == null) {
			/**
			 * We have found the perfect place for inserting data. However, the actual insertion will be done by its parent node
			 */
			return new TreeNode(data);
		}
		// we have still not found the best place
		if(temp.data < data) {
			/**
			 * This will actually do the insertion.
			 * Consider that "data" should be inserted as the left child of the current temp. In this case the next call insertRec will return a new TreeNode(). We
			 * have to set the left child of the current temp as the returned TreeNode. 
			 * 
			 * Also note, for other cases (that is Nodes whose left child/right child will not be the new TreeNode) the nodes remain the same as we will just assign the
			 * same left / right child to the current temp
			 */
			temp.right = insertRec(temp.right , data);
		}
		else {
			temp.left = insertRec(temp.left , data);
		}
		// this is the case for all other nodes except the one where new TreeNode(data) is actually getting inserted. 
		return temp;
	}
	
	public boolean SearchElement(int element) {
		
		TreeNode node = SearchElementInternal(root, element);
		if(node == null) {
			//Did not find the element
			return false;
		}
		// we found the element
		return true;
	}
	
	// use temp for traversal
	public TreeNode SearchElementInternal(TreeNode temp, int element) {
		/**
		 * Boundary condition: temp will become null if element is not found
		 */
		if(temp == null) {
			return null;
		}
		/**
		 * Observe if temp null check is not done, then temp.data will throw NullPointerException
		 */
		if(element == temp.data) {
			// element found
			return temp;
		} else if (element < temp.data) {
			/**
			 * Search the element in the left child (BST property).
			 * If the left child equals the element then it will return its node. Then, this node should also propagate
			 * the result. Hence we write, "return SearchElementInternal"
			 */
			return SearchElementInternal(temp.left, element);
		} else {
			/**
			 * Search the element in the right child (BST property)
			 */
			return SearchElementInternal(root.right, element);
		}
	}
	
	void inorder()  {
	       inorderRec(root);
	    }
	 
	    // A utility function to do inorder traversal of BST
	    void inorderRec(TreeNode root) {
	        if (root != null) {
	            inorderRec(root.left);
	            
	            System.out.print(root.data+" ");
	            
	            inorderRec(root.right);
	        }
	        
	    }
	
class TreeNode{
	int data;
	TreeNode left,right ;
	TreeNode(int key){
		data = key;
		left= null;
		right = null;
	}
}
}