import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Node o) {
			return this.weight-o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<Node>[] adjList = new ArrayList[V + 1]; // 각 정점으로의 최단거리
		for (int i = 1; i < V + 1; i++)
			adjList[i] = new ArrayList<>();
		int[] minCost = new int[V + 1]; // 간선 비용
		boolean[] visited = new boolean[V + 1]; // 방문 여부

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[K]=0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.to])
				continue;
			visited[cur.to] = true;

			for (Node next : adjList[cur.to]) {
				if (visited[next.to])
					continue;

				if (minCost[next.to] > cur.weight + next.weight) {
					minCost[next.to] = cur.weight + next.weight;
					pq.offer(new Node(next.to, minCost[next.to]));
				}
			}
		}
		
		
		for(int i=1;i<V+1;i++) {
			System.out.println(minCost[i]==Integer.MAX_VALUE? "INF":minCost[i]);
		}
	}
}

/*
 * 다익스트라 PQ 버전
 * 
 * 다익스트라: 특정 정점에서 다른 모든 정점까지의 최단 거리
 * 
 * 1. 비방문 정점 중 최소 비용 정점 선택 2. 그 정점과 연결된 비방문 정점의 최단 거리 갱신. 기존 거리 VS 경유지 거쳐서 가는 거리
 * 
 */
