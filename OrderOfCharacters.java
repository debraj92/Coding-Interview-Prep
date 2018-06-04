package JavaLearn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * 
 */

public class OrderOfCharacters {
	public static void main(String[] args) {
		OrderFromDictionaryHelper obj = new OrderFromDictionaryHelper();
		String[] words = new String[] { "baa", "abcd", "abca", "cab", "cad" };//{"caa", "aaa", "aab"};
		obj.createGraph(words);
		obj.printAdj();
		System.out.println();
		obj.topologicalSort();
	}
}

/**
 * Class to help find the order of characters from an array of sorted strings
 */
class OrderFromDictionaryHelper {
	/**
	 * array of arraylist
	 * 
	 * We have an array of 26 characters which form the node of the graph. The nodes
	 * have an attached arraylist to represent the edges to other vertices
	 */
	private Set<Character>[] adj = new HashSet[26];

	/**
	 * From the array of words: {baa, abcd, abca, cab, cad}, this method will create
	 * the graph:
	 * 
	 * 
	 */
	public void createGraph(String[] words) {
		// compare between pair of words
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i+1; j < words.length; j++) {
				createConnection(words[i], words[j]);
			}
		}
	}

	/**
	 * Create vertices from the characters present in each word. Compare each character and when 2 dissimilar chars are found
	 * create an edge from the character of word1 to the character of word2
	 */
	private void createConnection(String w1, String w2) {
		for (int k = 0; k < w1.length() && k < w2.length(); k++) {
			char c1 = w1.charAt(k);
			char c2 = w2.charAt(k);
			int index1 = c1-97; // c1 is located at the (c1-97)th location of the adj list. For example "a" is at 0 and "z" is at 25 
			int index2 = c2-97;
			//create both the vertices in the graph if not already created
			if(adj[index1] == null) {
				adj[index1] = new HashSet<Character>(); // we chose to use a hashset because it automatically eliminates duplicates. For example if we get baa, ceb,then we create b->c. Again for another comparison baa, ced, we dont want to add b->c->c in the adj matrix.
			}
			if(adj[index2] == null) {
				adj[index2] = new HashSet<Character>();
			}
			//create connection from c1 to c2
			if (c1 != c2) {
				adj[index1].add(c2);
				break;
			}
		}
	}

	public void printAdj() {
		for (int i = 0; i < 26; i++) {
			if (adj[i] != null) {
				System.out.print((char)(i+97) + "->");
				for (char c : adj[i]) {
					System.out.print(c + " ->");
				}
				System.out.println();
			}
		}
	}
	
	boolean[] visited = new boolean[26];
	
	/**
	 * https://www.geeksforgeeks.org/java-program-for-topological-sorting/
	 * 
	 * Topological sort displays the vertices in the order that if there is an edge from vi to vj then vi will
	 * be printed before vj
	 * 
	 * Logic: start topological sort from any vertex (say v). Go deeper by following edges from that vertex until you find a 
	 * vertex which does not have an outgoing edge. Push this to stack. Similarly all the vertices which are reachable
	 * from v are pushed into the stack. V is pushed in the end after the ones reachable from v are pushed. When we print this stack, v is printed before
	 * all other vertices reachable from v. Thus the printing of the stack will show the topological sort of the graph.
	 */
	public void topologicalSort() {
		// set all the nodes as unvisited. The nodes/characters which are not even present in the graph can be marked
		// as visited
		for (int i = 0; i < 26; i++) {
			if (adj[i] != null) {
				visited[i] = false;
			} else {
				visited[i] = true;
			}
		}
		Stack<Character> st = new Stack<>();
		//the stack must be filled in bottom up fashion. The last vertex which has no adjacent vertex will be put first
		for(int i = 0; i < 26; i++) {
			if(!visited[i]) {
				topologicalSortInternal(i,st);
			}
		}
		/**
		 * The vertex which has no incoming edges is on top of stack
		 */
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}
	
	public void topologicalSortInternal(int i, Stack<Character> st) {
		visited[i] = true;
		/**
		 * Executed at the end (boundary condition)
		 */
		if(adj[i].isEmpty()) {
			st.push((char)(i+97));
			return;
		}
		for (char c : adj[i]) {
			if(!visited[c-97]) {
				topologicalSortInternal(c-97,st);
			}
		}
		/**
		 * After the boundary condition is executed the vertex from which the last vertex was reached is added to stack.
		 * Then the vertex before this is added.
		 */
		st.push((char)(i+97));
	}
}