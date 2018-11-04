import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalScore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ff = new String[2];
		ArrayList<String> finalArr = new ArrayList<>();
		ArrayList<String> priority = new ArrayList<>();
		ArrayList<String> lowpriority = new ArrayList<>();
		HashMap<String, Integer> allSubst = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		int n = 0, minlen = 0, maxlen = 0, slen = 0;
		
		String s = sc.nextLine().trim();
		slen = s.length();
		try {
		 n = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e) {
			System.out.println("Wrong Input");
		}

		for(int i = 0; i < n; i++)
		{
			String tempData = sc.nextLine();
			ff = tempData.split(" ");
			if(minlen > ff[0].length())
			{
				minlen = ff[0].length();
			}
			if(maxlen < ff[0].length()) 
			{
				maxlen = ff[0].length();
			}
			map.put(ff[0], Integer.parseInt(ff[1]));
		}
		
		
//		for(String g: map.keySet()) {
//			System.out.println(map.get(g));
//		}
		
		
		for(int i = minlen; i <= maxlen; i++) {
			for(int j = 0; j<=slen-i; j++) {
				//System.out.println(s.substring(j, j+i));
				if(map.containsKey(s.substring(j, j+i))) {
					if(!finalArr.contains(s.substring(j, j+i))) {
						finalArr.add(s.substring(j, j+i));
					}
					allSubst.put(s.substring(j, j+i), map.get(s.substring(j, j+i)));
				}
			}
		}
		int finArrSize = finalArr.size();
		
		for(String g: allSubst.keySet()) 
		{
			System.out.println(allSubst.get(g));
		}
		String arr[] = new String[finArrSize];
		
		int k = 0;
		for(String g:finalArr) 
		{
			arr[k] = g;
			System.out.println(arr[k]);
			k++;
		}
		k=0;
		
		
		for(int i = 0; i < finArrSize; i++) {
			for(int j = 0; j < finArrSize-i;j++) {
				//System.out.println(arr[i]+arr[j]+" = "+map.get(arr[i]+arr[j]));
				if(finalArr.contains(arr[i]+arr[j])&&(map.get(arr[i]+arr[j])>(map.get(arr[i])+map.get(arr[j])))&&!lowpriority.contains(arr[i])&&!lowpriority.contains(arr[j])){
					priority.add(arr[i]+arr[j]);
					System.out.println("Adding combined string "+arr[i]+arr[j]+ " in priority");
				}
				else {
					if(finalArr.contains(arr[i]+arr[j])) {
						lowpriority.add(arr[i]+arr[j]);
					}
					if(!priority.contains(arr[i])&&!lowpriority.contains(arr[i])) {
						priority.add(arr[i]);
						System.out.println("Adding in second if string "+arr[i]+ " in priority");
					}
//					if(!priority.contains(arr[j])&&!lowpriority.contains(arr[j])) {
//						priority.add(arr[j]);
//						System.out.println("Adding in third if string "+arr[j]+ " in priority");
//					}
				
				
				
				}
			}
		}
		
		
		
		
		for(String d: priority) {
			System.out.println(d+" Priority");			
		}
		
		for(String d: lowpriority) {
			System.out.println(d+" LowPriority");
			priority.remove(d);
		}
		
		
		//sorting Map
/*		Map<String, Integer> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,LinkedHashMap::new));
		for(String x: sorted.keySet()) {
			System.out.println(x+"=>"+map.get(x));
		}*/
		
		
	}

}
