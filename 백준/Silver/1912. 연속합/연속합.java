import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] seq;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		seq = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {

			seq[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = seq[0];

		int max = dp[0];

		for (int i = 1; i < N; i++) {

			int comp = recur(i);

			if (comp > max) {
				max = comp;
			}
		}

		System.out.println(max);

	}

	static int recur(int n) {

		if (dp[n] == null) {

			dp[n] = seq[n];

			dp[n] = Math.max(dp[n], seq[n] + recur(n - 1));
		}

		return dp[n];

	}

}