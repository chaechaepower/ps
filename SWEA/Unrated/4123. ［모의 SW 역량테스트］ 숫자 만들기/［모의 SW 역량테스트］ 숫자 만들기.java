import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static char[] op = { '+', '-', '*', '/' };
	static char[] opArr, result;
	static int[] nums;
	static int n;
	static boolean[] visited;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 4; i++) {
				int cnt = Integer.parseInt(st.nextToken());

				for (int j = 0; j < cnt; j++) {
					sb.append(op[i]);
				}
			}

			opArr = sb.toString().toCharArray();

			nums = new int[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			visited = new boolean[n - 1];
			result = new char[n - 1];
			dfs(0, nums[0]);

			System.out.printf("#%d %d\n", t, max - min);
		}
	}

	private static void dfs(int depth, int now) {
		if (depth == n - 1) {
			// 최대, 최소 비교
			min = Math.min(now, min);
			max = Math.max(now, max);
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = opArr[i];
				int cal = calculate(now, depth);

				dfs(depth + 1, cal);

				visited[i] = false;
			}
		}
	}

	private static int calculate(int now, int idx) {

		switch (result[idx]) {
		
		case '+':
			now = now + nums[idx+1];
			break;
			
		case '-':
			now = now - nums[idx+1];
			break;
			
		case '*':
			now = now * nums[idx+1];
			break;
			
		case '/':
			now = now / nums[idx+1];
			break;
		}

		return now;
	}
}

/*
 * 
 * 
 * 10 5 2 1 0 1 3 5 3 7 9 6
 * 
 */
