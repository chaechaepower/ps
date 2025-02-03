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
			
			if(str.length()==1) {
				cnt++;
				continue;
			}
			
			char pre=str.charAt(0);
			memory[pre-'a']=true;
			
			for(int i=1;i<str.length();i++) {
				char c=str.charAt(i);
				
				if(c==pre) {
					if(i==str.length()-1) {
						cnt++;
					}
					pre=c;
					continue;
				}
				else if(memory[c-'a']) { //이전 문자와 다른데 이미 나왔던 문자 
					break;
				}
				else if(!memory[c-'a']) { //이전 문자와 다른데 안나왔던 문자
					if(i==str.length()-1) {
						cnt++;
						break;
					}
					memory[c-'a']=true;
					pre=c;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
