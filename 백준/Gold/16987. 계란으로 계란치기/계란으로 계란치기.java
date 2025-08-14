import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		dfs(0,0);
		System.out.println(max);
	}

	public static void dfs(int depth, int sum) {	
		if (depth == n) {
			max = Math.max(max, sum);
			return;
		}
		
		if(arr[depth][0]<=0 || sum==n-1) {
			dfs(depth+1,sum);
			return;
		}

		int preSum=sum;
		
		for (int i = 0; i < n; i++) {
			if (i != depth && arr[i][0]>0) {
				arr[i][0] -= arr[depth][1];
				arr[depth][0] -= arr[i][1];
			
				if(arr[i][0] <= 0) {
					sum++;
				}
				if(arr[depth][0] <= 0) {
					sum++;
				}
				
				dfs(depth + 1, sum);
				
				arr[i][0] += arr[depth][1];
				arr[depth][0] += arr[i][1];
				sum=preSum;
			}
		}
	}
}
