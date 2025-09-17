import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int no, weight;

		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int n;
	static List<Node>[] adjList;
	static List<Node>[] reverseAdjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 마을 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int x = Integer.parseInt(st.nextToken()); // 파티 마을

		// 인접 배열, 방문 배열, 최소 비용 배열, pq
		adjList = new ArrayList[n + 1];
		reverseAdjList = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
			reverseAdjList[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
			reverseAdjList[v].add(new Node(u, w));
		}

		/*
		 * 다익스트라 1. 미방문 정점 중 최단 비용인 정점을 선택 2. 해당 정점과 연결된 다른 미방문 정점의 비용 갱신(경유지 거쳐서 가기 vs
		 * 기존 비용)
		 */

		int[] partyToVil = dijkstra(adjList, x);
		int[] vilToParty = dijkstra(reverseAdjList, x);

		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			int total = partyToVil[i] + vilToParty[i];
			max = Math.max(max, total);
		}

		System.out.println(max);
	}

	private static int[] dijkstra(List<Node>[] adj, int start) {
		boolean[] visited = new boolean[n + 1];

		int[] minList = new int[n + 1];
		Arrays.fill(minList, Integer.MAX_VALUE);
		minList[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.no])
				continue;

			visited[cur.no] = true;

			for (Node next : adj[cur.no]) {
				if (visited[next.no])
					continue;

				if (cur.weight + next.weight < minList[next.no]) {
					minList[next.no] = cur.weight + next.weight;
					pq.offer(new Node(next.no, minList[next.no]));
				}
			}
		}

		return minList;
	}

}

/*
 * 자기 마을 ~ x번 마을까지 가는 데 걸리는 최단 시간 x번 마을 ~ 자기 마을까지 돌아오는 데 걸리는 최단 시간
 * 
 */
