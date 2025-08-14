import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];

			ans = 0;
			dfs(0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	public static void dfs(int depth) {
		if (depth == n) {
			ans++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isPossible(depth, col)) {
				arr[depth] = col;
				dfs(depth + 1);
			}
		}
	}

	public static boolean isPossible(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (arr[i] == col || Math.abs(i - row) == Math.abs(arr[i] - col)) {
				return false;
			}
		}
		return true;
	}

}
