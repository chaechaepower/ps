import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	static class Node {
		int v;
		int dis;

		public Node(int v, int dis) {
			this.v = v;
			this.dis = dis;
		}
	}

	public int solution(int n, int[][] edge) {
		int[] dis = new int[n + 1]; // 0은 사용 x.

		List<Integer>[] list = new LinkedList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new LinkedList<>();
		}

		for (int[] arr : edge) {
			int v1 = arr[0];
			int v2 = arr[1];

			list[v1].add(v2);
			list[v2].add(v1);
		}

		int maxDis = Integer.MIN_VALUE;
		boolean[] visited = new boolean[n + 1];

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0));
		visited[1] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int next : list[now.v]) {
				if (visited[next]) {
					continue;
				}

				queue.offer(new Node(next, now.dis + 1));
				visited[next] = true;
				dis[next] = now.dis + 1;
				
				maxDis=Math.max(maxDis, now.dis + 1);
			}
		}

		int answer = 0;
		for (int d : dis) {
			if (maxDis == d) {
				answer++;
			}

			System.out.printf("%d\n", d);
		}

		return answer;
	}
}