import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int[] dp=new int[n]; //dp[i]: i를 끝으로하는 LIS
			
			int max=0;
			for(int i=0;i<n;i++) {
				dp[i]=1;
				
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
				
				max=Math.max(max, dp[i]);
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
	}
}

