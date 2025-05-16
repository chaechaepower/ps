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
			
			String target=br.readLine();
			String line=br.readLine();
			
			int answer=0;
			
			for(int i=0;i<=line.length()-target.length();i++) {
				if(target.equals(line.substring(i,i+target.length()))) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
