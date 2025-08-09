import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, l; // n은 재료 수, l은 제한 칼로리
	static int[][] ingridents; // 재료 정보 (맛, 칼로리)
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			ingridents = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				ingridents[i][0] = Integer.parseInt(st.nextToken());
				ingridents[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			dfs(0,0,0);
			System.out.printf("#%d %d\n",t,max);
		}
	}

	public static void dfs(int i, int calSum, int tasteSum) {
		if (calSum >= l) {
			return;
		}

		if (i == n) {
			max = Math.max(max, tasteSum);
			return;
		}

		dfs(i + 1, calSum + ingridents[i][1], tasteSum + ingridents[i][0]);
		dfs(i + 1, calSum, tasteSum);
	}
}

