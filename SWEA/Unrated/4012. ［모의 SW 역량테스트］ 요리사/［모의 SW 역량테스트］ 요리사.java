import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[][] synergy;
	static boolean[] result;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			synergy = new int[n][n];

			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			result = new boolean[n];
			comb(0, 0);

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void comb(int depth, int start) {
		if (depth == n / 2) {
			int diff = calSynergy();
			answer = Math.min(answer, diff);
			return;
		}

		for (int i = start; i < n; i++) {
			result[i] = true;

			comb(depth + 1, i + 1);

			result[i] = false;
		}
	}

	private static int calSynergy() {
		int aSum = 0, bSum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (result[i] && result[j]) {
					aSum += synergy[i][j] + synergy[j][i];
				}

				if (!result[i] && !result[j]) {
					bSum += synergy[i][j] + synergy[j][i];
				}
			}
		}

		return Math.abs(aSum - bSum);
	}
}
