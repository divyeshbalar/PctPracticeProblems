package bfs.using.vertex;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	int data;
	boolean visited;
	List<Vertex> neighbors;
	
	public Vertex(int data){
		this.data = data;
		neighbors = new ArrayList<>();
		visited = false;
	}
	
}
