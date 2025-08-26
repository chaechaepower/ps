import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static int n;
	static Edge[] edges;
	static int[] parents;

	static void make() {
		for (int i = 1; i < n; i++) {
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

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine()); // 섬의 개수
			int[] x = new int[n];
			int[] y = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			double tax = Double.parseDouble(br.readLine());

			edges = new Edge[n * (n - 1) / 2];
			parents = new int[n];

			int idx = 0;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					int x1 = x[i], y1 = y[i];
					int x2 = x[j], y2 = y[j];
					double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

					edges[idx++] = new Edge(i, j, Math.pow(distance, 2));
				}
			}

			Arrays.sort(edges);
			make();

			int cnt = 0;
			double result = 0;

			for (Edge edge : edges) {
				if (!union(edge.from, edge.to))
					continue;

				cnt++;
				result += edge.weight;

				if (cnt == n - 1)
					break;
			}

			double ans=result * tax;
			System.out.printf("#%d %d\n",t,Math.round(ans));
		}

	}
}
