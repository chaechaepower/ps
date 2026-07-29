import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n, l, answer;
	static int[] arr;
	static int[][] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 재료 수
			l = Integer.parseInt(st.nextToken()); // 제한 칼로리

			ingredients = new int[n][2]; // 0:맛, 1: 칼로리
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MIN_VALUE;

			subset(0, 0, 0);
			System.out.printf("#%d %d\n", t, answer);
		}
	}

	public static void subset(int idx, int kalSum, int tasteSum) {
		if (kalSum > l) {
			return;
		}

		if (idx == n) {
			answer = Math.max(tasteSum, answer);
			return;
		}

		subset(idx + 1, kalSum + ingredients[idx][1], tasteSum + ingredients[idx][0]);
		subset(idx + 1, kalSum, tasteSum);
	}
}
