import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static boolean[] visited;
	static int[] order;
	static int cnt;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		order = new int[n + 1];
		visited = new boolean[n + 1];

		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		// 오름차순 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}

		bfs(r);
		for (int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}

	}

	static void bfs(int v) {

		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		visited[v] = true;
		order[v] = ++cnt;

		while (!que.isEmpty()) {
			int x = que.poll();
			List<Integer> l = list[x];

			for (int i = l.size() - 1; i >= 0; i--) {
				int temp = l.get(i);
				if (!visited[temp]) {
					que.add(temp);
					order[temp] = ++cnt;
					visited[temp] = true;
				}
			}
		}
	}

}