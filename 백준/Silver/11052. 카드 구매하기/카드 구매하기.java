import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(recur(N));

	}

	static int recur(int n) {

		if (dp[n] == 0) {

			for (int i = 1; i <= n; i++) {
				dp[n] = Math.max(dp[n], arr[i] + recur(n - i));
			}
		}

		return dp[n];
	}

}