import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] prices;// 1일, 1달, 3달, 1년
	static int[] plans;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			prices = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			plans = new int[13]; // 0은 사용x
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i < 13; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			min = prices[3]; // 1년 값으로 초기화

			dfs(0, 0); // 1달, 1일 섞음
			System.out.printf("#%d %d\n", t, min);
		}
	}

	public static void dfs(int depth, int sum) {
		if (sum >= min) {
			return;
		}

		if (depth > 12) {
			min = Math.min(min, sum);
			return;
		}

		if (plans[depth] == 0) {
			dfs(depth + 1, sum);
		}

		else {
			dfs(depth + 1, sum + plans[depth] * prices[0]); // 1일
			dfs(depth + 1, sum + prices[1]); // 1달
			dfs(depth + 3, sum + prices[2]); // 3달
		}
	}
}
