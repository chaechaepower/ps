import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			String str=br.readLine();
			String line=br.readLine();
			
			int idx=0;
			int answer=0;
			
			for(int i=0;i<line.length();i++) {
				idx=i;
				boolean isSame=true;
				
				for(int j=0;j<str.length() ;j++) {
					
					if(idx>=line.length()) {
						isSame=false;
						break;
					}
					
					if(line.charAt(idx++)!=str.charAt(j)) {
						isSame=false;
						break;
					}
				}
				
				if(isSame) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
