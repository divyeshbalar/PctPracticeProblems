import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int p = 0, n = 0;
		
		ArrayList<String> para = new ArrayList<>();
		
		
		int uni[]= new int[26];
		int bi[][] = new int[26][26];
		int tri[][][] = new int[26][26][26];
		
		
		
		//Input
		try {
			p = Integer.parseInt(sc.nextLine());
			//System.out.println(p);
		}
		catch (Exception e) {
			System.out.println("Enter Number only!");
		}
		
		int x = p;
		while(x!=0) {
			para.add(sc.nextLine());
			x--;
		}
//		for (String str : para) {
//			System.out.println(str);
//		}
		
		try {
			n = Integer.parseInt(sc.nextLine());
			//System.out.println(n);
//			switch (n) {
//			case 1:
//				uni = new int[26];
//				break;
//			case 2:
//				bi = new int[26][26];
//				break;
//			case 3:
//				tri = new int[26][26][26];
//				break;
//			default:
//				System.out.println("tooo big for intialization");
//				break;
//			}
		} catch (NumberFormatException e) {
			System.out.println("Enter the number for N");
		}
		
		//Body
		int key = n;
		switch (key) {
		case 1:
			for (String s : para) {
				
				int len = s.length();
				if(len>0) {
				for(int i = 0; i < len; i++) {
					int temp = s.charAt(i);
					if(temp >=97 && temp <= 122)  {
						uni[temp%97]++;
					}
				}
			}
				else if(len==0){
					System.out.print("No  input paragraph");
				}
			}
			int max = uni[0];
			int index = 0;
			
			//Max
			
			for(int i = 0; i < 26; i++)
			{
				if(uni[i] > max) {
					max = uni[i];
					index = i;
				}else if(uni[i] == max) {
				 int indi = Math.min(i, index);
					max = uni[indi];
					 //System.out.println("MAxxx = "+ max);
					if(i<index) {
						index = i;
					}
					
				}
			}
			index +=97;
			char tempx = (char)index;
			System.out.print("Unigram "+ tempx);
			
		break;
		case 2:
			for (String s : para) {
							
							int len = s.length();
							if(len>2) {
							for(int i = 0; i < len-1; i++) {
								int temp = s.charAt(i);
								int temp1 = s.charAt(i+1);
								if((temp >=97 && temp <= 122) && (temp1 >= 97 && temp1 <=122))  {
									bi[temp%97][temp1%97]++;
								}
							}
							}
							else if (len==2) {
								int temp = s.charAt(0);
								int temp1 = s.charAt(1);
								if((temp >=97 && temp <= 122) && (temp1 >= 97 && temp1 <=122))  {
									bi[temp%97][temp1%97]++;
								}
							}
							else
							{
								//continue;
							}
						}
						int maxbi = bi[0][0];
						int indexX = 0, indexY = 0;
						
			
				for(int i = 0; i < 26; i++)
				{
					for(int j = 0; j < 26; j++) {
						if(bi[i][j] > maxbi) {
							maxbi = bi[i][j];
							//System.out.println(maxbi+ " i = "+ i +" j = "+ j);
							indexX = i;
							indexY = j;
						}
						else if(bi[i][j] == maxbi) {
							 int indi = Math.min(i, indexX);
							if(i<indexX) {
								maxbi = bi[indi][j];
								//System.out.println("MAxxx = "+ maxbi);
								indexX = i;
								indexY = j;
								}
								
							}
						
					}
				}
				indexX+=97;
				indexY+=97;
				char bitempx = (char)indexX;
				char bitempy =(char)indexY;
				System.out.print("Bigram "+ bitempx+bitempy);
			
			break;
		case 3:
			
			for (String s : para) {
				
				int len = s.length();
				if(len>3) {
					for(int i = 0; i < len-2; i++) {
						int temp = s.charAt(i);
						int temp1 = s.charAt(i+1);
						int temp2 = s.charAt(i+2);
						if((temp >=97 && temp <= 122) && (temp1 >= 97 && temp1 <=122) && (temp2 >= 97 && temp2 <=122))  {
							tri[temp%97][temp1%97][temp2%97]++;
						}
				}
			}
				else if(len == 3) {
					int temp = s.charAt(0);
					int temp1 = s.charAt(1);
					int temp2 = s.charAt(2);
					if((temp >=97 && temp <= 122) && (temp1 >= 97 && temp1 <=122) && (temp2 >= 97 && temp2 <=122))  {
						tri[temp%97][temp1%97][temp2%97]++;
					}
			}
				else
				{
					//continue;
				}
			}
			int maxtri = tri[0][0][0];
			int triindexX = 0, triindexY = 0, triindexZ =0;
			

			for(int i = 0; i < 26; i++)
			{
				for(int j = 0; j < 26; j++) {
					
					for(int k =0; k<26; k++) {
						
						if(tri[i][j][k] > maxtri) {
						maxtri = tri[i][j][k];
						//System.out.println(maxtri+ " i = "+ i +" j = "+ j+" k = "+k );
						triindexX = i;
						triindexY = j;
						triindexZ = k;
					}
					else if(tri[i][j][k] == maxtri) {
							 int indi = Math.min(i, triindexX);
							if(i<triindexX) {
								maxtri = tri[indi][j][k];
								//System.out.println("MAxxx = "+ maxtri);
								triindexX = i;
								triindexY = j;
								triindexZ = k;
								}
								
							}
				}
			}
			}
			triindexX += 97;
			triindexY += 97;
			triindexZ += 97;
			char tritempx = (char)triindexX;
			char tritempy =(char)triindexY;
			char tritempz =(char)triindexZ;
			System.out.print("Trigram "+ tritempx+tritempy+tritempz);
			break;
			
		default:
			System.out.print("Invalid Value of N");
			break;
		}
		
		
		
		
		
	}

}
