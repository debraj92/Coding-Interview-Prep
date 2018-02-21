package JavaLearn;

import java.util.LinkedList;

public class GraphImplClient {
	
	/**
	 *  Graph 1:
	 *      0 -> 1 -> 2  <-    5 -> 6
	 *      |    |    |   |    |    ^
	 *      V    |    V   |    V    |
	 *      4    -->  3   |    7 -> 8
	 *      |_____________|
	 *      
	 *      Two disconnected components
	 *      Total number of vertices = 9
	 *      
	 *  Graph 2 (https://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/):    
	 *  
	 *    0 --> 1
	 *   ^ |    |
	 *   | V    |
	 *    2 <----
	 *    |
	 *    ------>3->
	 *           ^ |
	 *           | V
	 *           <--
	 */ 
	
	
	public static void main(String[]args) {
		
		//Graph 1
		/*
		MyGraph mygraph = new MyGraph(9);
		mygraph.addEdge(0, 1);
		mygraph.addEdge(0, 4);
		mygraph.addEdge(1, 2);
		mygraph.addEdge(1, 3);
		mygraph.addEdge(2, 3);
		mygraph.addEdge(4, 2);
		mygraph.addEdge(5, 6);
		mygraph.addEdge(5, 7);
		mygraph.addEdge(7, 8);
		mygraph.addEdge(8, 6);
		*/
		
		// Graph 2
		MyGraph mygraph = new MyGraph(4);
		mygraph.addEdge(0, 2);
		mygraph.addEdge(2, 0);
		mygraph.addEdge(0, 1);
		mygraph.addEdge(1, 2);
		mygraph.addEdge(2, 3);
		mygraph.addEdge(3, 3);
		
		mygraph.printAdjList();
		System.out.println("**** DFS TRAVERSAL OF ENTIRE GRAPH ****");
		mygraph.dfsUtil();
		System.out.println("**** DFS TRAVERSAL FROM VERTEX 2 ****");
		mygraph.dfsFromVertex(2);
	}
}


/**
 * Graph using adjacency list for a directed graph
 */
class MyGraph {
	
	//Adjacency list
	private LinkedList<Integer> adjList[];
	private int countOfVertices;
	
	MyGraph (int number_of_vertices) {
		countOfVertices = number_of_vertices;
		this.adjList = new LinkedList[number_of_vertices];
		for(int i=0; i<number_of_vertices ; i++) {
			this.adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dst) {
		if(adjList == null) {
			System.out.println("List is empty");
			return;
		}
		/**
		 * adjList[src] - accesses the src index of the adjacency array
		 * .add(dst) - adds a dst vertex to the adjacency list of the src list
		 */
		adjList[src].add(dst);
	}
	
	public void printAdjList() {
		for(int i= 0; i < countOfVertices; i++) {
			// get the adjacency list of a vertex
			LinkedList<Integer> currentVertexList = adjList[i];
			if(currentVertexList != null) {
				System.out.print(i+"->");
				for(int adjacentVertex : currentVertexList) {
					System.out.print(adjacentVertex+"->");
				}
			} else {
				System.out.println(i);
			}
			System.out.println();
		}
	}
	
	boolean[] visited;
	
	public void dfsUtil() {
		// visited array should be initialized for every dfs traversal call
		visited = new boolean[countOfVertices];
		// this loop is needed to print all the disconnected components
		for(int i= 0; i < countOfVertices; i++) {
			dfs(i);
		}
	}
	
	/**
	 * DFS traversal is similar to preorder traversal of a binary tree
	 */
	private void dfs (int v) {
		if (visited[v]) {
			return;
		}
		System.out.println(v);
		visited[v] = true;
		for(int i= 0; i < countOfVertices; i++) {
			if(isEdgePresent(v, i)) {
				dfs(i);
			}
		}
	}
	
	/**
	 *  This method is only for test. It starts DFS from a specific vertex and only traverse the component
	 *  of which the vertex is a part. We should actually use the dfsUtil method for traversing the entire graph
	 * @param start
	 */
	public void dfsFromVertex (int start) {
		visited = new boolean[countOfVertices];
		dfs(start);
	}
	
	/**
	 * Checks if an edge is present from src to dst vertex
	 * @param src
	 * @param dst
	 * @return
	 */
	private boolean isEdgePresent (int src, int dst) {
		if (adjList[src].contains(dst)) {
			return true;
		}
		return false;
	}
}