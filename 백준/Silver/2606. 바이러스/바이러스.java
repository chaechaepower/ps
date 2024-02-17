import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] arr;
	static boolean[] visited;
	static int n;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		int con = Integer.parseInt(br.readLine());
		;

		while (con-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs(1);
		System.out.println(cnt);
	}

	static void dfs(int v) {

		visited[v] = true;

		for (int i = 1; i <= n; i++) {
			if (arr[v][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}

}