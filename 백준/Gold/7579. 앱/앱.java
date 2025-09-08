import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] bytes = new int[n+1];
		int[] costs = new int[n+1];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 1; i < n+1; i++) {
			bytes[i] = Integer.parseInt(st1.nextToken());
			costs[i] = Integer.parseInt(st2.nextToken());
		}

		int[][] dp = new int[n+1][10001]; // dp[i][c]: 1~i까지 고려했을 때 비용을 c만큼 사용하여 만들 수 있는 최대 메모리
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < n+1; i++) {
			for (int c = 0; c < 10001; c++) {
				
				if (costs[i] > c) {
					dp[i][c] = dp[i - 1][c];
					continue;
				}

				dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - costs[i]] + bytes[i]);


				if(dp[i][c]>=m) {
					min = Math.min(min, c);
				}
			}
		}

		System.out.println(min);
	}
}
