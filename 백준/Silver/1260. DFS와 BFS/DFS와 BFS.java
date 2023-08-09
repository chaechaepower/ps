import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int verN = Integer.parseInt(st.nextToken());
		int edgeN = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		graph = new LinkedList[verN + 1];

		for (int i = 0; i < verN + 1; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < edgeN; i++) {

			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

		}

		for (LinkedList l : graph) {
			Collections.sort(l);
		}

		visited = new boolean[verN + 1];
		dfs(start);
		System.out.println();
		visited = new boolean[verN + 1];
		bfs(start);

	}

	static void dfs(int v) {

		visited[v] = true;

		System.out.print(v + " ");

		for (int e:graph[v]) {
			if (!visited[e]) {
				dfs(e);
			}

		}

	}

	static void bfs(int v) {

		Queue<Integer> queue = new LinkedList<>();

		System.out.print(v + " ");
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			v = queue.poll();

			for (int e : graph[v]) {
				if (!visited[e]) {
					System.out.print(e + " ");
					queue.add(e);
					visited[e] = true;
				}
			}
		}

	}

}