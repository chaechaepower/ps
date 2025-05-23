import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			int rem;
			boolean isValid=true;
			
			while(n-->0) {
				rem=m%2;
				if(rem==0) {
					isValid=false;
					break;
				}
				m/=2;
			}
			
			System.out.printf("#%d ",t);
			if(isValid) {
				System.out.println("ON");
			}
			else {
				System.out.println("OFF");
			}
		}
	}

}
