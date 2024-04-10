import java.util.*;
import java.util.stream.*;

public class KrushalsMinSpanningTree {

	public static void main(String[] args) {

		int v=4, e = 5;

		Graph graph = new Graph(v,e);

		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;
		graph.edge[0].weight = 10;

		graph.edge[1].source = 0;
		graph.edge[1].destination = 2;
		graph.edge[1].weight = 6;

		graph.edge[2].source = 0;
		graph.edge[2].destination = 3;
		graph.edge[2].weight = 5;

		graph.edge[3].source = 1;
		graph.edge[3].destination = 3;
		graph.edge[3].weight = 15;

		graph.edge[4].source = 2;
		graph.edge[4].destination = 3;
		graph.edge[4].weight = 4;

		System.out.println("Min spanning tree of graph 1");

		minSpanningTree(graph);
	}

	private static void minSpanningTree(Graph graph) {

		Graph.Edge[] answer = new Graph.Edge[graph.vertex];

		int j=0; // for tracking the answer
		int i=0; // for tracking the index of sorted edges
		
		for(i=0; i<graph.vertex; ++i) answer[i] = new Graph.Edge();

		Arrays.sort(graph.edge);

		Graph.DisJointSets[] mySet = new Graph.DisJointSets[graph.vertex];

		for(i=0; i<graph.vertex; ++i) mySet[i] = new Graph.DisJointSets();

		// Creating Subsets
		for(int x=0; x < graph.vertex; ++x) {

			mySet[x].p = x;
			mySet[x].r = 0;
		}

		i=0;

		System.out.println("Before the loop");

		System.out.println("i -> " + i + ", j -> " + j + ", graph.vertex ->" + graph.vertex);

		System.out.println("In loop");

		while(j < graph.vertex - 1) {


			System.out.println("i -> " + i + ", j -> " + j + ", graph.vertex ->" + graph.vertex);
			// Picking the smallest edge
			Graph.Edge nextEdge = new Graph.Edge();

			nextEdge = graph.edge[i++];

			int temp1 = graph.find(mySet, nextEdge.source);
			int temp2 = graph.find(mySet, nextEdge.destination);

			// If cycle is not formed then include the edge in the answer[]
			if(temp1 != temp2) {

				answer[j++] = nextEdge;
				graph.merge(mySet, temp1, temp2);
			}
		}

		for(i=0; i<j; ++i) 
			System.out.println(answer[i].source + " , " + answer[i].destination);
	}
}


