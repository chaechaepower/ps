import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int n;
	static int[] board;
	static int answer;
	static boolean isAnswer = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			board=new int[n];

			answer = 0;

			dfs(0);
			System.out.printf("#%d %d\n", t, answer);
		}
	}

	public static void dfs(int depth) {
		if (depth == n) {
			answer++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if(isPossible(depth, col)) {
				board[depth]=col;
				dfs(depth+1);
			}
		}
	}
	
	public static boolean isPossible(int row, int col) {
		for(int i=0;i<row;i++) {
			if(board[i]==col || Math.abs(i-row) == Math.abs(board[i]-col) ) {
				return false;
			}
		}
		return true;
	}
}
