import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];

		StringTokenizer st;
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n + 1];
		dfs(0, 1);
		System.out.println(min);
	}

	private static void dfs(int depth, int v) {
		if (depth == n / 2) {
			int diff = calculatePerformanceDiff();
			min = Math.min(diff, min);
			return;
		}

		for (int i = v; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static int calculatePerformanceDiff() {
		int[] start = new int[n / 2];
		int[] link = new int[n / 2];

		int s = 0;
		int l = 0;
		for (int i = 1; i < n + 1; i++) {
			if (visited[i]) start[s++] = i;
			else link[l++] = i;
		}

		int startSum = calculatePerformance(start);
		int linkSum = calculatePerformance(link);

		return Math.abs(startSum - linkSum);
	}

	private static int calculatePerformance(int[] team) {
		int sum = 0;

		for (int i = 0; i < n / 2 - 1; i++) {
			int v1 = team[i];
			for (int j = i + 1; j < n / 2; j++) {
				int v2 = team[j];
				
				sum += arr[v1][v2];
				sum += arr[v2][v1];
			}
		}
		
		return sum;
	}
}

/*
 * 1. 팀 나눈다. 2. 각 팀의 능력치의 합을 구한다. 3. 최소 차이를 구한다.
 */
