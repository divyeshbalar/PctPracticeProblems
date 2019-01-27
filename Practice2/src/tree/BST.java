package tree;

import java.util.Scanner;

import tree.Tree.Node;

public class BST {
	public static void main(String A[]) {
		Tree tree = new Tree();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 8; i++) {
			int x = sc.nextInt();
			tree.insert(x);
		}
		tree.traversal();
		// System.out.println();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Node lca = tree.lca(tree.root, n1, n2);
		System.out.println(lca.data);

	}
}

class Tree {
	
//----------------------------------Empty node fermo--------------- 
	class Node {

		int data;
		Node left;
		Node right;
		// Node parent;

		public Node(int data) {
			this.data = data;
		}
	}
	Node root; // root node initialization
//----------------Insert new key or value in tree------------
	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			insertNode(root, data);
		}
	}
//---------------------- Inserting a node left or right recursively--------------------------------
	public void insertNode(Node curr, int data) {
		if (data < curr.data) {
			if (curr.left != null) {
				insertNode(curr.left, data);
			} else {
				Node left = new Node(data);
				curr.left = left;
			}
		} else {
			if (curr.right != null) {
				insertNode(curr.right, data);
			} else {
				Node right = new Node(data);
				curr.right = right;
			}
		}
	}
	
//----------------Traversal-----------------------------------------

	public void traversal() {
		if (root != null) {
			inOrder(root);
		}
	}

	public void inOrder(Node node) {
		if (node.left != null)
			inOrder(node.left);
		System.out.print(node.data + " ");
		if (node.right != null)
			inOrder(node.right);

	}
//-------- Lowest common anscestor --------------------------------------
	public Node lca(Node curr, int n1, int n2) {
		if (curr == null)
			return null;
		if (n1 < curr.data && n2 < curr.data)
			return lca(curr.left, n1, n2);
		if (n1 > curr.data && n2 > curr.data)
			return lca(curr.right, n1, n2);

		return curr;
	}

	
}
