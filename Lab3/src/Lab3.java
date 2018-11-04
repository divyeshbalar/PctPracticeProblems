import java.util.Scanner;
import java.util.Stack;

public class Lab3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tstring = sc.nextLine();
		//String knode = sc.nextLine();
		//int kdist = Integer.parseInt(sc.nextLine());
		
		//Node root = null;
		
		String treeS = new String();
		int len = tstring.length();
		
		
		//System.out.println(treeS.charAt(0)=='('?"Boom":"Shaka laka");
		//String Sanitization
		for(int i = 0; i< len-1; i++)
		{
			if(((tstring.charAt(i) == '(')&&(tstring.charAt(i+1) == ')')) || ((tstring.charAt(i) == ')')&&(tstring.charAt(i-1) == '('))) {
				continue;
			}
			else
			{
				treeS = treeS+tstring.charAt(i);
			}
		}
		System.out.println(treeS+" is sanitized tree string length = "+treeS.length());

		//remove open and close paranthasis
		len = treeS.length();
		treeS = treeS.substring(1, len);
		//treeS.deleteCharAt(len-2);
		System.out.println(treeS);
		//String ndata = new String(treeS.charAt(0)+"");
		//treeS.deleteCharAt(0);
		Node nd = Lab3.treeFromString(treeS, 0, len-1);
		//Lab3.preOrder(nd);
		Lab3.printLevelOrder(nd);
//		//find left
//		String nleft = Lab3.findleft(treeS);
//		System.out.println(nleft+" is left half");
//		//find right
//		String nright = Lab3.findright(treeS);
//		//Lab3.boomStr(root, ndata, nleft, nright);
// Node blueprint
		
	}
//	public static String findleft(String treeS) {
//		Stack<Integer> ff = new Stack<>();
//		int l = treeS.length();
//		int firstIndex = 0;
//		int lastIndex = 0;
//		for(int i = 0; i < l; i++)
//		{
//			if(treeS.charAt(i)=='(') {
//				ff.push(i);
//			}else if(treeS.charAt(i)==')') {
//				lastIndex = ff.peek();
//				System.out.println(ff.pop());
//				System.out.println(lastIndex);
//				if(ff.isEmpty() == true) {
//					return new String(treeS.subSequence(firstIndex, lastIndex));
//				}
//			}
//		}
//		return null;
//	}
	
	
	// functin to return the index of close parenthesis 
	static int findIndex(String str, int si, int ei) 
	{ 
	    if (si > ei) 
	        return -1; 
	  
	    // Inbuilt stack 
	    Stack<Character> s = new Stack<>(); 
	  
	    for (int i = si; i <= ei; i++) { 
	  
	        // if open parenthesis, push it 
	        if (str.charAt(i) == '(') 
	            s.push(str.charAt(i)); 
	  
	        // if close parenthesis 
	        else if (str.charAt(i) == ')') { 
	            if (s.peek() == '(') { 
	                s.pop(); 
	  
	                // if stack is empty, this is  
	                // the required index 
	                if (s.empty()) 
	                    return i; 
	            } 
	        } 
	    } 
	    // if not found return -1 
	    return -1; 
	} 
	 
	public static void preOrder(Node node) 
	{ 
	    if (node == null) 
	        return; 
	    System.out.print(node.data); 
	    preOrder(node.left); 
	    preOrder(node.right); 
	}
	public static Node treeFromString(String str, int si, int ei) 
	{ 
	    // Base case 
	    if (si > ei) 
	        return null; 
	  
	    // new root
	    String s = "";
	    int i = si;
	    while(str.charAt(i) != '(') {
	    	if(str.charAt(i) == ')') {
	    		break;
	    	}
	    	s = s + str.charAt(i);
	    	i++;
	    }
	    si = i-1;
	    
	    Node root = new Node(s);
	    s="";
	    int index = -1; 
	  
	    // if next char is '(' find the index of 
	    // its complement ')' 
	    if (si + 1 <= ei && str.charAt(si + 1) == '(') 
	        index = findIndex(str, si + 1, ei); 
	  
	    // if index found 
	    if (index != -1) { 
	  
	        // call for left subtree 
	        root.left = treeFromString(str, si + 2, index - 1); 
	  
	        // call for right subtree 
	        root.right = treeFromString(str, index + 2, ei - 1); 
	    } 
	    return root; 
	} 
	
	
	
//	public static String findright(String treeS) {
//		Stack<Integer> ff = new Stack<>();
//		int l = treeS.length();
//		return null;
//	}
	public static class Node{
		String data;
		Node right = null, left = null;
		public Node(String data) {
			super();
			this.data = data;
		}
		public Node(String data, Node right, Node left) {
			super();
			this.data = data;
			this.right = right;
			this.left = left;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}
//	
//	private Node addRecursive(Node current, String value) {
//	    if (current == null) {
//	        return new Node(value);
//	    }
//	 
//	    if () {
//	        current.left = addRecursive(current.left, value);
//	    } else if () {
//	        current.right = addRecursive(current.right, value);
//	    } else {
//	        // value already exists
//	        return current;
//	    }
//	 
//	    return current;
//	}
//	public static <String> String boomStr(Node rt, String data, String lfdata, String rtdata) {
//		
//		return "Done";
//	}
	public static void printLevelOrder(Node root) 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    }
 public static void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
public static int height(Node root) 
{ 
    if (root == null) 
       return 0; 
    else
    { 
        /* compute  height of each subtree */
        int lheight = height(root.left); 
        int rheight = height(root.right); 
          
        /* use the larger one */
        if (lheight > rheight) 
            return(lheight+1); 
        else return(rheight+1);  
    } 
}
}
