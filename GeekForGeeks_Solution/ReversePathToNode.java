package JavaLearn.GeekForGeeks_Solution;

import java.util.*;


public class ReversePathToNode {
	public static void main(String[]args) {
		BinTree_ReversePath obj = new BinTree_ReversePath();
		obj.createTree();
		obj.reversePath(10);
		obj.reversePath(25);
		obj.reversePath(14);
		obj.inorder_print();
	}
}

class BinTree_ReversePath extends BinTree {
	
	public void reversePath(int target) {
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.offerFirst(root.d);
		if(!reversePathInternal(root,target,dq)) {
			dq.removeFirst();
		}
	}
	
	/**
	 * 
	 * The idea is to store each element we visit in the path from root to target node in a dequeue. Once we find the target, we 
	 * start replacing the nodes in the path with values from the deque. Also note if we dont find the target node in a path we
	 * need to remove the node we added in the dequeue. The call that added a node to the dequeue is responsible for removing it.
	 * 
	 * Top down - populate dequeue
	 * Bottom up - replace node values
	 * 
	 * @return True if target was found in the path.
	 */
	private boolean reversePathInternal (Node root, int target, Deque<Integer> dq) {
		
		if(root == null) {
			return false;
		}
		// target found. replace node value.
		if(root.d == target) {
			root.d = dq.removeLast();
			return true;
		} 
		// search target in left subtree. 
		if(root.left != null) {
			// add left subtree node to dq
			dq.offerFirst(root.left.d);
			// if target is not found, it must be removed from dq
			if(!reversePathInternal(root.left,target,dq)) {
				dq.removeFirst();
			} else {
				// if target is found replace node value
				root.d = dq.removeLast();
				return true;
			}
		}
		
		if(root.right != null) {
			dq.offerFirst(root.right.d);
			if(!reversePathInternal(root.right,target,dq)) {
				dq.removeFirst();
			} else {
				root.d = dq.removeLast();
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Target 10:
	 * 
	 *        10
	 *       /  \
	 *      3    22
	 *     /  \    \
	 *    5    8    25
	 *        / \
	 *      20   14
	 *      
	 *      
	 *  Target 25:
	 *      
	 *        25
	 *       /  \
	 *      3    22
	 *     /  \    \
	 *    5    8    10
	 *        / \
	 *      20   14
	 *      
	 *      
	 *  Target 14:
	 *      
	 *        14
	 *       /  \
	 *      8    22
	 *     /  \    \
	 *    5    3    10
	 *        / \
	 *      20   25
	 */
	public void inorder_print() {
		inorderRecursionInternal(root);
	}
	
	
	private void inorderRecursionInternal(Node temp) {
		
		if(temp == null) {
			return;
		}
		inorderRecursionInternal(temp.left);
		System.out.println(temp.d);
		inorderRecursionInternal(temp.right);
	}
}
