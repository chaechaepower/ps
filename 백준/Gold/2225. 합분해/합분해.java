import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N + 1][K + 1];

		for (int i = 1; i <= K; i++) {
			dp[0][i] = 1L;
		}

		for (int i = 1; i <= N; i++) {
			dp[i][1] = 1L;
		}

		if (K >= 2) {
			for (int i = 1; i <= N; i++) {
				dp[i][2] = (long) (i + 1);
			}
		}

		for (int i = 3; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k <= j; k++) {
					dp[j][i] += dp[k][i - 1] % 1000000000;
				}
			}
		}
		System.out.println(dp[N][K] % 1000000000);
	}
}