package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BridgeDetection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numVer = sc.nextInt();
		int e = sc.nextInt();
		Graph graph = new Graph(numVer);

		for (int i = 1; i <= e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.addEdge(x - 1, y - 1);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numVer; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			list = (LinkedList<Integer>) graph.adjList[i].clone();
			for (Integer x : list) {
				boolean flag = graph.detectBridge(i, x);
				if (flag){
					if((map.containsKey(i+1) && map.get(i+1) == x+1) || (map.containsKey(x+1) && map.get(x+1) == i+1))
						continue;
					else
						map.put(i+1, x+1);
				}
			}
		}
		System.out.println(map);

		/*
		 * for (int i = 0; i < numVer; i++) {
		 * System.out.println(graph.adjList[i]); }
		 */

		/*
		 * 6 7 1 2 1 3 3 6 1 6 2 4 2 5 4 5
		 */
	}

	private static class Graph {
		int numVer;
		boolean isVisited[];
		LinkedList<Integer>[] adjList;
		LinkedList<Integer>[] newList;

		public Graph(int numVer) {
			this.numVer = numVer;
			adjList = new LinkedList[numVer];
			newList = new LinkedList[numVer];
			isVisited = new boolean[numVer];
			for (int i = 0; i < numVer; i++) {
				adjList[i] = new LinkedList<>();
				newList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int v1, int v2) {
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		public boolean detectBridge(int v1, int v2) {
			for (int i = 0; i < numVer; i++) {
				newList[i] = (LinkedList<Integer>) adjList[i].clone();
			}
			newList[v1].remove(new Integer(v2));
			newList[v2].remove(new Integer(v1));
			/*
			 * for (int i = 0; i < numVer; i++) {
			 * System.out.println(newList[i]); }
			 */
			int y=0;
			for (int i = 0; i < numVer; i++) {
				if(!newList[i].isEmpty()){
					y = newList[i].get(0);
					break;
				}
			}
			DFS(y);
			
			boolean flag = false;
			for (int i = 0; i < isVisited.length; i++) {
				if (isVisited[i] == false) {
					flag = true;
					break;
				}
			}
			Arrays.fill(isVisited, false);
			return flag;
		}

		public void DFS(int root) {
			Stack<Integer> stack = new Stack<>();
			stack.push(root);
			isVisited[root] = true;

			while (!stack.isEmpty()) {
				int vertex = stack.pop();
				for (Integer x : newList[vertex]) {
					if (!isVisited[x]) {
						stack.push(x);
						isVisited[x] = true;
					}
				}
			}
		}
	}
}
