import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return this.weight - o.weight;
		}
	}

	static int V, E;
	static Edge[] edges;
	static int[] parents;

	static void make() {
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		if (aRoot < bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= testN; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edges = new Edge[E];
			parents = new int[V+1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(from, to, weight);
			}

			Arrays.sort(edges);
			make();

			int cnt = 0;
			long result = 0;

			for (Edge edge : edges) {
				if (!union(edge.from, edge.to))
					continue;

				cnt++;
				result += edge.weight;

				if (cnt == V - 1)
					break;
			}

			System.out.printf("#%d %d\n", t, result);
		}

	}
}
