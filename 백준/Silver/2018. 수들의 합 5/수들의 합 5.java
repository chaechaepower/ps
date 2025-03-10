import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int cnt=0;
		
		for(int i=1;i<=n;i++) {
			int start=i;
			int sum=0;
			
			for(int j=start; j<=n; j++) {
				sum+=j;
				if(sum>n) {
					break;
				}
				
				if(sum==n) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}



 