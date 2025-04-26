import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long max=arr[n-1];
			long sum=0;
			long result=0;
			int count=0;
			
			for(int i=n-2;i>=0;i--) {
				if(arr[i]<=max) {
					sum+=arr[i];
					count++;
				}
				else {
					result+=max*count-sum;
					count=0;
					sum=0;
					max=arr[i];
				}
			}
			
			if(sum>0) {
				result+=max*count-sum;
			}
			
			printer(tc, result);
		}

		System.out.println(sb);
	}

	public static void printer(int testI, long result) {
		sb.append('#').append(testI).append(' ').append(result).append('\n');
	}
}
