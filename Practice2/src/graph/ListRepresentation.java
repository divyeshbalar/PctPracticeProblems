package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ListRepresentation {

	public static void main(String A[]) {
		Scanner sc = new Scanner(System.in);
		int numVer, edge;
		numVer = sc.nextInt();
		edge = sc.nextInt();

		Graph graph = new Graph(numVer);

		for (int i = 1; i <= edge; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.addEdge(x - 1, y - 1);
		}
		/*graph.BFS(0);
		Arrays.fill(graph.isVisited, false);
		System.out.println();
		graph.DFS(0);*/
		System.out.println(graph.detectCycleDirected(0));
	}	
}

class Graph {

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

	public void BFS(int root) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		isVisited[root] = true;

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print((vertex + 1) + " ");

			for (Integer x : adjList[vertex]) {
				if (!isVisited[x]) {
					queue.add(x);
					isVisited[x] = true;
				}
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
		
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
						
			for(Integer x : adjList[vertex]) {
				if(inStack[x])
					return true;
				if (!isVisited[x]) {
					stack.push(x);					
					inStack[x] = true;
					isVisited[x] = true;
				}
				LinkedList<Integer> list = adjList[x];
				boolean flag = true;
				for(Integer y : list){
					if(!isVisited[y])
						flag=false;
				}
				if(flag)
					inStack[x] = false;				
			}			
		}
		return false;		
	}
}


