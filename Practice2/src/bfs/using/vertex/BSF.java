package bfs.using.vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BSF {

	public static void main(String A[]){
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);
		
		vertex1.neighbors.add(vertex2);
		vertex2.neighbors.add(vertex3);
		vertex1.neighbors.add(vertex4);		
		vertex4.neighbors.add(vertex5);
		
		
		bfs(vertex1);
	}
	
	public static void bfs(Vertex root){
		
		//--It is an array(Queue Collection) of linked list nodes.
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(root);
		root.visited = true;
		
		while(!queue.isEmpty()){
			Vertex vertex = queue.poll(); // return and remove head of queue
			System.out.print(vertex.data + " ");
			
			for(Vertex v : vertex.neighbors){
				if(!v.visited){
					v.visited = true;
					queue.add(v);
				}
			}			
		}	
	}
}
