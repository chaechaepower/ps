import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[] company, home;
	static int[][] client;
	static boolean[] visited;
	static int minDis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine()); // 고객의 개수

			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new int[2];
			home = new int[2];

			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			client = new int[n][2];

			for (int i = 0; i < n; i++) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[n];
			minDis = Integer.MAX_VALUE;
			perm(0, company, 0);
			System.out.printf("#%d %d\n", t, minDis);
		}
	}

	private static void perm(int depth, int[] prev, int total) {
		if (depth == n) {
			int homeDis = Math.abs(prev[0] - home[0]) + Math.abs(prev[1] - home[1]);
			minDis = Math.min(minDis, total + homeDis);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;

			int dis = Math.abs(client[i][0] - prev[0]) + Math.abs(client[i][1] - prev[1]);
			perm(depth + 1, client[i], total + dis);

			visited[i] = false;
		}
	}
}