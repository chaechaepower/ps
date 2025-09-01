import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		List<Node>[] adjList = new ArrayList[V + 1]; /// 인접 리스트
		for (int i = 1; i < V + 1; i++)
			adjList[i] = new ArrayList<>();

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
		}

		boolean[] visited = new boolean[V + 1];
		int[] minList = new int[V + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(minList, INF);
		minList[start] = 0;

		for (int i = 0; i < V; i++) {
			int minCost = Integer.MAX_VALUE;
			int stopOver = -1;

			// 1. 방문하지 않은 정점 중 최소 비용 정점 선택
			for (int j = 1; j < V + 1; j++) {
				if (visited[j])
					continue;

				if (minList[j] < minCost) {
					minCost = minList[j];
					stopOver = j;
				}
			}

			if (stopOver == -1) {
				break;
			}

			visited[stopOver] = true;

			// 2. 그 정점과 연결된 비방문 정점에 대해 거리 비교 후 작은 값으로 갱신
			for (Node node : adjList[stopOver]) {
				if (visited[node.to])
					continue;

				if (minCost + node.weight < minList[node.to]) {
					minList[node.to] = minCost + node.weight;
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			System.out.println(minList[i] == INF ? "INF" : minList[i]);
		}
	}
}
