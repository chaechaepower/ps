import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int n;
	static boolean[] hansoo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		hansoo=new boolean[n+1]; //1~n사이 수가 한 수인지 판별. true: 한수, false: 한수x
		
		isHansoo();
		
		int cnt=0;
		
		for(int i=1;i<=n;i++) {
			if(hansoo[i]==true) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void isHansoo() {
		
		for(int i=1;i<=n;i++) {
					
			int num=i;
			String strN=String.valueOf(num);
			
			if(strN.length()<=2) {
				hansoo[num]=true;
				continue;
			}
			
			int d=(strN.charAt(0)-'0') - (strN.charAt(1)-'0'); //공차 
			hansoo[num]=true;
			
			for(int j=1; j<strN.length()-1; j++) {
				int now=strN.charAt(j)-'0';
				int post=strN.charAt(j+1)-'0';
						
				if(now-post!=d) {
					hansoo[num]=false;
					break;
				}
			}
		}
	}
}

