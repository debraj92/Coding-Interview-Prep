package JavaLearn.GeekForGeeks_Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

// https://www.geeksforgeeks.org/bottom-view-binary-tree/

public class BottomViewBinTree {
	public static void main(String[]args) {
		BinTree b = new BinTree();
		b.createTree();
		b.printBottomView();
	}
}

class BinTree {
	Node root;
	
	/**
	 *        20
	 *       /  \
	 *      8    22
	 *     /  \    \
	 *    5    3    25
	 *        / \
	 *      10   14
	 */
	public void createTree() {
		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right.right = new Node(25);
	}
	
	// hmap to store bottom view elements. Maps distance from center to a Pair {value of a node , level of that node }
	HashMap<Integer, Pair> hmap;
	
	/**
	 *  The idea is to use a hashmap to store a mapping between node and its distance from the center. The root is at 0
	 *  and its left child is at -1 and right child at +1. Once we have visited all the nodes the hashmap will only contain
	 *  the bottom view elements.
	 *    
	 *   -2-1 0  1  2    
	 *         
	 *        20
	 *       /  \
	 *      8    22
	 *     /  \    \
	 *    5    3    25
	 *        / \
	 *      10   14
	 *      
	 *    How the values change in the hashmap  
	 *   -2 -       5
	 *   -1 -    8     10
	 *    0 - 20    3
	 *    1 -    22    14
	 *    2 -       25
	 *    time (t=0)   -----> time (t=infinity)
	 */
	public void printBottomView() {
		hmap = new HashMap<>();
		// we do the job in a top down manner so we will use preorder traversal
		updateHMap(root,0,1);
		// the keys from the hashmap needs to be sorted for proper print
		Set<Integer> keys = hmap.keySet();
		ArrayList<Integer> arr = new ArrayList<>(keys);
		Collections.sort(arr);
		for (int k: arr) {
			// print the bottom most element at distance k from the center
			System.out.println(hmap.get(k).data);
		}
	}
	
	// position is the current node's distance from the center
	// level is the current node's level in the binary tree
	private void updateHMap (Node current, int position, int level) {
		if(current == null) {
			return;
		}
		// process the current element first since this is pre order traversal.
		// we will allow the current element to over write the hmap value only if the current element is lower in the tree than the
		// element in the hashmap. That is the level of the current element should be greater than existing element at the same distance
		// from the center.
		if(hmap.containsKey(position)) {
			// we need to compare the level of the current element to that in the hmap
			if (hmap.get(position).level < level) {
				// we can over write
				hmap.put(position, new Pair(current.d, level));
			}
		} else {
			hmap.put(position, new Pair(current.d, level));
		}
		
		// recurse for left and right
		updateHMap(current.left, position - 1, level + 1);
		updateHMap(current.right, position + 1, level + 1);
	}
	
	// a mapping between node value and its level in the binary tree.
	class Pair {
		// value of a node
		int data;
		// level of the node
		int level;
		Pair (int d, int l) {
			data = d;
			level = l;
		}
	}
}

class Node {
	int d;
	Node left;
	Node right;
	Node(int d) {
		this.d = d;
	}
}
