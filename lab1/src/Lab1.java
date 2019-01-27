import java.util.Scanner;

public class Lab1 {
	public static void main(String arg[]) {
		int numArr[], sum = 0;
		
		Scanner sc = new Scanner(System.in);
		String sin = sc.nextLine();
		
		//finding length of string
		int len = sin.length();
		//System.out.println(sin);
		numArr = new int[len];
		
		//converting string to int array
		try {
			for(int i = 0; i < len; i++) {
				numArr[i] = Integer.parseInt((sin.charAt(i)+""));
				//System.out.println(numArr[i]);
			}
							
		} catch (Exception e) {
			System.out.println("Enter numbers only");
		}
		
		//for even length of numbers
		if(len%2==0) {
			for(int i= len-2; i >= 0; i=i-2) {
				numArr[i] *= 2;
				//System.out.println("doubled"+numArr[i]);
				if(numArr[i] >= 10) {
					numArr[i]= (numArr[i]%10)+(numArr[i]/10);
					//System.out.println(numArr[i]+"even");
				}
				
			}
		}
		else //for Odd length
		{
			for(int i= len-2; i >= 1; i=i-2) {
				numArr[i] *= 2;
				//System.out.println("doubled"+numArr[i]);
				if(numArr[i] >= 10) {
					numArr[i] = (numArr[i]%10)+(numArr[i]/10);
					//System.out.println(numArr[i]+"odd");
				}
			}
		}
		for(int i = 0; i < len; i++) {
			//numArr[i] = Integer.parseInt((sin.charAt(i)+""));
			sum += numArr[i];
		}
		//System.out.println(sum+" is total");
		
		if(sum%10==0) {
			System.out.print("VALID");
		}
		else {
			//int temp = sum%10;
				System.out.print("INVALID "+ ((10-((sum-numArr[len-1])%10)))%10);
			
		}
		
		
	}
}
