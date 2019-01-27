import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Prac2 {

	
		public static void main(String[] args) {
			 
			 
			 
			//................................................... 
			Prac2 ob = new Prac2();
			int cups[] = ob.getCupSize();
			int people = ob.numOfPeople();
			ArrayList<Cust> custDtl = ob.custDtl(people);
			
			//..........................................................................
			
			
			
			
		}
		
		public int[] getCupSize()
		{
			int cups[] = new int[3];
			Scanner sc = new Scanner(System.in);
			int i = 0;
			String str;
			boolean flag = true;
			//.....................Continuous prompt until right input................................
			while(flag) 
			{
				i = 0;
				
				str = sc.nextLine();
				String after =  str.trim().replaceAll(" +", " "); //remove more than one space
				
				
				try {
					//..............split by space..............................
					for (String retval: after.split(" ")) {
						 if(i>=3)
							break; 
					     System.out.println(retval);
					     cups[i] = Integer.valueOf(retval);
					     i++;
					  }
					
					
					if(cups[0] <= 0 || cups[1] <=0 || cups[2] <= 0)
					{
						System.out.println("Enter Proper input(from 1 to 100)");
						flag = true;
					}
					else
					{
						flag = false;						
					}
					
					i = 0;
					//.............................................
					
				} catch (NumberFormatException e) {
					System.out.println("Enter Numbers only........");
					i = 0;
				}
			}
			return cups;
		}
		public int numOfPeople()
		{
			int numOfPeople = 0;
			boolean flag1 = true;
			while(flag1)
			{
				Scanner scx = new Scanner(System.in);
				numOfPeople = 0;
				 try {
					 numOfPeople = scx.nextInt();
					     if(numOfPeople > 0)
					     {
					    	 flag1 = false;
					     }
					     else
					     {
					    	 flag1 = true;
					     }
				 	} 
				 catch (Exception e) {
					System.out.println("Enter integer only");
					flag1 = true;
					numOfPeople = 0;
				}
			}
			return numOfPeople;
		}
		
		
		public ArrayList<Cust> custDtl(int noOfPeople)
		{
			String data[] = new String[4];
			 Scanner sc2 = new Scanner(System.in);
			 ArrayList<Cust> custdata = new ArrayList<>();
			 int i = 0;
			 
			 for(int j = 0; j < noOfPeople; j++)
			 {	 
				 try {
					String custDtl = sc2.nextLine();
					 String af =  custDtl.trim().replaceAll(" +", " ");
					 for(String x : af.split(" "))
					 {
						 if(i>3)
						 {
							 break;
						 }
						 data[i] = x;
						 i++;
					 }
					 i = 0;
						 int age = Integer.parseInt(data[1]);
						 int height = Integer.parseInt(data[2]);
						 int height1 = Integer.parseInt(data[3]);
						 custdata.add(new Cust(data[0], age, height, height1));
						 System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Enter customer detail in a proper manner(Eg. NAME AGE HEIGHT(ft) Height(inch))");
				}	     
			     
			 }
			 for(Cust cd : custdata)
			 {
				 System.out.println(cd.name);
			 }
			 return custdata;
		}
	}

class Cust
{
	String name = "";
	int age = 0, height = 0, height1 = 0;
	public Cust(String name, int age, int height, int height1) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.height1 = height1;
	}
}
