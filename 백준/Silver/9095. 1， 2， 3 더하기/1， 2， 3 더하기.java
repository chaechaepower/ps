import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(recur(n));

		}
	}

	static int recur(int i) {

		if (dp[i] == 0) {
			dp[i] = recur(i - 3) + recur(i - 2) + recur(i - 1);
		}

		return dp[i];
	}
}