package JavaLearn.GeekForGeeks_Solution;

//https://www.geeksforgeeks.org/find-possible-words-phone-digits/

import java.util.*;

public class PhoneNumber {
	public static void main (String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		String n = in.nextLine();
		long startTime = System.currentTimeMillis();
		String[] buckets = {"","","a-b-c","d-e-f","g-h-i","j-k-l","m-n-o","p-q-r-s","t-u-v","w-x-y-z"};
		/**
		 * We will create a graph from the buckets. Let n = 3 4 5
		 * The a,b,c will form the first level. All the nodes of the first level will be connected to the second
		 * level, which is d,e,f. Ignore the numbers 1 and 0.
		 * 
		 * The DFS traversal of this graph will produce the required output
		 */
		ArrayList<Contain[]> adj = new ArrayList<>();
		for(int i=0; i< n.length(); i++) {
			int digit = Integer.parseInt(n.charAt(i)+"");
			if(digit == 0 || digit == 1) {
				continue;
			} else {
				String[] bucket = buckets[digit].split("-");
				adj.add(getContainers(bucket));
			}
		}
		//create the connections
		for(int i=0;i<adj.size()-1;i++) {
			for(int j=0; j<adj.get(i).length;j++) {
				adj.get(i)[j].setNextNodes(adj.get(i+1));
			}
		}
		doDFS(adj);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time "+estimatedTime);
	}
	
	
	public static Contain[] getContainers(String[] bucket) {
		Contain[] all = new Contain[bucket.length];
		for (int i=0;i<bucket.length; i++) {
			all[i] = new Contain(bucket[i]);
		}
		return all;
	}
	
	public static void doDFS(ArrayList<Contain[]> adj) {
		doDFSInternal(adj,0,"");
	}
	
	public static void doDFSInternal(ArrayList<Contain[]> adj, int level, String res) {
		if(level == adj.size()) {
			System.out.println(res);
			return;
		}
		for(int i=0; i<adj.get(level).length;i++ ) {
			//res += adj.get(level)[i].element;
			doDFSInternal(adj,level+1,res+adj.get(level)[i].element);
		}
	}
	
}

/**
 * Contain represent a single character node of the DFS graph. It has a list of next nodes which it connects to.
 *
 */
class Contain {
	Contain[] nextNodes;
	String element;
	Contain(String value) {
		element = value;
	}
	void setNextNodes(Contain[] all) {
		nextNodes = all;
	}
}
