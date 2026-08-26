import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static List<Integer>[] edge;
	static boolean[] visited;
	static boolean isPossible;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());

			edge = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				edge[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				int u = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edge[u].add(w);
			}

			visited = new boolean[101];
			isPossible = false;
			dfs(0);
			System.out.printf("#%d %d\n", t, isPossible ? 1 : 0);
		}
	}

	private static void dfs(int v) {
		if (v == 99) {
			isPossible = true;
			return;
		}

		visited[v] = true;

		for (int next : edge[v]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}