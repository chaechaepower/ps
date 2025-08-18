import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] arr;
	static List<int[]> core;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			core = new ArrayList<>();

			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (i < 1 || i > n - 2 || j < 1 || j > n - 2)
						continue;

					if (arr[i][j] == 1) {
						core.add(new int[] { i, j });
					}
				}
			}

			cnt = 0;
			sum = 0;
			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", t, sum);
		}
	}

	public static void dfs(int v, int nowCnt, int nowSum) {
		if (v == core.size()) {
			if (nowCnt == cnt) {
				sum = Math.min(nowSum, sum);
			} else if (nowCnt > cnt) {
				cnt = nowCnt;
				sum = nowSum;
			}
			return;
		}

		int r = core.get(v)[0];
		int c = core.get(v)[1];

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			boolean isPass = true;

			while (true) {
				nr += dr[d];
				nc += dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
					break;
				}

				if (arr[nr][nc] != 0) {
					isPass = false;
					break;
				}
			}

			if (isPass) {
				dfs(v + 1, nowCnt + 1, nowSum + installWire(r, c, d, 2));// 0은 빈칸, 1은 코어, 2는 전선
				installWire(r, c, d, 0);
			}
		}
		dfs(v + 1, nowCnt, nowSum);
	}

	public static int installWire(int nr, int nc, int d, int type) {
		int count = 0;

		while (true) {
			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				break;

			arr[nr][nc] = type;
			count++;
		}

		return count;
	}
}
