import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static Integer[] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		dp = new Integer[N + 1];
		arr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(bf.readLine());
		}

		dp[0] = 0;
		dp[1] = arr[1];

		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]);
		}
		
		System.out.println(dp[N]);

		bf.close();
	}



}