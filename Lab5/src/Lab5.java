import java.util.Scanner;

public class Lab5 {
	
	static String window;
	static int count = 0, startIndx=0, endIndx = 0, windowlen=0, letterlen = 0, num = 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String temp;
		boolean flag = false;
		int  strlen = 0;
		String letter;
		strlen = str.length();
		if(strlen > 70) {
			System.out.println("BadInput");
		}
		else {
			letter = sc.nextLine();
			temp = letter;
			letterlen = letter.length();
			if(strlen < letterlen) {
				System.out.println("BadInput");
			}
			else {
				//find first index
				if(str.contains(letter)) {
					System.out.print(letter);
					flag = true;
				}
				else {
					//for first window
					for(int i = 0; i <= strlen-letterlen; i++)
					{
						
						for(int j = 0; j < temp.length();j++) {
												
							if(str.charAt(i)==temp.charAt(j)) {
								if(count == 0) {
									startIndx = i;
									count= count + 1;
									if(count == letterlen) {
										endIndx = i;
										//System.out.println("EndIndex= "+endIndx);
									}
									temp = temp.replaceFirst(temp.charAt(j)+"", "");
									
									if(temp.isEmpty()) {
										endIndx = i;
									}
									System.out.println(letterlen+"  "+ temp +" SartingIndex="+startIndx+" EndingIndex="+endIndx+" count = "+ count);
									break;
								}
								
								else if(count >0 && count <= letterlen) {
									count= count + 1;
									if(count == letterlen) {
										endIndx = i;
										//System.out.println("EndIndex= "+endIndx);
									}
									temp = temp.replaceFirst(temp.charAt(j)+"", "");
									
									
									System.out.println(letterlen+"  "+ temp +" SartingIndex="+startIndx+" EndingIndex="+endIndx+ " count = "+ count);
								}
								
								
							}
							
						}
						//outside inner loop
						
					}
					//after first window
					
					
					String xx;
					if(endIndx == strlen) {
						window = str.substring(startIndx);	
					}else
					{
						window = str.substring(startIndx, endIndx);
					}
					windowlen = window.length();
					System.out.println(window+ " length = "+ windowlen+ startIndx);
					count = 0;
					while(num>=0) {
					System.out.println(Lab5.findMinString(str, letter));
					count = 0;
					num--;
					}
					
					
					
					
					
					
					
					
				}
				if(temp.isEmpty()!=true && flag == false) {
					System.out.println("Str do not contain letter");
				}
			}
		}
		}
	
	
	
	public static String findMinString(String str, String temp) {
		int strlen = str.length();
		int prevStart = startIndx+1;
		
		for(int i = prevStart; i <= strlen-letterlen; i++)
		{
			//System.out.println(prevStart+" starting index in I loop ="+startIndx);
			for(int j = 0; j < temp.length();j++) {
				//System.out.println(prevStart+" starting index= in J loop "+startIndx);				
				if(str.charAt(i)==temp.charAt(j)) {
					if(count == 0) {
						startIndx = i;
						count= count + 1;
						if(count == letterlen) {
							endIndx = i;
							//System.out.println("EndIndex= "+endIndx);
						}
						temp = temp.replaceFirst(temp.charAt(j)+"", "");
						
						if(temp.isEmpty()) {
							endIndx = i;
						}
						System.out.println(letterlen+"  "+ temp +" SartingIndex="+startIndx+" EndingIndex="+endIndx+" count = "+ count);
						break;
					}
					
					else if(count >0 && count <= letterlen) {
						count= count + 1;
						if(count == letterlen) {
							endIndx = i;
							//System.out.println("EndIndex= "+endIndx);
						}
						temp = temp.replaceFirst(temp.charAt(j)+"", "");
						
						
						System.out.println(letterlen+"  "+ temp +" SartingIndex="+startIndx+" EndingIndex="+endIndx+ " count = "+ count);
					}
					
					
				}
				
			}
			//outside inner loop
			
		}
		String xx;
		if(endIndx == strlen) {
			xx = str.substring(startIndx);	
		}else
		{
			xx = str.substring(startIndx, endIndx+1);
		}
		
		if(windowlen < xx.length()) {
			System.out.println("returning existing window having length= "+ windowlen);
			return window;
		}
		else {
			windowlen = xx.length();
			window = xx;
			System.out.println("Updated window having length= "+ windowlen);
			return xx;
		}
	}

}
