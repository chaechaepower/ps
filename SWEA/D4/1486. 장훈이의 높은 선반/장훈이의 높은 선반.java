import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, b;
	static int[] arr;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, min - b);
		}
	}

	public static void dfs(int v, int depth, int sum) {
		if (depth == n) {
			if (sum >= b) {
				min = Math.min(min, sum);
			}
			return;
		}

		if (sum >= b) {
			min = Math.min(min, sum);
			return;
		}

		dfs(v + 1, depth + 1, sum + arr[v]);
		dfs(v + 1, depth + 1, sum);
	}
}
