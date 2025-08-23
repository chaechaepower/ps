import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		visited = new boolean[n + 1];
		System.out.println(bfs(from, to));
	}

	private static int bfs(int from, int to) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { from, 0 });
		visited[from] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int v = cur[0];
			int cnt = cur[1];

			for (int i = 0; i < list[v].size(); i++) {
				int next = list[v].get(i);

				if (next == to) {
					return cnt + 1;
				}

				if (!visited[next]) {
					visited[next] = true;
					que.offer(new int[] { next, cnt + 1 });
				}
			}
		}

		return -1;
	}
}
