import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static class Node {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}

	public int solution(int N, int[][] road, int K) {
		List<Node>[] adj = new ArrayList[N + 1]; // 0 사용 x
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

		int[] minDis = new int[N + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		minDis[1] = 0;

		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			int stopOver = -1;
			int minCost = Integer.MAX_VALUE;

			for (int j = 1; j < N + 1; j++) {
				if (visited[j]) {
					continue;
				}

				if (minDis[j] < minCost) {
					minCost = minDis[j];
					stopOver = j;
				}
			}

			if (stopOver == -1)
				break;
			
			visited[stopOver] = true;

			for (Node next : adj[stopOver]) {
				if (minCost + next.weight < minDis[next.to]) {
					minDis[next.to] = minCost + next.weight;
				}
			}
		}

		int answer = 0;
		for (int min : minDis) {
			if (min <= K) {
				answer++;
			}
		}

		return answer;
	}

}

/*
 * 1. 인접리스트로 그래프 정보 저장 2. 1번 마을에서 다른 마을까지의 거리 배열. 1번 마을의 거리만 0으로 초기화 3. 가장 짧은
 * 거리의 마을 선택 4. 해당 마을에서 다른 마을까지의 거리 < 기존 다른 마을 거리 비교
 * 
 */
