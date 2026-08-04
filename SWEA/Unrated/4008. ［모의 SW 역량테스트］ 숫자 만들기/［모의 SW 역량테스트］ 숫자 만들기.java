import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[] values;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine()); // 숫자의 개수

			StringTokenizer st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int multiply = Integer.parseInt(st.nextToken());
			int divide = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			values = new int[n];
			for (int i = 0; i < n; i++) {
				values[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(1, values[0], plus, minus, multiply, divide);
			System.out.printf("#%d %d\n", t, max - min);
		}
	}

	private static void dfs(int idx, int sum, int plus, int minus, int multiply, int divide) {
		if (idx == n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		if (plus > 0) {
			dfs(idx + 1, sum + values[idx], plus - 1, minus, multiply, divide);
		}

		if (minus > 0) {
			dfs(idx + 1, sum - values[idx], plus, minus - 1, multiply, divide);
		}

		if (multiply > 0) {
			dfs(idx + 1, sum * values[idx], plus, minus, multiply - 1, divide);
		}

		if (divide > 0) {
			dfs(idx + 1, sum / values[idx], plus, minus, multiply, divide - 1);
		}
	}
}
