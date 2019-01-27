import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Canasta {
	public static ArrayList<Integer>[][] table = new ArrayList[100][4];
	static int count = 0, count2 = 0;
	public static void main(String[] args) throws Exception {
		
		
		for(int i  = 0; i < 100; i++) {
			for(int j  = 0; j < 4; j++) {
					table[i][j]  = new ArrayList<>();
				
			}
		}
		Scanner sc = new Scanner(System.in);
		int[] hand = new int[7];
		
		
		
		//Input
		String[] handStr = sc.nextLine().split(" ");
		
		//Input Manipulation
		try {
			for(int i = 0; i< 7; i++) {
				hand[i] = Integer.parseInt(handStr[i]);
				if(hand[i] <= 0 || hand[i] > 13) {
					return;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Arrays.sort(hand);//Sorting array
		
		int[] handsFree = new int[7];
		int[] handsFree1 = new int[7];
		for(int i = 0; i< 7; i++) {
			handsFree[i] = hand[i];
			//System.out.println("HandsFree = "+handsFree[i]);
		}
		
		
		//Processing
		//hand is array of sorted numbers
		ArrayList<Integer> setOfConse = Canasta.findConsec(hand);
		/*for(int a: handsFree) {
			System.out.print(a + " ");
		}*/
		for(int i = 0; i < 7; i++) {
			if(setOfConse.contains(handsFree[i])) {
				if(i > 0) {
					
					if(handsFree[i] != handsFree[i+1] && handsFree[i-1] != handsFree[i]) {
						System.out.println("(handsFree["+i+"] != handsFree["+ (i+1) +"] && handsFree["+ (i-1) +"] != handsFree["+i+"]");
						handsFree[i] = 0;
						continue;
					}
					
					if(handsFree[i] == handsFree[i+1] && handsFree[i-1] != handsFree[i]) {
						System.out.println("(handsFree["+i+"] == handsFree["+ (i+1) +"] && handsFree["+ (i-1) +"] != handsFree["+i+"]");
						handsFree[i] = 0;
						i = i+1;
						continue;
					}
					if(handsFree[i] == handsFree[i+1] && handsFree[i-1] == handsFree[i]) {
						System.out.println("(handsFree["+i+"] == handsFree["+ (i+1) +"] && handsFree["+ (i-1) +"] == handsFree["+i+"]");
						i = i+1;
						continue;
					}
					if(handsFree[i] != handsFree[i+1] && handsFree[i-1] == handsFree[i]) {
						System.out.println("(handsFree["+i+"] != handsFree["+ (i+1) +"] && handsFree["+ (i-1) +"] == handsFree["+i+"]");
						continue;
					}
						
				}
				else {
					if(handsFree[i+1] == handsFree[i] ) {
						//System.out.println("First element");
						handsFree[i] = 0;
						i = i+1;
						System.out.println("First element value of i is "+ i);
						continue;
					}
					else {
						handsFree[i] = 0;
						continue;
					}
				}
			}
			else {
				System.out.println("going into else handsFree" + handsFree[i]);
			}
		}
		/*for(int a: handsFree) {
			System.out.print(a);
		}
		System.out.println("");*/
		System.out.print("Consecutives: ");
		for(int i : setOfConse) {
			System.out.print(i);
		}
		System.out.println();
		int k = 0;
		for(int l = 0; l  < handsFree.length; l++) {
			if(handsFree[l] == 0) {
				
			}
			else {
				handsFree1[k] = handsFree[l]; // getting remaining in array after finding sequence
				//System.out.println("Here "+handsFree1[k]);
				k++;
			}
		}
		
		
		
		System.out.println("Remaining");
		for(int a : handsFree1) {
			System.out.print(a);
		}
		
		
		System.out.println("");
		/*for(int i : handsFree) {
			if(i == 0) {
				l++;
			}
			else {
				handsFree1[l] = i; // getting remaining in array after finding sequence
				System.out.println("Here "+handsFree1[l]);
				l++;
			}
			
		}*/
		
		
		ArrayList<Integer> setOfcom = Canasta.findCommon(handsFree1); // set of common
		
		System.out.println("Comm = ");
		for(int a : setOfcom) {
			
			System.out.println(a);
		}
		
		for(int i = 0; i < 7; i++) {
			if(setOfcom.contains(handsFree1[i])) {
				handsFree1[i] = 0;
			}
			else {
				count = count+ handsFree1[i];
			}
		}
		
		System.out.println("Count = "+count);
		
		
		for(int i = 0; i< 7; i++) {
			handsFree[i] = hand[i];
			//System.out.println("HandsFree = "+handsFree[i]);
		}
		ArrayList<Integer> setOfcom1 = Canasta.findCommon(hand);
		
		for(int i = 0; i < 7; i++) {
			System.out.println("Is frequency"+Collections.frequency(setOfcom1, handsFree[i]));
			if(setOfcom1.contains(handsFree[i])) {
				if(i > 0) {
					
						
				}
				else {
					
				}
			}
			else {
				System.out.println("going into else handsFree" + handsFree[i]);
			}
		}
		

	}

	private static ArrayList<Integer> findCommon(int[] handsFree1) {
		ArrayList<Integer> temp = new ArrayList<>();
		//boolean flag = false;
		int com = 0;
		ArrayList<Integer> temp2 = new ArrayList<>();
		for(int i = 0; i < handsFree1.length ; i++) {
			int gg = handsFree1[i];
			temp2.add(gg);
			for(int j = i; j < handsFree1.length-1; j++) {
				if(gg == handsFree1[j+1]) {
					temp2.add(handsFree1[j+1]);
					gg = handsFree1[j+1];
					com = j+2;
				}
				else {
					if(temp2.size()<3) {
					temp2.clear();
					}
					else {
						for(int k = 0; k < temp2.size(); k++) {
							temp.add(temp2.get(k));
						}
						temp2.clear();
					}
					com = j;
					break;
				}				
			}
			i = com;
			if(i+1 >= 6) {
				break;
			}
			
		}
		return temp;
	}

	private static ArrayList<Integer> findConsec(int[] hand) {
		ArrayList<Integer> temp = new ArrayList<>();
		//boolean flag = false;
		int com = 0;
		ArrayList<Integer> temp2 = new ArrayList<>();
		for(int i = 0; i < hand.length ; i++) {
			int gg = hand[i];
			temp2.add(gg);
			for(int j = i; j < hand.length-1; j++) {
				if(gg == hand[j+1]-1) {
					temp2.add(hand[j+1]);
					gg = hand[j+1];
					com = j+2;
				}
				else {
					if(temp2.size()<3) {
					temp2.clear();
					}
					else {
						for(int k = 0; k < temp2.size(); k++) {
							temp.add(temp2.get(k));
						}
						temp2.clear();
					}
					com = j;
					break;
				}				
			}
			i = com;
			if(i+1 >= 6) {
				break;
			}
			
		}
		return temp;
	}

}
