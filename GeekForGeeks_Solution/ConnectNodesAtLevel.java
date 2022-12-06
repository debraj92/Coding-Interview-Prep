package JavaLearn.GeekForGeeks_Solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 */
public class ConnectNodesAtLevel {
	public static void main(String[]args) {
		ConnectNodeAtLevelHelp obj = new ConnectNodeAtLevelHelp();
		obj.buildTree();
		obj.setLevelPointers();
		obj.printLevels();
	}
}


class ConnectNodeAtLevelHelp {
	NodeLevelConnect root;
	
	/**
	 *      A
	 *     / \
	 *    B   C
	 *    /\   \
	 *   D  E   F
	 */
	public void buildTree() {
		root = new NodeLevelConnect('A');
		root.left = new NodeLevelConnect('B');
		root.right = new NodeLevelConnect('C');
		root.left.left = new NodeLevelConnect('D');
		root.left.right = new NodeLevelConnect('E');
		root.right.right = new NodeLevelConnect('F');
	}
	
	public void setLevelPointers() {
		Queue<NodeLevelConnect> q = new ArrayDeque<>();
		q.add(root);
		// The size will indicate the number of nodes in each level of the q
		int size;
		NodeLevelConnect prev, cur;
		while(!q.isEmpty()) {
			size = q.size();
			/**
			 * Two pointers prev and cur will be used to create the level order connections
			 */
			prev = null;
			cur = null;
			/**
			 * Note, although the q will contain more elements than in each level, we will process (create level connections) only elements in that level (size number of elements)
			 */
			while(size-->0) {
				cur = q.remove();
				if(prev != null) {
					// set up the level order connections
					prev.level = cur;
				}
				if(cur.left != null) {
					q.add(cur.left);
				}
				if(cur.right != null) {
					q.add(cur.right);
				}
				prev = cur;
			}
		}
	}
	
	/**
	 * Output:
	 *    A->
	 *    B->C->
	 *    D->E->F
	 */
	public void printLevels() {
		NodeLevelConnect temp = root;
		while(temp != null) {
			printLevel(temp);
			temp = temp.left;
		}
	}
	
	private void printLevel(NodeLevelConnect node) {
		while(node != null) {
			System.out.print(node.data + "->");
			node = node.level;
		}
		System.out.println("\n");
	}
}


/**
 *                             level
 *         NodeLevelConnect ----------------> NodeLevelConnect 
 *          left   /  \   right
 *                +    +
 *NodeLevelConnect     NodeLevelConnect     
 *
 */
class NodeLevelConnect {
	char data;
	NodeLevelConnect(char data) {
		this.data = data;
	}
	NodeLevelConnect left;
	NodeLevelConnect right;
	NodeLevelConnect level;
}