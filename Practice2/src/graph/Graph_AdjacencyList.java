package graph;

import java.util.LinkedList;
import java.util.*;
import java.util.stream.*;

public class Graph_AdjacencyList {

	public static void main(String[] args) {

		Graph2 g = new Graph2(6);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		g.addEdge(5, 5);
		g.addEdge(2, 1);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
		g.DFS(0);

		for (int i = 0; i < 6; i++)
			if (!g.isVisited[i])
				g.DFS(i);
		System.out.println("\n");
		// g.printSourceToNodeDistance();
		System.out.println("\n");
		// g.printisVisited();
	}

}

class Graph2 {
	LinkedList<Integer> adjacencyList[];
	int[] sourceToNodeDistance;
	boolean[] isVisited;

	public Graph2(int v) {
		adjacencyList = new LinkedList[v];
		sourceToNodeDistance = new int[v];
		isVisited = new boolean[v];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int destination) {
		adjacencyList[src].add(destination);
		// In case of undirected graph only
		// adjacencyList[destination].add(src);
	}

	public void printGraph() {
		for (int v = 0; v < adjacencyList.length; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : adjacencyList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public void BFS(int source) {
		isVisited[source] = true;
		sourceToNodeDistance[source] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int element = queue.poll();
			System.out.println(element + " ");
			adjacencyList[element].forEach(x -> {
				if (!isVisited[x]) {
					queue.add(x);
					isVisited[x] = true;
					sourceToNodeDistance[x] = sourceToNodeDistance[element] + 1;
				}
			});
		}
	}

	public void DFS(int src) {
		Stack<Integer> stack = new Stack<Integer>();
		isVisited[src] = true;
		stack.push(src);

		while (!stack.isEmpty()) {
			int element = stack.pop();
			System.out.println(element + " ");

			adjacencyList[element].forEach(x -> {
				if (!isVisited[x]) {
					stack.push(x);
					isVisited[x] = true;
				}
			});
		}
	}

	public void printSourceToNodeDistance() {
		Arrays.stream(sourceToNodeDistance).forEach(System.out::println);
	}

	public void printisVisited() {
		IntStream.range(0, isVisited.length).mapToObj(idx -> isVisited[idx]).forEach(System.out::println);
	}
}
