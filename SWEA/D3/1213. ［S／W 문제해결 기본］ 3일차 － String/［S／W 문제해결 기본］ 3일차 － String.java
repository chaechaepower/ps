import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=10;t++) {
			br.readLine();
			String target=br.readLine();
			String str=br.readLine();
			
			int count=0;
			
			for(int i=0;i<=str.length()-target.length();i++) {
				String part=str.substring(i,i+target.length());
				
				if(part.equals(target)) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n",t,count);
		}
	}
}
