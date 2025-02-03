import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int cnt=0;
		
		boolean[] memory=new boolean[26];
		
		while(n-->0) {
			Arrays.fill(memory, false);
			
			String str=br.readLine();
			char pre = 0;
			int i;
			
			for(i=0;i<str.length();i++) {
				char now=str.charAt(i);
				
				if(pre!=now) {
					if(!memory[now-'a']) {
						memory[now-'a']=true;
						pre=now;
					}else {
						break;
					}
				}
			}
			
			if(i==str.length()) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	
	}
}
