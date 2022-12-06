package JavaLearn.GeekForGeeks_Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/build-original-array-from-the-given-sub-sequences/
 *
 * Q. given n sequences, recreate the original array.
 * 
 * The idea is to create a directed graph from the sequences. Topological sorting of this graph would produce the array.
 */
public class ArrayFromSequences {
	public static void main(String [] args) {
		/**
		 *    1->2->3->4
		 *       |     |
		 *    0->5------  
		 */
		/*int[][] sequences = {{1, 2, 3}, {1, 2}, {3, 4}, {5, 2}, {0, 5, 4}};
		int n = 6;
		Graph1 g = new Graph1(n);
		g.addSequence(sequences, 5);
		*/
		
		int[][] sequences = {
				{9, 1, 2, 8, 3},
				{6, 1, 2},
				{9, 6, 3, 4},
				{5, 2, 7},
				{0, 9, 5, 4}
		};
		int n = 10;
		Graph1 g = new Graph1(n);
		g.addSequence(sequences, 5);
		
		g.printGraph();
		int[] result = g.getTopologicalOrder();
		for(int i=0; i<n; i++) {
			System.out.print(result[i]+"  ");
		}
	}
}

class Graph1 {
	
	private ArrayList<Integer>[] adjMat;
	private int n;
	
	// @param n number of vertices
	@SuppressWarnings("unchecked")
	Graph1(int num) {
		n = num;
		adjMat = new ArrayList[n];
		// initialize all the lists in the adj matrix
		for(int i=0; i<n; i++) {
			adjMat[i] = new ArrayList<Integer>();
		}
	}
	
	// add the edges based on sequences
	public void addSequence(int[][] sequences, int countOfSequences) {
		for(int seq = 0; seq<countOfSequences; seq++) {
			addEdges(sequences[seq]);
		}
	}
	
	// add all the edges from a single sequence
	private void addEdges(int[] sequence) {
		for(int i=0; i<sequence.length-1;i++) {
			addEdge(sequence[i],sequence[i+1]);
		}
	}
	
	// add a single edge
	private void addEdge(int src, int dst) {
		if(!adjMat[src].contains(dst)) {
			adjMat[src].add(dst);
		}
	}
	
	public void printGraph() {
		for(int i=0; i<n; i++) {
			System.out.print(i+"-> ");
			for(int dst:adjMat[i]) {
				System.out.print(dst+", ");
			}
			System.out.println();
		}
	}
	
	public int[] getTopologicalOrder() {
		
		int[] result = new int[n];
		int[] indegrees = calculateIndegrees();
		
		Queue<Integer> q = new LinkedList<Integer>();
		/**
		 * The q will contain all the 0 indegeree elements
		 */
		for(int i=0; i<n; i++) {
			if(indegrees[i] == 0) {
				q.add(i);
			}
		}
		int counter = 0;
		while(!q.isEmpty()) {
			int v = q.poll();
			result[counter++] = v;
			/**
			 * since we are removing v we need to update indegrees. Also if indegree of a vertex becomes zero it can enter q
			 */
			for(int dst:adjMat[v]) {
				indegrees[dst]--;
				if(indegrees[dst] == 0) {
					q.add(dst);
				}
			}
		}
		
		return result;
	}
	
	private int[] calculateIndegrees() {
		int[] indegrees = new int[n];
		// for every src increase the indegree of its dst by 1
		for(int src=0; src<n; src++) {
			for(int dst:adjMat[src]) {
				indegrees[dst]++;
			}
		}
		return indegrees;
	}
}
