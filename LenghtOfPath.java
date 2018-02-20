package JavaLearn;
//finding path of given pair of elements
public class LenghtOfPath {
	public static void main(String[] args) {
		
		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		
		PathofPair pp =new PathofPair();
		/*int result =pp.fndElement(binTree.root, 13);
		System.out.println("Is 22 present? "+result);
		
		System.out.println("path of 3 and 12  is "+pp.pathofpairmethod(binTree.root, 15, 7));
		*/
		
		TreeNode node1 =pp.findCommonAncestor(binTree.root, 3, 15);
		System.out.println("common ancestor is "+node1.data);
		
		//pp.pathOfGivenPair(binTree.root, 22, 12);
		int result = pp.pathOfGivenPair(binTree.root, 19, 7);
		if(result != -1) {
		System.out.println("Path of given pairs is "+result);
		}
	}

}

class PathofPair{
	
	public int pathOfGivenPair(TreeNode temp, int n1, int n2) {
		
		TreeNode ancestor = findCommonAncestor(temp,n1,n2);
		if(ancestor == null ) {
			System.err.println("No path found");
			return -1;
		}
		int l1= findElementlenRec(ancestor,n1);
		int l2 = findElementlenRec(ancestor,n2);
		System.out.println(l1+ " "+ l2);
		return l1+l2-2;
	}
	/**
	 * 
	 * @param temp
	 * @param n1
	 * @param n2
	 * @return node which is the common ancestor
	 */
	public TreeNode findCommonAncestor(TreeNode temp, int n1,int n2) {
			//NOTE: we are calling findElementRec
		boolean inLeft = findElementRec(temp.leftChild,n1, n2);
		boolean inRight = findElementRec(temp.rightChild,n1,n2);
		//below if statement checks for the case when the caller node itself is n1 or n2.
		if(temp.data == n1 || temp.data == n2) {
			if (findElementRec(temp.leftChild, n1, n2) || findElementRec(temp.rightChild, n1, n2)) {
				return temp;
			} else {
				return null;
			}
		}
		//if n1 and n2 are present in left and right subtree respectively
		if (inLeft && inRight) {
			return temp;
		}
		else if (inLeft) {
		return	findCommonAncestor(temp.leftChild,n1,n2);
			/**
			 * we are using return keyword here bcz we want to return the result to its caller.
			 * to propagate the result to its caller
			 */
		}
		else if(inRight) {
			return findCommonAncestor(temp.rightChild, n1,n2);
		} else {
			return null;
		}
	}
	
	public boolean findElementRec(TreeNode temp, int n1, int n2) {
		if(temp == null)
			return false;
		
		else if(temp.leftChild == null && temp.rightChild == null)
			return temp.data == n1 || temp.data == n2;
		
		else {
			if( temp.data == n1|| temp.data == n2) {
				return true;
			} else {
			boolean findElementLeft = findElementRec(temp.leftChild, n1, n2);
			boolean findElementRight= findElementRec(temp.rightChild, n1, n2);
			return findElementLeft || findElementRight;
			}
		}
	}
	//method to find the length of the given element from the given node
	public int findElementlenRec(TreeNode temp, int element) {
		
		if(temp == null)
			return -1;
		
		else if(temp.leftChild == null && temp.rightChild == null) {
			if(temp.data == element)
				return 1;
			else
				return -1;
		}
		
		else {
			if(temp.data == element)
				return 1;
			else {
				int leftlen = findElementlenRec(temp.leftChild, element);
				int rightlen = findElementlenRec(temp.rightChild, element);
				
				if(leftlen >= 1)
					return leftlen+1;
				if(rightlen >=1)
					return rightlen+1;
				else return -1;
			}
		}
	}
}
