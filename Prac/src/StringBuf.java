
public class StringBuf {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("Divyesh");
		str.append(" Balar");
		
		str.replace(8, 13, "Frank"); //8 is included 13 is excluded
		System.out.println(str);
				
	}

}
