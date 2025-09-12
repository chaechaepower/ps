import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n]; //dp[i]: 길이가 i+1일 때 i+1번째 자리에 위치할 수 있는 가장 작은 수
		
		int idx=0;
		dp[0]=arr[0];
		
		for(int i=1;i<n;i++) {
			if(dp[idx]<arr[i]) dp[++idx]=arr[i];
			else {
				int liIdx=lowerBound(dp,0,idx+1,arr[i]);
				dp[liIdx]=arr[i];
			}
		}
				
		System.out.println(n-(idx+1));
	}

	private static int lowerBound(int[] list, int left, int right, int key) {
		
		while(left<right) {
			int mid=(left+right)/2;
			
			if(list[mid]>=key) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return right;
	}
}
