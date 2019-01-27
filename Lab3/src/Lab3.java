import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Lab3 {

	public static void main(String[] args) {
		
		
		
		//Init section 
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String Knode = sc.nextLine();
		int dist = Integer.parseInt(sc.nextLine());
		Node root = null;
		int len = str.length();
		System.out.println("String: "+ str +"\nK-node: "+ Knode+"\nDist from K: "+ dist);
		Stack<String> sta = new Stack<>();
		//
		
		ArrayList<String> strArr = new ArrayList<>();
		int i =0;
		for(i = 0; i < len-1; i++);
		{
			if(str.charAt(0) == '(' && str.charAt(1) == ')') {
				//skip
			}
			strArr.add(str.charAt(i)+"");
		}
	}
	
	public Node parseTreeString(String dataStr) {
		
		return null;
	}
	
	
	//------------------------Node Blueprint-------------------------------------------//
	class Node{
		
		String name;
		Node left, right;
		
		public Node(String name, Node left, Node right) {
			super();
			this.name = name;
			this.left = left;
			this.right = right;
		}

		public Node(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	//----------------------------------------------------------------------------------//

}
