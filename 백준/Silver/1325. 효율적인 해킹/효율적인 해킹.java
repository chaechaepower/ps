import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static boolean[] isVisited;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			list[v1].add(v2);
		}

		cnt = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			isVisited = new boolean[n + 1];
			dfs(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			max = Math.max(max, cnt[i]);
		}

		for (int i = 1; i < n + 1; i++) {
			if (cnt[i] == max) {
				System.out.print(i + " ");
			}
		}
	}

	private static void dfs(int v) {
		isVisited[v] = true;
		
		for (int e : list[v]) {
			if (!isVisited[e]) {
				cnt[e]++;
				dfs(e);
			}
		}
	}
}
