import java.util.Scanner;

public class View {
	
	public static void displaySumAvg(int sum, int avg){
		System.out.println("Sum = "+sum + " average = "+avg);
	}
	
	public static int getData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of sum: ");
		int sum = sc.nextInt();
		return sum;
	}
}
