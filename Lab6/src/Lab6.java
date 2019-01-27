import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Lab6 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		//Graph2 g = null;
		int m = 0,n = 0;
		try {
		n = Integer.parseInt(sc.nextLine()); // no of node
		m = Integer.parseInt(sc.nextLine()); // no of edges
		}
		catch(Exception e) {
			System.out.println("Wrong Input");
		}
		
		//int[][] adArray= new int[n][70]; // adjecency list
		int[][] ff = new int[n][2]; // input array
		String temp1[] = new String[2];
		
		Graph2 g = new Graph2(n);
		
		//input from user to int array
		for(int i = 0; i < m; i++) {
			String temp = sc.nextLine();
			temp1 = temp.split(" ");
			ff[i][0] = Integer.parseInt(temp1[0]);
			ff[i][1] = Integer.parseInt(temp1[1]);
			g.addEdge(ff[i][0], ff[i][1]);
		}
			System.out.println("MiddleBlock");
		
//		Set<Integer> nodes = new TreeSet<>();
//		for(int i = 0; i < m; i++) {
//			nodes.add(ff[i][0]);
//		}
		int count = 0;
		int isConnected = 0;
		String[] finalList = new String[n];
		int[] finalSumList = new int[n];
		for(int i = 0; i < n; i++) {
			g.BFS(i);
			//System.out.println(Graph2.shared);
			
			finalList[i] = g.shared;
			finalSumList[i]= g.sharedSum;
			g.sharedSum = 0;
			g.shared = "";
			g.BFSclean(i);
			
		}
		
		for(int i = 0; i < n-1; i++) {
			if(finalList[i].length() == finalList[i+1].length()) {
				if(finalSumList[i] == finalSumList[i+1]) {
					continue;
				}
				else
				{
					count++;
				}
			}else {
				count++;
			}
		}
		if(count == 0)
		{
			isConnected = 1;
		}
		else {
			isConnected = 0;
		}
		System.out.print(isConnected+" "+count);
		
		}}

class Graph2 {
	public String shared ="";
	public int sharedSum = 0;
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
		 adjacencyList[destination].add(src);
	}


	public void BFS(int source) {
		isVisited[source] = true;
		sourceToNodeDistance[source] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int element = queue.poll();
			shared += element;
			sharedSum+=element;
			adjacencyList[element].forEach(x -> {
				if (!isVisited[x]) {
					queue.add(x);
					isVisited[x] = true;
					sourceToNodeDistance[x] = sourceToNodeDistance[element] + 1;
				}
			});
		}
	}

	public void BFSclean(int source) {
		isVisited[source] = false;
		//sourceToNodeDistance[source] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int element = queue.poll();
			//Graph2.shared += element;
			adjacencyList[element].forEach(x -> {
				if (isVisited[x]) {
					queue.add(x);
					isVisited[x] = false;
					sourceToNodeDistance[x] = sourceToNodeDistance[element] + 1;
				}
			});
		}
	}
	
}
