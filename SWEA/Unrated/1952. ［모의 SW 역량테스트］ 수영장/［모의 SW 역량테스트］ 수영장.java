import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int[] costs, plans;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			costs = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}

			plans = new int[12];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}

	private static void dfs(int total, int month) {
		if (month == 12) {
			min = Math.min(min, total);
			return;
		}

		// 1일권 사용
		if (month + 1 <= 12) {
			dfs(total+plans[month] * costs[0], month + 1);
		}

		// 1달권 사용
		if (month + 1 <= 12) {
			dfs(total+costs[1], month + 1);
		}

		// 3달권 사용
		if (month + 3 <= 12) {
			dfs(total+costs[2], month + 3);
		}

		// 1년권 사용
		if (month + 12 <= 12) {
			dfs(total+costs[3], month + 12);
		}
	}
}

/*
 * 
 * 
 * 
 * 
 * 
 */
