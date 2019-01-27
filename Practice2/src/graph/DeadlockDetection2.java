package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeadlockDetection2 {

	public static void main(String[] args) throws IOException {
		/*
		 * 5 101 7 8 101 9 -1 102 -1 7 102 8 -1 103 -1 9
		 */
		Map<Integer, Integer> location = new HashMap<Integer, Integer>();
		int count = 0;
		Graph3 graph = new Graph3();
		
//		FileReader fileReader = new FileReader("test.txt");
//
//		BufferedReader br = new BufferedReader(fileReader);
//		int numberOfLines = Integer.parseInt(br.readLine());
		
		FileReader fileReader = new FileReader("test.txt");

		BufferedReader br = new BufferedReader(fileReader);
		int numberOfLines = Integer.parseInt(br.readLine());
		while (numberOfLines-- != 0) {
			int X = 0;
			int Ri = 0;
			int Rj = 0;
			String a = br.readLine();
			if (location.containsKey(Integer.parseInt(a.split(" ")[0]))) {
				X = location.get(Integer.parseInt(a.split(" ")[0]));
			} else {
				if (Integer.parseInt(a.split(" ")[0]) == -1) {
					X = -1;
				} else {
					X = count;
					location.put(Integer.parseInt(a.split(" ")[0]), X);
					count++;
				}

			}
			if (location.containsKey(Integer.parseInt(a.split(" ")[1]))) {
				Ri = location.get(Integer.parseInt(a.split(" ")[1]));
			} else {
				if (Integer.parseInt(a.split(" ")[1]) == -1) {
					Ri = -1;
				} else {
					Ri = count;
					location.put(Integer.parseInt(a.split(" ")[1]), Ri);
					count++;
				}

			}
			if (location.containsKey(Integer.parseInt(a.split(" ")[2]))) {
				Rj = location.get(Integer.parseInt(a.split(" ")[2]));
			} else {
				if (Integer.parseInt(a.split(" ")[2]) == -1) {
					Rj = -1;
				} else {
					Rj = count;
					location.put(Integer.parseInt(a.split(" ")[2]), Rj);
					count++;
				}
			}

			System.out.println(X + " " + Ri + " " + Rj);
			if (Ri != -1) {
				graph.addEdge(Ri, X);
			}
			if (Rj != -1) {
				graph.addEdge(X, Rj);
			}

		}

		graph.printGraph();
		System.out.println(graph.isDeadlock(location.size()));

	}

}

class Graph3 {
	LinkedList<Integer> adjancyList[] = new LinkedList[50];
	boolean isVisited[] = new boolean[50];
	Colors colors[] = new Colors[50];

	public Graph3() {
		for (int i = 0; i < 50; i++) {
			adjancyList[i] = new LinkedList<Integer>();
			colors[i] = Colors.White;
		}
	}

	public void addEdge(int src, int destination) {
		adjancyList[src].add(destination);
	}

	public void printGraph() {
		for (int i = 0; i < 50; i++) {
			if (adjancyList[i].size() == 0) {
				break;
			} else {
				System.out.println(i + " my neibhours are");
				adjancyList[i].forEach(x -> {
					System.out.print(x + " ");
				});
				System.out.println();
			}
		}
	}

	public boolean isDeadlock(int numberOfVertices) {
		return isCycle(0);

	}

	public boolean isCycle(int src) {
		colors[src] = Colors.Grey;
		Iterator<Integer> iterator = adjancyList[src].iterator();
		while (iterator.hasNext()) {
			int element = iterator.next();
			if (colors[element] == Colors.Grey) {
				return true;
			} else if (colors[element] == Colors.White && isCycle(element)) {
				return true;
			}
		}

		colors[src] = Colors.Black;
		return false;
	}

	enum Colors {
		White, Grey, Black
	}
}
