package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FamilyTree {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberNodes = s.nextInt();
		FTree tree = new FTree();
		for (int i = 0; i < numberNodes; i++) {
			String parent = s.next();
			String child = s.next();
			tree.insert(parent, child);
		}

		// tree.pre(tree.root);

		int queries = s.nextInt();
		char[] ans = new char[queries];
		for (int i = 0; i < queries; i++) {
			String input1 = null, operation = null, input2 = null;
			if (s.hasNext())
				input1 = s.next();
			if (s.hasNext())
				operation = s.next();
			if (s.hasNext())
				input2 = s.next();

			if (operation.equals("child")) {
				if (tree.isChild(input2, input1)) {
					// System.out.print("T");
					ans[i] = 'T';
				} else {
					// System.out.print("F");
					ans[i] = 'F';
				}
			}
			if (operation.equals("descendant")) {
				if (tree.isDescendant(input1, input2)) {
					// System.out.print("T");
					ans[i] = 'T';
				} else {
					// System.out.print("F");
					ans[i] = 'F';
				}
			}
			if (operation.equals("sibling")) {

				if (tree.isSibling(input1, input2)) {
					// System.out.print("T");
					ans[i] = 'T';
				} else {
					// System.out.print("F");
					ans[i] = 'F';
				}
			}
			if (operation.equals("ancestor")) {
				// System.out.print("d");
				if (tree.isDescendant(input2, input1)) {
					// System.out.print("T");
					ans[i] = 'T';
				} else {
					// System.out.print("F");
					ans[i] = 'F';
				}
			}

		}
		for (int i = 0; i < queries; i++) {
			System.out.print(ans[i]+" ");
		}

	}

}

class FTree {
	Fnode root;

	public void insert(String par, String ch) {
		Fnode parent = new Fnode(par);
		Fnode child = new Fnode(ch);

		if (root == null) {
			root = parent;
			child.level = root.level + 1;
			root.left = child;
			child.parent = root;
			return;
		}

		Fnode parent2 = searchNode(root, par);
		if (parent2 == null)
			return;
		if (parent2.left == null) {
			child.level = parent2.level + 1;
			parent2.left = child;
			child.parent = parent2;
		} else {
			child.level = parent2.level + 1;
			parent2.right = child;
			child.parent = parent2;
		}
	}

	public boolean isChild(String par, String ch) {
		Fnode parent = searchNode(this.root, par);

		if (parent.left != null) {
			if ((parent.left.data).equals(ch)) {
				return true;
			}
		} else if (parent.right != null) {
			if ((parent.right.data).equals(ch)) {
				return true;
			}
		}
		return false;
	}

	public boolean isDescendant(String ch, String anc) {
		Fnode child = searchNode(this.root, ch);
		boolean flag = false;
		while (true) {
			if (child == null)
				break;
			child = child.parent;
			if (child == null)
				break;
			if (child.data.equals(anc)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Fnode searchNode(Fnode node, String name) {
		Fnode temp;
		if (node == null)
			return null;
		if (node.data.equals(name))
			return node;
		temp = searchNode(node.left, name);
		if (temp == null) {
		} else if (temp.data.equals(name)) {
			return temp;
		}
		temp = searchNode(node.right, name);
		return temp;
	}

	public boolean isSibling(String one, String two) {
		Fnode n1 = searchNode(this.root, one);
		Fnode n2 = searchNode(this.root, two);

		if (n1 == null || n2 == null)
			return false;
		if (n1.parent == null || n2.parent == null)
			return false;
		if (n1.parent.data.equals(n2.parent.data))
			return true;
		else
			return false;
	}

	public void pre(Fnode r) {
		if (r == null)
			return;
		System.out.print(r.data + " " + r.level + "  ");
		pre(r.left);
		pre(r.right);
	}

}

class Fnode {
	String data;
	Fnode left;
	Fnode right;
	Fnode parent;
	int level;

	public Fnode(String name) {
		this.data = name;
	}

}
