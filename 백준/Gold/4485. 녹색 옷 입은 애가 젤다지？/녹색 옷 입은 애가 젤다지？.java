import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				return;

			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("Problem %d: %d\n", cnt, dikstra());
			cnt++;
		}
	}

	private static int dikstra() {
		int[][] minList = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(minList[i], Integer.MAX_VALUE);
		}
		minList[0][0] = board[0][0];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.offer(new int[] { 0, 0, board[0][0] });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;

				if (nc == n - 1 && nr == n - 1)
					return cur[2] + board[n - 1][n - 1];

				if (cur[2] + board[nr][nc] < minList[nr][nc]) {
					minList[nr][nc] = cur[2] + board[nr][nc];
					pq.offer(new int[] { nr, nc, minList[nr][nc] });
				}
			}
		}

		return -1;
	}

}
