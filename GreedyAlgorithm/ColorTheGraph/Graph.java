import java.util.*;
import java.io.*;

public class Graph {

	private int vertices;

	private LinkedList<Integer>[] adjacencyList;

	// Constructor
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {

		this.vertices = vertices;
		this.adjacencyList = new LinkedList[this.vertices];

		Arrays.fill(this.adjacencyList, new LinkedList());
	}

	public void addEdge(int source, int destination) {

		this.adjacencyList[source].add(destination);
		this.adjacencyList[destination].add(source);
	}

	public int getVertices() { return this.vertices; }

	public LinkedList<Integer>[] getAdj() { return this.adjacencyList; }
}


