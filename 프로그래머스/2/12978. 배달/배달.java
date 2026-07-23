import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}

	public int solution(int N, int[][] road, int K) {
		// 0. 인접 리스트 저장
		List<Node>[] adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int[] r : road) {
			int u = r[0];
			int v = r[1];
			int w = r[2];

			adj[u].add(new Node(v, w));
			adj[v].add(new Node(u, w));
		}

		// 1.
		int[] minList = new int[N + 1]; // 0 사용 x
		Arrays.fill(minList, Integer.MAX_VALUE);
		minList[1] = 0;

		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {

			int minCost = Integer.MAX_VALUE;
			int stopOver = -1;

			for (int j = 1; j < N + 1; j++) {
				if (visited[j]) {
					continue;
				}

				if (minList[j] < minCost) {
					minCost = minList[j];
					stopOver = j;
				}
			}

			if (stopOver == -1) {
				break;
			}
			
			visited[stopOver] = true;

			// 2.
			for (Node next : adj[stopOver]) {
				if (visited[next.to]) {
					continue;
				}

				if (minCost + next.weight < minList[next.to]) {
					minList[next.to] = minCost + next.weight;
				}
			}
		}

		int answer = 0;
		for (int min : minList) {
			if (min <= K) {
				answer++;
			}
		}

		return answer;
	}
}

/*
 * 1. 최소 거리의 노드를 찾는다. 2. 해당 노드에서 인접한 노드들의 거리를 갱신한다. (현재 거리 vs 새로 찾은 노드를 거쳐서 갔을 때
 * 거리)
 * 
 */
