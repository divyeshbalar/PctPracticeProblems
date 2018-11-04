import java.util.Scanner;
import java.util.Stack;



public class Prob3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String postStr = sc.nextLine();
		String[] nodeArr = postStr.split(" ");
		int len = nodeArr.length;
		for(String s: nodeArr) {
			System.out.println(s);
		}
		
		Node nd = Prob3.treeFromString(nodeArr, len-1, 0);
		Prob3.printPreorder(nd);
		
	}
	
	public static Node treeFromString(String[] nodeArr, int si, int ei) {
		if (si < ei) 
	        return null; 
		String s = nodeArr[si];
		Node root = new Node(s);
		int index = -1; 
		  
	    // if next char is '(' find the index of 
	    // its complement ')' 
	    if (si - 1 >= ei) 
	        index = findIndex(nodeArr, si - 1, ei); 
	  
	    // if index found 
	    if (index != -1) { 
	  
	        // call for left subtree 
	    	
	        root.left = treeFromString(nodeArr, index, ei); 
	    	
	        // call for right subtree 
	        root.right = treeFromString(nodeArr, si - 1, index - 1);
	    } 
	    return root; 
		
	}

	
		
	public static int findIndex(String[] nodeArr, int si, int ei) {
		int k = 0;
		for(int i = si; i >= ei; i--) {
			if(Integer.parseInt(nodeArr[si+1])<=Integer.parseInt(nodeArr[i])) {
				k++;
			}
			else
			{
				System.out.println("Value of K = "+k);
				if(k == 0) {
					return -1;
				}
				else {
				return k;
				}
			}
		}
		return -1;
	}

	public static void printPreorder(Node node)
	{
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}


	public static class Node{
		String data;
		Node left = null, right = null;
		public Node(String data) {
			this.data = data;
		}
		public Node(String data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
}


