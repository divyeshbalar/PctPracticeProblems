import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Canasta {
		public static ArrayList<Integer>[][] table = new ArrayList[100][4];
		static int count = 0, count1= 0;
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
				////System.out.println("HandsFree = "+handsFree[i]);
			}
			
			
			//Processing
			//hand is array of sorted numbers
			ArrayList<Integer> setOfConse = Canasta.findConsec(hand);
			
			//System.out.println("Handsfree Before:");
			for(int i: handsFree) {
				//System.out.print(i);
			}
			//System.out.println();
			handsFree = Canasta.filterArray(setOfConse, handsFree);
			
			int l = 0;
			for(int i : handsFree) {
				if(i == 0) {
					continue;
				}
				else {
					handsFree1[l] = i; 
					//System.out.print(handsFree1[l]);
					l++;
				}
				
			}
			// getting remaining in array(HandsFree1) after finding sequence 
			
			
			ArrayList<Integer> setOfcom = Canasta.findCommon(handsFree1); // set of common
			
			//System.out.println("\nComm = ");
			for(int a : setOfcom) {
				
				//System.out.println(a);
			}
			
			for(int i = 0; i < 7; i++) {
				if(setOfcom.contains(handsFree1[i])) {
					handsFree1[i] = 0;
				}
				else {
					count = count+ handsFree1[i];
				}
			}
			
			//System.out.println("Count = "+count);
			
			//second half
			
			l = 0;
			for(int i : hand) {
				handsFree[l] = i;
				l++;
			}
			ArrayList<Integer> setOfcom1 = Canasta.findCommon(handsFree); // set of common
			l=0;
			for(int i = 0; i < handsFree.length; i++) {
				if(setOfcom1.contains(handsFree[i])) {
					handsFree[i] = 0;
				}
				else {
					handsFree1[l] = handsFree[i];
					l++;
				}
			}
			//System.out.println("remaining after getting commons in second half");
			for(int i : handsFree) {
				//System.out.print(i);
			}
			//System.out.println();
			l = 0;
			ArrayList<Integer> setOfConse1 = Canasta.findConsec(handsFree1);
			
			//write function
			
			handsFree1 = Canasta.filterArray(setOfConse1, handsFree1);
			
			
			
			
			for(int i = 0; i < 7; i++) {
				if(setOfcom.contains(handsFree1[i])) {
					handsFree1[i] = 0;
				}
				else {
					count1 = count1+ handsFree1[i];
				}
			}
			//System.out.println("count1 = "+count1);
			
			if(count1<count) {
				System.out.println("optimal/minimum is : "+ count1);
			}
			else {
				System.out.println("optimal/minimum is : "+ count);
			}

		}

		private static int[] filterArray(ArrayList<Integer> set, int[] handsFree1) {
			for(int i = 0; i <= handsFree1.length-1; i++) {
				if(set.contains(handsFree1[i])) {
					if(i > 0 && i < handsFree1.length-1) {
						if(handsFree1[i+1] == handsFree1[i] && handsFree1[i-1] != handsFree1[i]) {
							//System.out.println("handsFree["+(i+1)+"] == handsFree["+i+"] && handsFree["+(i-1)+"] != handsFree["+i+"]");
							handsFree1[i] = 0;
							i = i+1;
							continue;
						}
						if(handsFree1[i+1] == handsFree1[i] && handsFree1[i-1] == handsFree1[i]) {
							//System.out.println("handsFree["+(i+1)+"] == handsFree["+i+"] && handsFree["+(i-1)+"] == handsFree["+i+"]");
							i = i +1;
							continue;
						}
						if(handsFree1[i+1] != handsFree1[i] && handsFree1[i-1] == handsFree1[i]) {
							//System.out.println("handsFree["+(i+1)+"] != handsFree["+i+"] && handsFree["+(i-1)+"] == handsFree["+i+"]");
							continue;
						}
						if(handsFree1[i+1] != handsFree1[i] && handsFree1[i-1] != handsFree1[i]) {
							//System.out.println("handsFree["+(i+1)+"] != handsFree["+i+"] && handsFree["+(i-1)+"] != handsFree["+i+"]");
							handsFree1[i] = 0;	
							continue;
						}
						
					}
					else {
						if(i<handsFree1.length&&i>0) {
							if(handsFree1[i] != handsFree1[i-1]) {
								//System.out.println("handsFree["+i+"] != handsFree["+(i-1)+"]");
								handsFree1[i] = 0;
								continue;
							}
							else {
								continue;
							}
						}
						else {
							if(handsFree1[i+1] == handsFree1[i] ) {
								//System.out.println("handsFree["+(i+1)+"] == handsFree["+i+"]");
								handsFree1[i] = 0;
								i = i+1;
								continue;
							}
							else {
								//System.out.println("First elem != second element");
								handsFree1[i] = 0;
								continue;
							}
						}
					}
				}
				else {
					//System.out.println("do not contain this element");
				}
			}
			return handsFree1;
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
							
						}
						com = j;
						break;
					}				
				}
				if(temp2.size()>=3) {
					for(int k = 0; k < temp2.size(); k++) {
						temp.add(temp2.get(k));
					}
				}
				temp2.clear();
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
			for(int i = 0; i < temp2.size(); i++)
			{
				temp.add(temp2.get(i));
			}
			return temp;
		}
		
		

	}
