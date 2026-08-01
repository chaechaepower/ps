import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int maxDepth, maxNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList[101];
			for (int i = 1; i < 101; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to);
			}

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { start, 0 });

			visited = new boolean[101];
			visited[start] = true;

			maxDepth = 0;
			maxNum = Integer.MIN_VALUE;

			while (!queue.isEmpty()) {
				int[] arr = queue.poll();
				int now = arr[0];
				int depth = arr[1];

				if (depth > maxDepth) {
					maxDepth = depth;
					maxNum = now;
				} else if (depth == maxDepth) {
					maxNum = Math.max(maxNum, now);
				}

				for (int next : graph[now]) {
					if (visited[next])
						continue;

					visited[next] = true;
					queue.offer(new int[] { next, depth + 1 });
				}
			}

			System.out.printf("#%d %d\n", t, maxNum);
		}
	}
}
