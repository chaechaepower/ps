import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] weights;
	static int n;
	static int m;
	static int maxWeight;
	static int[] combi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			weights = new int[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			combi = new int[2];
			maxWeight = -1;
			dfs(0, 0);
			
			System.out.printf("#%d %d\n", t, maxWeight);
		}
	}

	static void dfs(int depth, int v) {
		if (depth == 2) {
			int total = 0;
			for (int e : combi) {
				total += e;
			}
			
			if(total<=m) {
				maxWeight = Math.max(maxWeight, total);
			}
			return;
		}

		for (int i = v; i < n; i++) {
			combi[depth] = weights[i];
			dfs(depth + 1, i + 1);
		}
	}
}
