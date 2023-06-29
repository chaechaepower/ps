import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static Integer[] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new Integer[N + 1];
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = arr[1];

		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		System.out.println(recur(N));

	}

	static int recur(int n) {

		if (dp[n] == null) {

			dp[n] = Math.max(recur(n - 3) + arr[n - 1], recur(n - 2)) + arr[n];
		}

		return dp[n];
	}

}