import java.util.Arrays;
import java.util.Scanner;

public class Exam4 {
	static int[] numArr;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String[] tempo = sc.nextLine().split(" ");
		numArr = new int[tempo.length];
		int k = 0;
		int l = 0;
		int li, ui;
		li = 0;
		ui = numArr.length-1;
		for(String gg : tempo) {
			numArr[l] = Integer.parseInt(gg);
			l++;
		}
		k = Integer.parseInt(sc.nextLine());
		Arrays.sort(numArr);
		
		//numarr is SORTED array of number and 'k' is what we need to find
		/*for(int i : numArr) {
			System.out.print(i);
		}*/
		System.out.println();
		String gold = Exam4.findIt(li, ui, k);
		System.out.print(gold.trim());
		
		
		
		
	}
	private static String findIt(int li, int ui, int k) {
		int mid = (li+ui)/2;
		if(numArr[mid] == k) {
			return "found";
		}
		else if(k < numArr[mid] && mid >= li) {
			System.out.print("-1 ");
			if(mid == li) {
				return "notfound";
			}
			return findIt(li, mid-1, k);
			
		}
		else if(k > numArr[mid] && mid <= ui) {
			System.out.print("1 ");
			if(mid == ui) {
				return "notfound";
			}
			return findIt(mid+1, ui, k);
		}
		else {
			return "notfound";
		}
	}

}
