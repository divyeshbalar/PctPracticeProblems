import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class GraphConnected {
	
	

	public static void main(String[] args) {
		
	Graphq graphq = new Graphq(9);
	Set<ArrayList<Integer>> connectednodes = new LinkedHashSet<ArrayList<Integer>>();
	Set<ArrayList<Integer>> strongconnected = new LinkedHashSet<ArrayList<Integer>>();
	
	graphq.adjcent[1].add(0);
	
	graphq.adjcent[0].add(2);
	graphq.adjcent[2].add(1);
	graphq.adjcent[5].add(4);
	graphq.adjcent[3].add(1);
	graphq.adjcent[3].add(5);
	graphq.adjcent[4].add(3);
	graphq.adjcent[6].add(4);
	graphq.adjcent[6].add(8);
	graphq.adjcent[8].add(7);
	graphq.adjcent[7].add(6);
	
	
	
	/*Graph graph = new Graph(5);
	graph.adjcent[0].add(1);
	graph.adjcent[1].add(0);
	graph.adjcent[1].add(2);
	graph.adjcent[2].add(1);
	graph.adjcent[3].add(4);
	graph.adjcent[4].add(3);*/
	
	
	
	for(int i=0;i<graphq.noofvertices;++i)
		
		
	{
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		if(visited.contains(i))
		{
			System.out.println("there is a cycle");
			break;
			
		}
		     graphq.DFS(i,visited);
		
	    //System.out.println(visited);
	    Collections.sort(visited);
	 
		     
	/* if(visited.size()>=graph.noofvertices)
		 
	 {
		System.out.println(i);
		 
	 }*/
		 
	  connectednodes.add(visited);
	}
	
	//System.out.println(connectednodes);
	
	
	for(ArrayList<Integer> al : connectednodes)
		
	{   
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2 = graphq.stronglyconnected(al);
		strongconnected.add(temp2);
	}
	
	ArrayList<String> strongconnected2 = new ArrayList<String>();
	
	for(ArrayList<Integer> al : strongconnected)
			
		{   
			
			strongconnected2.add(al.toString());
		}
	
	Collections.sort(strongconnected2);
	for(String al : strongconnected2)
		
	{   
		System.out.println(al);
		
		
	}
	
	
	
	
	/*int core = 2;

	for(int i=0;i<graph.noofvertices;++i)
	
	{
		
		if(graph.adjcent[i].size() <= core)
			
		{
			
			graph.queue.add(i);
		}
		
		
		
	}
		
	
	graph.kcorecomponents(core,graph.queue);*/
	
	}
}

class Graphq

{
	
 int noofvertices;
 LinkedList<Integer> adjcent[];
 LinkedList<Integer> queue = new LinkedList<Integer>();
 
	 Graphq(int noofvertices2)
	 {
		 noofvertices = noofvertices2;
		 
		 adjcent = new LinkedList[noofvertices]; 
		 
		 for (int i=0; i<noofvertices; ++i) 
			 adjcent[i] = new LinkedList();
		 
	 }

	public void DFS(int i, ArrayList<Integer> visited) {
		
		
		visited.add(i);
	   
		
	     Iterator it = adjcent[i].iterator();
	     
	      while(it.hasNext())
	    	 
	     {  
	    	 int n=(int) it.next();
	    	 
	    	
	    	 if(!visited.contains(n))
	    	 {
	    		
	    		 
	    		 DFS(n,visited);
	    		 
	    	 }
	    	 
	     }
	     
	}
	
	
	public ArrayList<Integer> stronglyconnected(ArrayList<Integer> connectedlist)
	
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Collections.sort(connectedlist);
		
		
		
		for(int i : connectedlist)
			
		{
			
			ArrayList<Integer> visited = new ArrayList<Integer>();
			
			DFS(i,visited);
			Collections.sort(visited);
			
			
			
			if(visited.equals(connectedlist))
			{
				temp.add(i);
			}
				
		}
		
		
		
		return temp;
	}
	


/*	public void kcorecomponents(int core,LinkedList<Integer> queue)
	
	{
		//System.out.println(queue);
		
		Set<Integer> elementstoberemoved = new LinkedHashSet<Integer>();
		
		while(!queue.isEmpty())
			
		{
				int first_element = queue.poll();
				
				
				elementstoberemoved.add(first_element);
					
				 for (int i=0; i<noofvertices; ++i) 
				 {
					 
					 
						 if(adjcent[i].contains(first_element))
							 
						 {
						 int index= adjcent[i].indexOf(first_element);
						 
						 adjcent[i].remove(index);
						 
						 
						 if(adjcent[i].size()<=2)
							 
						 {
							 if(!elementstoberemoved.contains(i)||!queue.contains(i))
							 {
								 System.out.println("adding......"+i);
								 
							         queue.add(i);
							 }
						 }
						 
						 
						 
					 }
					 
					 
				 }
		
		}
		
		
		System.out.println(elementstoberemoved);
	}*/


}
