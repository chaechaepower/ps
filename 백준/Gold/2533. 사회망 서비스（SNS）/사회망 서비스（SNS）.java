import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int n;
		Node next;

		public Node(int n, Main.Node next) {
			super();
			this.n = n;
			this.next = next;
		}
	}

	static int n;
	static Node[] tree;
	static int[][] dp; // dp[i][0]: i가 얼리어답터가 아닐 때 필요한 최소 얼리어답터의 개수, dp[i][1]: i가 얼리어답터일 때 필요한 최소 얼리어답터의 개수
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		tree = new Node[n + 1];
		StringTokenizer st;

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			tree[u] = new Node(v, tree[u]);
			tree[v] = new Node(u, tree[v]);
		}

		dp = new int[n + 1][2];
		visited = new boolean[n + 1];
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void dfs(int v) {
		visited[v] = true;
		dp[v][0] = 0;
		dp[v][1] = 1;

		for (Node next = tree[v]; next != null; next = next.next) {
			if (!visited[next.n]) {
				dfs(next.n);
				dp[v][0]+=dp[next.n][1]; // 부모가 얼리어답터가 아니면 자식이 무조건 얼리어답터
				dp[v][1]+=Math.min(dp[next.n][0], dp[next.n][1]); // 부모가 얼리어답터이면 자식은 얼리어답터여도 되고 아니여도 됨. 
			}
		}
	}

}
