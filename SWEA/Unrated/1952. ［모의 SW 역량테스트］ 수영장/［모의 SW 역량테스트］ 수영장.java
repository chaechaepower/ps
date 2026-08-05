import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] prices;
	static int[] plans;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			prices = new int[4];
			plans = new int[12];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void dfs(int month, int total) {
		if (month == 12) {
			answer = Math.min(total, answer);
			return;
		}

		// 1일권
		if (month + 1 <= 12) {
			dfs(month + 1, total + prices[0] * plans[month]);
		}
		// 1달권
		if (month + 1 <= 12) {
			dfs(month + 1, total + prices[1]);
		}
		// 3달권
		if (month + 3 <= 12) {
			dfs(month + 3, total + prices[2]);
		}
		// 1년권
		if (month <= 12) {
			dfs(12, total + prices[3]);
		}
	}
}
