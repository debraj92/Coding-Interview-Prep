package JavaLearn;

import java.util.Arrays;

/**
 * Myntra Interview
 * Determine if a network topology is BUS, RING, STAR or OTHER
 *
 *	Bus : a->b->c->d->e
 *  Ring : 
 *          a --> b
 *          ^     |
 *          |     |
 *          |     V
 *          d <-- c
 *  Star :     
 *               e
 *               |
 *               V
 *          a -> b <- c
 *               ^
 *               |
 *               d
 *               
 *  Other :
 *          i -> e <- h <- g
 *               |         ^
 *               V         |
 *          a -> b -> c -> f
 *               ^
 *               |
 *               d
 */
public class NetworkTopology {
	
	static NetworkTopologyDetector topologyDetector;
	public static void main(String [] args) {
		topologyDetector = new NetworkTopologyDetector(7);
		useTopologyBus();
		useTopologyRing();
		useTopologyStar();
		useTopologyRandom1();
		useTopologyRandom2();
		useTopologyRandom3();
	}
	
	public static void useTopologyBus() {
	    int[] start = new int[] {0,1,2,3,4,5,6};
	    int[] end = new int[] {4,0,3,1,6,-1,5};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Bus? "+(topologyDetector.detectTopology() == 0));
	}
	
	public static void useTopologyRing() {
		int[] start = new int[] {0,1,3,5,2,4,6};
	    int[] end = new int[] {2,5,1,0,4,6,3};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Ring? "+(topologyDetector.detectTopology() == 1));
	}
	
	public static void useTopologyStar() {
		int[] start = new int[] {0,1,2,3,4,5,6};
	    int[] end = new int[] {3,3,3,-1,3,3,3};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Star? "+(topologyDetector.detectTopology() == 2));
	}
	
	public static void useTopologyRandom1() {
		int[] start = new int[] {0,1,2,3,4,5,6};
	    int[] end = new int[] {1,2,3,4,2,6,-1};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Other? "+(topologyDetector.detectTopology() == -1));
	}
	
	public static void useTopologyRandom2() {
		int[] start = new int[] {0,1,2,3,4,5,6};
	    int[] end = new int[] {1,2,-1,2,2,3,5};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Other? "+(topologyDetector.detectTopology() == -1));
	}
	
	public static void useTopologyRandom3() {
		int[] start = new int[] {0,1,2,3,4,5,6};
	    int[] end = new int[] {1,6,1,1,1,1,-1};
	    topologyDetector.creatGraph(start, end, 7);
	    System.out.println("is Other? "+(topologyDetector.detectTopology() == -1));
	}

}

class NetworkTopologyDetector {
	
	/**
	 * Notice for this particular problem we can represent the graph just using a single array
	 *  
	 *  Say the graph is : 0 -> 1 -> 2 -> 3
	 *  
	 *  Then the graph array would be : [1, 2, 3, -1]. The 0th vertex is connected to 1st vertex and 1st 
	 *  to 2nd vertex etc. The last vertex is connected to none, so we use -1. 
	 *  This is a specific case of matrix representation of graphs.
	 */
	
	private int[] graph;
	private int numVertices;
	
	NetworkTopologyDetector(int n) {
		numVertices = n;
		graph = new int[numVertices];
	}
	
	/**
	 * Construct the graph
	 * 
	 * @param start represents the starting vertex of each edge
	 * @param end represents the ending vertex of each edge
	 * @param m represent the number of edges
	 */
	public void creatGraph(int[] start, int[] end, int m) {
		Arrays.fill(graph, -1);
		for (int i=0; i<m; i++) {
			graph[start[i]] = end[i];
		}
	}
	
	/**
	 * Detect the topology of the network
	 * @return 0 if Bus, 1 if Ring, 2 if Star
	 */
	public int detectTopology() {
		
		/**
		 * If all the vertices have the same end vertex except 1, then it is a star. The one whose end vertex 
		 * is different should have value -1
		 */
		// find the vertex with no connection. In the process if we find more than two vertices are connected 
		// to different end vertex then this is not star
		boolean isStar = true;
		int countOfDifferentEndVertex=0;
		int currentEndVertex = -2;
		// this will store the central vertex in star topology that has no out going connection
		int vertexWithNoOutEdge = -1;
		for (int i=0; i<numVertices; i++) {
			if (graph[i] == -1) {
				vertexWithNoOutEdge = i;
				break;
			}
			if(graph[i] != currentEndVertex) {
				currentEndVertex = graph[i];
				countOfDifferentEndVertex++;
				if(countOfDifferentEndVertex==3) {
					isStar = false;
					break;
				}
			}
			
		}
		// we need to ensure the central vertex is also set in the above loop
		isStar = isStar && vertexWithNoOutEdge != -1;
		if(isStar) {
			// verify if all the end vertices are = vertexWithNoOutEdge except the vertexWithNoOutEdge
			for (int i=0; i<numVertices; i++) {
				if(i!=vertexWithNoOutEdge && graph[i] != vertexWithNoOutEdge) {
					isStar = false;
					break;
				}
			}
		}
		
		if(isStar) {
			return 2;
		}
		
		// for ring, we can start from any vertex and will reach the same vertex. However in the process we
		// must have visited all the vertices
		boolean[] visited = new boolean[numVertices];
		Arrays.fill(visited, false);
		int startVertex = 0;
		visited[0] = true;
		startVertex = graph[0];
		while(startVertex != -1 && !visited[startVertex]) {
			visited[startVertex] = true;
			startVertex = graph[startVertex];
		}
		if(startVertex != -1) {
			// may be ring
			// If ring then all vertices must be visited in the above loop
			boolean isRing = true;
			for(boolean vertexVisted: visited) {
				if(!vertexVisted) {
					isRing = false;
					break;
				}
			}
			if(isRing) {
				return 1;
			}
		}
		
		// for bus we will first find the vertex which is the starting of the bus. Notice this is 
		// the vertex which is not an end vertex of any other vertex.
		boolean[] hasEndVertex = new boolean[numVertices];
		Arrays.fill(hasEndVertex, false);
		for (int i=0; i<numVertices; i++) {
			// -1 is not a end vertex
			if(graph[i] == -1) continue;
			if(hasEndVertex[graph[i]]) {
				// multiple vertices have the same end vertex. Not a bus
				return -1;
			} else {
				hasEndVertex[graph[i]] = true;
			}
		}
		// the start vertex is the one which no end vertex
		startVertex = -1;
		for (int i=0; i<numVertices; i++) {
			if(!hasEndVertex[i]) {
				startVertex = i;
				break;
			}
		}
		// finally we have to see if all the vertices can be visited by starting from the start vertex
		if(startVertex != -1) {
			Arrays.fill(visited, false);
			while(startVertex != -1 && !visited[startVertex]) {
				visited[startVertex] = true;
				startVertex = graph[startVertex];
			}
			// check if all vertices are visited
			for(boolean vertexVisted: visited) {
				if(!vertexVisted) {
					return -1;
				}
			}
			return 0;
		}
		
		// some other topology
		return -1;
	}
}
