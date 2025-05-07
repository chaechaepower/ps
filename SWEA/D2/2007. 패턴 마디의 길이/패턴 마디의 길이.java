import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			String str=br.readLine();
			
			for(int i=1;i<=str.length();i++) {
				String str1=str.substring(0,i);
				String str2=str.substring(i,i+i);
				
				if(str1.equals(str2)) {
					System.out.println("#"+t+" "+str1.length());
					break;
				}
			}
			
		}
	}
}
