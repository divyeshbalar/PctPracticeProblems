package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DeadlockDetection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, ArrayList<Integer>> graphMap = new HashMap<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		Graph graph = new Graph(50);
		int n = sc.nextInt();

		int k = 0;
		for (int i = 0; i < n; i++) {
			int ip1 = sc.nextInt();
			int ip2 = sc.nextInt();
			int ip3 = sc.nextInt();
			int X = 0, Ri = 0, Rj = 0;
			if (map.containsKey(ip1))
				X = map.get(ip1);
			else {
				X = k;
				map.put(ip1, k);
				k++;
			}

			if (map.containsKey(ip2))
				Ri = map.get(ip2);
			else if (ip2 != -1 && !map.containsKey(ip2)) {
				Ri = k;
				map.put(ip2, k);
				k++;
			}

			if (map.containsKey(ip3))
				Rj = map.get(ip3);
			if (ip3 != -1 && !map.containsKey(ip3)) {
				Rj = k;
				map.put(ip3, k);
				k++;
			}

			if (ip1 != -1 && ip2 != -1)
				graph.addEdge(Ri, X);
			if (ip1 != -1 && ip3 != -1)
				graph.addEdge(X, Rj);

		}

		graph.printGraph();
		System.out.println(graph.detectCycleDirected(0));

	}

	private static class Graph {
		int numVer;
		LinkedList<Integer>[] adjList;
		boolean isVisited[];
		boolean inStack[];

		public Graph(int numVer) {
			this.numVer = numVer;
			adjList = new LinkedList[numVer];
			isVisited = new boolean[numVer];
			inStack = new boolean[numVer];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int src, int dest) {
			adjList[src].add(dest);
		}

		public void printGraph() {
			for (int i = 0; i < 50; i++) {
				if (adjList[i].size() == 0) {
					break;
				} else {
					System.out.println(i + " " + adjList[i]);
				}
			}
		}

		public void DFS(int root) {
			Stack<Integer> stack = new Stack<>();
			stack.push(root);
			isVisited[root] = true;

			while (!stack.isEmpty()) {
				int vertex = stack.pop();
				System.out.print((vertex + 1) + " ");

				for (Integer x : adjList[vertex]) {
					if (!isVisited[x]) {
						stack.push(x);
						isVisited[x] = true;
					}
				}
			}
		}

		public boolean detectCycleDirected(int root) {
			Stack<Integer> stack = new Stack<>();
			stack.push(root);
			isVisited[root] = true;
			inStack[root] = true;

			while (!stack.isEmpty()) {
				int vertex = stack.pop();

				for (Integer x : adjList[vertex]) {
					if (inStack[x])
						return true;
					if (!isVisited[x]) {
						stack.push(x);
						inStack[x] = true;
						isVisited[x] = true;
					}
					LinkedList<Integer> list = adjList[x];
					boolean flag = true;
					for (Integer y : list) {
						if (!isVisited[y])
							flag = false;
					}
					if (flag)
						inStack[x] = false;
				}
			}
			return false;
		}

	}

}
