import java.util.Scanner;
import java.util.TreeSet;

public class Isogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.nextLine());
		TreeSet<Character> sett= new TreeSet<>();
		
		int len = str.length();
		int[] cArr = new int[len];
		boolean IsoFlag = true;
		for(int i = 0; i < len; i++) {
			sett.add(str.charAt(i));
		}
		int l =0;
		for(char c: sett) {
			for(int i = 0; i < str.length();i++) {
				if(str.charAt(i) == c) {
					cArr[l]++;
				}
				else {
					continue;
				}
			
			}
			if(cArr[l]!=2) {
				IsoFlag = false;
			}
			l++;
			
		}
		
		if(IsoFlag == false) {
			l = 0;
			for(char c: sett) {
				
				if(cArr[l]!=2) {
					System.out.print(c+" ");
					l++;
				}
				else {
					l++;
				}
			}
			System.out.print("no");
		}
		else {
			for(char c : sett)
			{
				System.out.print(c+" "); 
			}
			System.out.print("yes");
		}
		
		/*for(int i : cArr) {
			System.out.println(i);
		}*/
		
		//System.out.println(IsoFlag);
		/*for(int i = 0; i < str.length(); i++) {
			cArr[i]++;
			for(int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					cArr[i]++;
					str.replace(j, j+1, "");
				}
				else {
					continue;
				}
			}
			if(cArr[i] != 2) {
				IsoFlag = false;
			}
		}*/
		
		/*for(int i = 0; i < str.length();i++) {
			System.out.println(str.charAt(i)+" = "+cArr[i]);
			System.out.println(IsoFlag);
		}*/
		
	}

}
