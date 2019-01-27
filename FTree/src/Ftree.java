import java.util.Scanner;


public class Ftree {
	static Fnode root;
	static String porder= "";
	public static void main(String[] args) {
		//Initialisation
		int n=0, m = 0;
		String result = "";
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
		//Input data
		Ftree family = null;
			try {
				n = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			family = new Ftree();
			for(int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				String[] temp1 = temp.split(" ");
				//System.out.println(temp1[0]+"  "+temp1[1]);
				family.insert(temp1[0], temp1[1]);
			}
		try {
			m = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		for(int i = 0; i < m; i++) {
			String temp = sc.nextLine();
			String[] temp1 = temp.split(" ");
			//System.out.println(temp1[0]+"  "+temp1[1]+ " "+temp1[2]);
			switch(temp1[1]) {
			case "child":
				if(family.isChild(temp1[0], temp1[2])) {
					result += "T ";
				}
				else {
					result += "F ";
				}
				break;
				
			case "parent":
				if(family.isChild(temp1[2], temp1[0])) {
					result += "T ";
				}
				else {
					result += "F ";
				}
				break;
			
			case "descendant":
				if(family.descendant(temp1[0], temp1[2])) {
					result += "T ";
				}
				else {
					result += "F ";
				}
				break;
			case "ancestor":
				if(family.descendant(temp1[2], temp1[0])) {
					result += "T ";
				}
				else {
					result += "F ";
				}
				break;
			case "sibling":
				if(family.sibiling(temp1[0], temp1[2])) {
					result += "T ";
				}
				else {
					result += "F ";
				}
				break;
			}
		}
		}
		catch(Exception e) {
			System.out.println("Theres something wrong with switch");
		}
		
		System.out.println(result.trim());
		family.pre(Ftree.root);
		System.out.print(porder.trim());
		sc.close();


	}
	
	private boolean sibiling(String string1, String string2) {
		Fnode b1 = findNode(root, string1);
		Fnode b2 = findNode(root, string2);
		
		if (b1 == null || b2 == null)
			return false;
		if (b1.parent == null || b2.parent == null)
			return false;
		if (b1.parent.data.equals(b2.parent.data))
			return true;
		else
			return false;
	}

	

	private boolean descendant(String son, String father) {
		Fnode child = findNode(root, son);
		boolean flag = false;
		while (true) {
			if (child == null)
				break;
			child = child.parent;
			if (child == null)
				break;
			if (child.data.equals(father)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private boolean isChild(String son, String father) {
		Fnode temp = findNode(root, father);
		if(temp == null) {
			return false;
		}
		if (temp.left != null) {
			if ((temp.left.data).equals(son)) {
				return true;
			}
		} else if (temp.right != null) {
			if ((temp.right.data).equals(son)) {
				return true;
			}
		}
		return false;
		
	}

	public void insert(String par, String chi) {
	/*Fnode parent = new Fnode(par);
	Fnode child = new Fnode(chi);*/
	//base case
	if(root == null) {
		root = new Fnode(par);
		root.left = new Fnode(chi);//change
		root.left.level = root.level + 1;
		root.left.parent = root;
		return;
	}
	Fnode baap = findNode(root, par);
	if(baap == null) {
		return;
	}
	if(baap.left == null) {
		baap.left = new Fnode(chi);
		baap.left.level = baap.level+1;
		baap.left.parent = baap;
		return;
	}else {
		baap.right = new Fnode(chi);
		baap.right.level = baap.level+1;
		baap.right.parent = baap;
		return;
	}
	}

	private Fnode findNode(Fnode root2, String par) {
		Fnode tempo;
		if(root2 == null) {
			return null;
		}
		if(root2.data.equals(par)) {
			return root2;
		}
		
		tempo = findNode(root2.left, par);
		if(tempo == null) {
		}else if(tempo.data.equals(par)) {
			return tempo;
		}
		tempo = findNode(root2.right, par);
		return tempo;
	}

	public void pre(Fnode r) {
		if (r == null)
			return;
		porder+=r.data+" ";
		pre(r.left);
		pre(r.right);
	}
	

}


class Fnode {
	String data;
	Fnode left;
	Fnode right;
	Fnode parent;
	int level = 0;

	public Fnode(String name) {
		this.data = name;
	}

}