import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int vertex;
	static int edge;
	static boolean[] visited;
	static int[][] adj;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		adj = new int[vertex + 1][vertex + 1];
		visited = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		int cnt = 0;
		for (int i = 1; i < vertex + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static void dfs(int v) {

		visited[v] = true;

		for (int i = 1; i < vertex + 1; i++) {
			if (!visited[i] && adj[v][i] == 1) {
				dfs(i);
			}
		}
	}

}
