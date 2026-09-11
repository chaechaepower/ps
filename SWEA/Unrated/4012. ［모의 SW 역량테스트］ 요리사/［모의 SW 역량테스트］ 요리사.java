import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[][] arr;
	static boolean[] comb;
	static int total, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			total = 0;
			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					total += arr[i][j];
				}
			}

			comb = new boolean[n];
			answer = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void dfs(int depth, int start) {
		if (depth == n / 2) {

			int s1 = 0;
			int s2 = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {

					if (comb[i] && comb[j]) {
						s1 += arr[i][j] + arr[j][i];
					}

					else if (!comb[i] && !comb[j]) {
						s2 += arr[i][j] + arr[j][i];
					}
				}
			}

			answer = Math.min(answer, Math.abs(s2 - s1));
			return;
		}

		for (int i = start; i < n; i++) {
			comb[i] = true;

			dfs(depth + 1, i + 1);

			comb[i] = false;
		}
	}
}
