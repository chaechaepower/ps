import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static int n;
	static int m;
	static int[] arr; // 출력 위한 배열
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new boolean[n];

		dfs(0);

		System.out.println(sb);

	}

	static void dfs(int depth) {

		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (depth==0 || i + 1 > arr[depth-1]) { // 이전에 저장된 요소보다 크거나 첫 번째 저장될 요소여야함.
					visited[i] = true;
					arr[depth] = i + 1;
					dfs(depth + 1);
					visited[i] = false;
				}

			}
		}

	}
}