import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Node>[] graph;
	static int m;
	static boolean[] isBasic; // true이면 중간제품
	static int[] counts;
	static int[] indegree;

	static class Node {
		int num, count;

		public Node(int y, int k) {
			super();
			this.num = y;
			this.count = k;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		isBasic = new boolean[n + 1];
		Arrays.fill(isBasic, true);
		indegree=new int[n+1];

		StringTokenizer st;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			graph[x].add(new Node(y, k));
			isBasic[x] = false;
			indegree[y]++;
		}

		counts = new int[n + 1];
		topologicalSort(n);

		for (int i = 1; i < n + 1; i++) {
			if (isBasic[i]) {
				System.out.println(i + " " + counts[i]);
			}
		}
	}

	private static void topologicalSort(int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(num, 1));
		counts[n] = 1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < graph[cur.num].size(); i++) {
				Node pre = graph[cur.num].get(i);

				counts[pre.num] += counts[cur.num] * pre.count;
				indegree[pre.num]--;
				if(indegree[pre.num]==0) queue.offer(new Node(pre.num,counts[pre.num]));
			}
		}
	}
}