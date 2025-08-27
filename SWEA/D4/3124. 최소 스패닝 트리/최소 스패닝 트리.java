import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Vertex implements Comparable<Vertex> {
		int n;
		int w;

		public Vertex(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Solution.Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[v + 1]; // MST에 포함되는지 안되는지
			int[] minEdge = new int[v + 1]; // 각 정점에 연결된 최소 비용 간선
			List<Vertex>[] edgeList = new ArrayList[v + 1]; // 간선 가중치

			for (int i = 1; i < v + 1; i++) {
				edgeList[i] = new ArrayList<>();
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				edgeList[v1].add(new Vertex(v2, w));
				edgeList[v2].add(new Vertex(v1, w));
			}

			Arrays.fill(minEdge, Integer.MAX_VALUE);
			long result = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(1, 0));

			while (!pq.isEmpty()) {
				// 1. 비정점 트리 중에 최소 비용 간선 선택
				Vertex cur = pq.poll();

				if (visited[cur.n])
					continue;

				result += cur.w;
				visited[cur.n] = true;

				// 2. 선택된 노드에 연결된 간선이 기존 값보다 작을 경우 갱신
				for (int i = 0; i < edgeList[cur.n].size(); i++) {
					Vertex vertex = edgeList[cur.n].get(i);

					if (visited[vertex.n])
						continue; // 이미 MST

					if (vertex.w < minEdge[i]) {
						minEdge[i] = vertex.w;
					}

					pq.offer(new Vertex(vertex.n, vertex.w));
				}
			}

			System.out.printf("#%d %d\n", t, result);
		}
	}
}
