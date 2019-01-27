import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;
	import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

	public class GraphProb {
		static int gg = 0;
static String[] orderedString = new String[26]; 
		public static void main(String A[]) {
			Scanner sc = new Scanner(System.in);
			
			int n, edge;
			String rot = "";
			n = Integer.parseInt(sc.nextLine())-1;
			System.out.println(n+" ==> N-1");
			Graph g = new Graph(25);
			if(n<2) {
				return;
			}
			else {
		
				String[] temp = new String[3];
				for(int i = 0; i < n; i++) {
					String xx = sc.nextLine();
					temp = xx.split(" ");
					g.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
					if(i == 0) {
						rot = temp[0];
					}
				}
				System.out.println(g);
				
				g.BFS(rot);
						
			}

		}	
	}

	class Graph {
		
		public class Edge{
			String u, v;
			int w;
			public Edge(String u, String v, int w) {
				super();
				this.u = u;
				this.v = v;
				this.w = w;
			}
			@Override
			public String toString() {
				return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
			}
			
		}
		int numVer;
		LinkedList<Edge>[] adjList;
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

		@Override
		public String toString() {
			return "Graph [adjList=" + Arrays.toString(adjList) + "]";
		}

		public void addEdge(String src, String dest, int w) {
			
			adjList[(int)(src.charAt(0))-65].add(new Edge(src, dest, w));
		}

		public void BFS(String root) {
			Queue<String> queue = new LinkedList<>();
			queue.add(root);
			isVisited[((int)(root.charAt(0)))-65] = true;

			while (!queue.isEmpty()) {
				String vertex = queue.poll();
				System.out.print(vertex + " ");
				GraphProb.orderedString[GraphProb.gg] = vertex;
				
				GraphProb.gg++;
				for (Edge x : adjList[((int)vertex.charAt(0)-65)]) {
					if (!isVisited[(int)x.v.charAt(0)-65]) {
						queue.add(x.v);
						isVisited[(int)x.v.charAt(0)-65] = true;
					}
				}
				
				/*for(String q: queue) {
					System.out.println(q);
				}*/
				//System.out.println("End "+GraphProb.gg);
			}
		}



	}

