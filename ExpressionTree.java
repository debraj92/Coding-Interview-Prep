package JavaLearn;

import java.util.Stack;

// https://www.geeksforgeeks.org/expression-tree/

public class ExpressionTree {
    public static void main(String[] args) {
    	
    	CreateExpressionTree cTree = new CreateExpressionTree();
    	String experssion = "87+31*4*-";//"ab+ef*g*-";//"ab+ef*g*-" ;
    	char[] exp = experssion.toCharArray();
    	ExpressionNode temp = cTree.expressionTree(exp);
    	cTree.inOrderExpressionTreeTraversal(temp);
    	System.out.println();
    	System.out.println("Evaluated expression "+cTree.evaluateExpTree());
    }
}
class CreateExpressionTree{
	public ExpressionNode root;
	
	public void inOrderExpressionTreeTraversal(ExpressionNode temp) {
		if(temp == null) {
			System.out.println("Tree is empty");
		} else if (temp.left == null && temp.right == null) {
            System.out.print(" "+temp.element);
		} else {
			
			inOrderExpressionTreeTraversal(temp.left);
			System.out.print(" "+temp.element);
			inOrderExpressionTreeTraversal(temp.right);
		}
	}
	/**
	 * 
	 * @param c each character of the infix expression
	 * @return true if char is operator, false is operand
	 */
	public boolean isOperator(char c) {
		        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
		            return true;
		        }
		        return false;
		    }
		 
	public ExpressionNode expressionTree(char[] exp) {
		ExpressionNode e1, e2, e3;
		Stack<ExpressionNode> st = new Stack<>();
		
		for(int i = 0 ; i < exp.length; i++) {
			// if operand push them to stack after converting to node
			if(!isOperator(exp[i]))	{
				//while pushing into the stack we convert the char to node
				 e1 =new ExpressionNode(exp[i]);
				st.push(e1);
			} else {
				// if operator, pop 2 from the stack, create a node as:
				/**
				 *    +   ---> node
				 *   / \
				 *  a   b 
				 *  push the node into the stack
				 */
				//since we have to push e1 as it will be root of subtree so we convert it to node
				 e1 =new ExpressionNode(exp[i]);
				 e2 = st.pop();
				 e3= st.pop();
				
                e1.left = e3;
                e1.right = e2;
                
                st.push(e1);
			}
		}
		//returning the root node
		return root = st.pop();
	}
	
	public int evaluateExpTree() {
		
		ExpressionNode t = root;
		/**
		 * The idea is similar to post order traversal.
		 *    +
		 *   / \
		 *  2   *
		 *     / \
		 *    3   5 
		 *  
		 *  Output : (2) LEFT (+) ROOT (3 * 5) RIGHT  -> First get the left value and right value. Apply the operand. 
		 */
		
		return evaluateExpTreeInternal(t);
		
	}
	
	public int evaluateExpTreeInternal(ExpressionNode t) {
		if (t.left == null && t.right == null) {
			// leaf nodes are always data
			return Character.getNumericValue(t.element);
		} else {
			// non-leaf are always operand
			// get left and right data
			int leftVal = evaluateExpTreeInternal(t.left);
			int rightVal = evaluateExpTreeInternal(t.right);
			// operate using the current operand
			switch(t.element) {
			case '+':
				return leftVal + rightVal;
			case '-':
				return leftVal - rightVal;
			case '*':
				return leftVal * rightVal;
			default:
				// we only have four operands : + , -, *, /
				return leftVal / rightVal;
			}
		}
	}
}
class ExpressionNode{
	char element;
	ExpressionNode  left, right;
	ExpressionNode(char data) {
		element = data;
		left = right = null;
	}
}