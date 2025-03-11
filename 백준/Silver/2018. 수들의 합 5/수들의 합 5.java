import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int cnt=1;
		int start=1;
		int end=1;
		int sum=1;
		
		while(start<n) {
			if(sum<n) {
				end++;
				sum+=end;
			}
			else if(sum>n) {
				sum-=start;
				start++;
			}  
			else { //sum==n
				cnt++;
				end++;
				sum+=end;
			}
		}
		
		
		System.out.println(cnt);
	}
}


