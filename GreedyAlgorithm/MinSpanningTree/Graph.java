import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {

	public static class Edge implements Comparable<Edge> {

		int source, destination, weight;

		// For sorting edges based on weight
		public int compareTo(Edge var) {

			return this.weight - var.weight;
		}
	};

	public static class DisJointSets {

		int p,r;
	}

	int vertex, edges;

	Edge[] edge;

	@SuppressWarnings("unchecked")
	public Graph(int v, int e) {

		this.vertex = v;
		this.edges = e;

		this.edge = new Edge[edges];

		Arrays.fill(this.edge, new Edge());
	}

	// function for finding a set of a given element
	int find(DisJointSets mySet[], int v) {

		//find root and make root as parent of i
		if(mySet[v].p != v) 
			mySet[v].p = find(mySet, mySet[v].p);

		return mySet[v].p;
	}

	// function for taking union of two sets
	void merge(DisJointSets mySet[], int i, int j) {

		int set_i = find(mySet,i);
		int set_j = find(mySet,j);

		if(mySet[set_i].r < mySet[set_j].r) mySet[set_i].p = set_j;
		else if (mySet[set_i].r > mySet[set_j].r) mySet[set_j].p = set_i;
		else {
			mySet[set_j].p=set_i;
			mySet[set_i].r++;
		}
	}
}

