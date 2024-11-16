import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static boolean[] visited;
	public static List<Integer>[] edge;
	public static int m;
	public static int n;
	public static boolean exist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n];
		edge = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			edge[v1].add(v2);
			edge[v2].add(v1);
		}

		for (int i = 0; i < n; i++) {
			if (!exist) {
				dfs(1, i);
			}
		}

		if (exist)
			System.out.println(1);
		else
			System.out.println(0);

	}

	public static void dfs(int depth, int v) {
		if (depth == 5) {
			exist = true;
			return;
		}

		visited[v] = true;
		for (int e : edge[v]) {
			if (!visited[e]) {
				dfs(depth + 1, e);
			}
		}
		visited[v] = false;
	}
}
