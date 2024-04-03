import java.util.*;
import java.util.stream.*;

public class ColorTheGraph {

	public static void main(String[] args) {

		Graph g1 = new Graph(5);
		g1.addEdge(0,1);
		g1.addEdge(0,2);
		g1.addEdge(1,2);
		g1.addEdge(1,3);
		g1.addEdge(2,3);
		g1.addEdge(3,4);

		greedyColoring(g1);

	}

	private static void greedyColoring(Graph g1) {

		int noOfVertices = g1.getVertices();
		int[] result = new int[noOfVertices];

		// fill the arrays with default value
		Arrays.fill(result, -1);

		// Assign first color to first vertex
		result[0] = 0;

		boolean[] available = new boolean[noOfVertices];
		
		// Assign colors to remaining V-1 vertices
		Arrays.fill(available,true);

		LinkedList<Integer>[] vertexList = g1.getAdj();

		for(int i=1; i<noOfVertices; i++) {

			Iterator<Integer> var = vertexList[i].iterator();
			while(var.hasNext()) {

				int temp = var.next();

				// Find the first availalble color
				if(result[temp] != -1) {

					available[result[temp]] = false;
				}
			}

			int j;
			for(j=0; j<noOfVertices; j++) {

				if(available[j]) {
					break;
				}
			}

			// Assign the found color
			result[i] = j;

			// Reset the values
			Arrays.fill(available, true);
		}

		for(int i=0; i<noOfVertices; i++) {

			System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
		}
	
	}
}
