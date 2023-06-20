import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static Integer[] dp;
	static int[] seq;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		seq = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			recur(i);
		}

		int max = dp[0];

		for (int e : dp) {
			if (e > max) {
				max = e;
			}
		}

		System.out.println(max);

	}

	public static int recur(int n) {

		if (dp[n] == null) {

			dp[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (seq[i] > seq[n]) {
					dp[n] = Math.max(1 + dp[i], dp[n]);
				}
			}
		}
		return dp[n];
	}

}