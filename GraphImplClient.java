package JavaLearn;

import java.util.LinkedList;

public class GraphImplClient {
	public static void main(String[]args) {
		MyGraph mygraph = new MyGraph(5);
		mygraph.addEdge(0, 1);
		mygraph.addEdge(0, 4);
		mygraph.addEdge(1, 2);
		mygraph.addEdge(1, 3);
		mygraph.addEdge(2, 3);
		mygraph.addEdge(4, 2);
		mygraph.printAdjList();
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
}