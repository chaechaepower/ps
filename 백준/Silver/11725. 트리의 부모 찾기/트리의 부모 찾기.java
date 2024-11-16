import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static List<Integer>[] edge;
	public static boolean[] visited;
	public static int target;
	public static StringBuilder sb = new StringBuilder();
	public static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		edge = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		par = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			edge[v1].add(v2);
			edge[v2].add(v1);
		}

		dfs(1);
		for (int i = 2; i <= n; i++)
			System.out.println(par[i]);

	}

	public static void dfs(int start) {

		visited[start] = true;

		for (int e : edge[start]) {
			if (!visited[e]) {
				par[e] = start;
				dfs(e);
			}
		}
	}
}
