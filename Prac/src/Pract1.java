import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Pract1 {

	public static void main(String[] args) throws Exception {
		
		
		File f = new File("Temp.txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("Booommmmmmm");
		
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		String str = dis.readUTF();
		System.out.println(str);
		
		int ee = "divyesh".hashCode();
		
		System.out.println(ee+"           llllllllllll");
		String s = "dfg+dfg+df+gdf+gd+++dfg+dfg+sd";
		for (String retval: s.split("++")) {
			 
		     System.out.println(retval);
		     
		  }
		System.out.println(s.length());
	    System.out.println(s);
	    
	    /**
	     * Undirected Graph: For every visited 'V', if theres an adjecent 'U' such that 
	     * 'U' is already visite AND 'U' is not parent of 'V' then theres a Undirected cycle
	     * (If adjecent is visited and not parent of current vertex then theres cycle;)
	     * 
	     * 
	     *   
	     *   Directed Graph: For every V, if theres an edge thats from itself or from its 
	     *   one of the anscestor called backedge
	     *   (if the node is visited and in the recursion stack(both are boolean flag array of size (number of vertex)))
	     *
	     *...............................................Recursion.............................................
	     *public int bunnyEars(int bunnies) {
			  int x = bunnies;
			  if(x == 0)
			  {
			    return 0;
			  }
			  else
			  {
			    return 2+bunnyEars(x-1);
			  }
			}

	     *
	     *
	     *
	     */

	}

}
