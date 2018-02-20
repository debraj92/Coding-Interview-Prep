package JavaLearn;

//FIND MAX 3 ELEMENTS
public class TopThreeElements {
	public static void main(String[] args) {

		MyBinTree binTree = new MyBinTree();
		binTree.createTree();
		TopElementsInTree top = new TopElementsInTree();

		top.findTopThree(binTree.root);
		top.printResult();

	}
}

class TopElementsInTree {

	int first = 0, second = 0, third = 0;

	public void findTopThree(TreeNode temp) {
		if (temp == null)
			return;

		if (temp.data > first) {
			third = second;
			second = first;
			first = temp.data;
		} else if (temp.data > second && temp.data != first) {
			third = second;
			second = temp.data;
		} else if (temp.data > third && temp.data != first && temp.data != second) {
			third = temp.data;
		}

		findTopThree(temp.leftChild);
		findTopThree(temp.rightChild);

	}

	public void printResult() {
		System.out.println(" " + first + " " + second + " " + third);
	}
}