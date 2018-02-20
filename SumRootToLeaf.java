package JavaLearn;


//https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
public class SumRootToLeaf {
	public static void main(String[] args) {

		Create1digitTree binTree2 = new Create1digitTree();
		binTree2.createTree2();

		PathSum pSum = new PathSum();
		int val = pSum.sumofrootToLeaf(binTree2.root);
		System.out.print(val);
	}
}
class Create1digitTree{
	public TreeNode root;
/**
 *                 6
 *              /    \
 *             3      5
 *           /    \      \
 *          2      5      4
 *                /  \
 *               7    4
 */
public void createTree2() {
	root = new TreeNode(6);
	root.leftChild = new TreeNode(3);
	root.leftChild.leftChild = new TreeNode(2);
	root.leftChild.rightChild = new TreeNode(5);
	root.leftChild.rightChild.leftChild = new TreeNode(7);

	root.leftChild.rightChild.rightChild = new TreeNode(4);

	root.rightChild = new TreeNode(5);
	root.rightChild.rightChild = new TreeNode(4);
	//root.rightChild.leftChild.rightChild = new TreeNode(2);
	//root.rightChild.rightChild = new TreeNode(25); 
}
}

class PathSum {

	public int sumofpath(int val, TreeNode temp) {

		if (temp == null)
			return 0;
		System.out.println(" "+val*10+" "+temp.data);

		val = ((val * 10) + temp.data);

		if (temp.leftChild == null && temp.rightChild == null) {
			return val;
		} else
			return sumofpath(val, temp.leftChild) + sumofpath(val, temp.rightChild);
	}

	public int sumofrootToLeaf(TreeNode temp) {

		return sumofpath(0, temp);
	}
}