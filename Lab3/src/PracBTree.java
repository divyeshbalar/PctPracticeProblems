import java.util.LinkedList;
import java.util.Queue;

public class PracBTree {
	
	static class Node{
		String data;
		int height;
		Node left=null, right=null;
	
		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Node(String data) {
			super();
			this.data = data;
		}

		public Node(String data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
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
	
	public static class Btree{
		Node root;
		//public static int ht = 0;
		
		private Node addNodeRec(Node root, String val) {
			if(root == null) {
				return new Node(val);
			}
			else {
				if(root.right == null) {
					root.right = addNodeRec(root.right, val);
				}
				else{
					root.left=addNodeRec(root.left, val);
				}
				return root;
			}
		}
		
		public Node addNode(String val) {
			root = addNodeRec(root, val);
			return root;
		}
		
		
		
		private boolean containsRec(Node root, String val) {
			if(root == null) {
				return false;
			}
			if(root.data.equals(val)) {
				return true;
			}
			return containsRec(root.left, val) | containsRec(root.right, val);
		}
		
		public boolean Iscontains(String val) {
			return containsRec(root, val);
		}
		
//		private Node deleteRec(Node root, String val) {
//			if(root == null) {
//				return null;
//			}
//			if(root.data.equals(val)) {
//				
//			}
//		}
		
		public void traverseInOrder(Node node) {
		    if (node != null) {
		        traverseInOrder(node.left);
		        System.out.print(" " + node.data);
		        traverseInOrder(node.right);
		    }
		}
		
		public void traversePreOrder(Node root) {
			if(root != null) {
				System.out.println(" "+root.data);
				traversePreOrder(root.left);
				traversePreOrder(root.right);
			}
		}
		
		public void traversePostOrder(Node root) {
			if(root != null) {
				traversePostOrder(root.left);
				traversePostOrder(root.right);
				System.out.println(root.data);
			}
		}
		
		
		public void traverseLevelOrder() {
		    if (root == null) {
		        return;
		    }
		 
		    Queue<Node> nodes = new LinkedList<>();
		    nodes.add(root);
		 
		    while (!nodes.isEmpty()) {
		 
		        Node node = nodes.remove();
		 
		        System.out.print(" " + node.data);
		 
		        if (node.left != null) {
		            nodes.add(node.left);
		        }
		 
		        if (node.right!= null) {
		            nodes.add(node.right);
		        }
		    }
		}

	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Btree bt = new Btree();
		bt.addNode("Divyesh");
		bt.addNode("D");
		bt.addNode("i");
		bt.addNode("v");
		bt.addNode("y");
		bt.addNode("e");
		bt.addNode("s");
		bt.addNode("h");
		
		System.out.println(bt.Iscontains("X"));
		bt.traverseLevelOrder();
	}

}
