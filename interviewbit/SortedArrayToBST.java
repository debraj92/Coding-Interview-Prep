package JavaLearn.interviewbit;

class SortedArrayToBSTImpl {
	
	public TreeNode convert(final int[] A) {
        TreeNode tn = convertUtil(A, 0, A.length - 1);
        return tn;
    }
    
    private TreeNode convertUtil(int[] A, int start, int end) {
        if(end < start) {
            return null;
        }
        if (start == end) {
            return new TreeNode(A[start]);
        }
        int num_elems = end - start + 1;
        int mid = start + num_elems / 2;
        TreeNode tn = new TreeNode(A[mid]);
        tn.left = convertUtil(A, start, mid-1);
        tn.right = convertUtil(A, mid+1, end);
        return tn;
    }
    
    public void inorder(TreeNode n) {
        if (n != null) {
            inorder(n.left);
            System.out.println(n.val);
            inorder(n.right);
        }
    }
}

class TreeNode { 
	int val;
	TreeNode left, right;
	TreeNode(int v) {
		val = v;
	}
}

public class SortedArrayToBST {
	public static void main(String[]args) {
		SortedArrayToBSTImpl obj = new SortedArrayToBSTImpl();
		int[] arr = new int[] {1,3,6,7,8,9};
		TreeNode bst = obj.convert(arr);
		obj.inorder(bst);
	}
}