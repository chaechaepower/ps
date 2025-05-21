

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gyu;
	static int[] in;
	static int[] inSeq;
	static boolean[] visited;
	static int winCount = 0;
	static int loseCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyu = new int[9];
			boolean[] isOccuipied = new boolean[19];

			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyu[i] = num;
				isOccuipied[num] = true;
			}

			in = new int[9];
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (isOccuipied[i] == false) {
					in[idx++] = i;
				}
			}

			inSeq = new int[9];
			visited = new boolean[9];
			winCount = 0;
			loseCount = 0;
			dfs(0);

			System.out.printf("#%d %d %d\n", t, winCount, loseCount);
		}
	}

	private static void dfs(int depth) {
		if (depth == 9) {
			// 게임 시작
			game();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				inSeq[depth] = in[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static void game() {
		int gyuTotal = 0;
		int inTotal = 0;

		for (int i = 0; i < 9; i++) {
			if (gyu[i] > inSeq[i]) {
				gyuTotal += gyu[i] + inSeq[i];
			} else {
				inTotal += gyu[i] + inSeq[i];
			}
		}

		if (gyuTotal > inTotal) {
			winCount++;
		} else if (gyuTotal < inTotal) {
			loseCount++;
		}
	}
}
