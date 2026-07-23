import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	public int solution(int n, int[][] edge) {
		int[] dis = new int[n + 1]; // 0은 사용 x.
		Arrays.fill(dis, -1);

		List<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int[] arr : edge) {
			int v1 = arr[0];
			int v2 = arr[1];

			list[v1].add(v2);
			list[v2].add(v1);
		}

		int maxDis = Integer.MIN_VALUE;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		dis[1] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : list[now]) {
				if (dis[next] != -1) {
					continue;
				}

				dis[next] = dis[now] + 1;
				queue.offer(next);

				maxDis = Math.max(maxDis, dis[now] + 1);
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