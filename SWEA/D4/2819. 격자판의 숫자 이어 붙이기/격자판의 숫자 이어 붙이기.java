import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static char[][] board;
	static Set<String> set;
	static int[] dr = { 0, 0, 1, -1 }; // 동서남북
	static int[] dc = { 1, -1, 0, 0 };
	static char[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			board = new char[4][4];
			set = new HashSet<>();

			StringTokenizer st;

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken().charAt(0);
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					seq = new char[7];
					dfs(i, j, 0);
				}
			}

			System.out.println("#" + t + " " + set.size());
		}
	}

	private static void dfs(int r, int c, int depth) {
		if (depth == 7) {
			String str = new String(seq);
			if (!set.contains(str)) {
				set.add(str);
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			seq[depth] = board[r][c];

			int nextR = r + dr[i];
			int nextC = c + dc[i];

			if (nextR < 0 || nextR >= 4 || nextC < 0 || nextC >= 4) {
				continue;
			}
			dfs(nextR, nextC, depth + 1);
		}
	}
}
