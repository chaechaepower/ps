import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			List<Integer>[] list = new ArrayList[101];

			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}

			boolean[] visited = new boolean[101];
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { start, 0 });
			visited[start] = true;
			int maxDepth = 0, maxNum = 0;

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int v = now[0];
				int depth = now[1];

				for (int next : list[v]) {
					if (visited[next])
						continue;

					if (depth + 1 > maxDepth) {
						maxDepth = depth + 1;
						maxNum = next;
					} else if (depth + 1 == maxDepth) {
						maxNum = Math.max(maxNum, next);
					}

					visited[next] = true;
					queue.offer(new int[] { next, depth + 1 });
				}
			}

			System.out.printf("#%d %d\n", t, maxNum);
		}

	}
}

/*
 * 
 * 
 * 
 * 
 * 
 */
