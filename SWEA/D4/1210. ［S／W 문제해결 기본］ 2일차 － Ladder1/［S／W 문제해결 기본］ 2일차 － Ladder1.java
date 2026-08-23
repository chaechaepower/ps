import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };
	static int targetR, targetC;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			br.readLine();

			int[][] board = new int[100][100];

			StringTokenizer st;

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

					if (board[i][j] == 2) {
						targetR = i;
						targetC = j;
					}
				}
			}

			// 여기에 작성
			int nowR = targetR;
			int nowC = targetC;
			boolean[][] visited=new boolean[100][100];
			visited[nowR][nowC]=true;

			while (true) {
				// 종료 조건
				if (nowR == 0) {
					System.out.printf("#%d %d\n", t, nowC);
					break;
				}

				// 좌, 우 길 확인
				boolean isConvert = false;

				for (int d = 0; d < 2; d++) {
					int nextR = nowR + dr[d];
					int nextC = nowC + dc[d];

					if (nextC < 0 || nextC >= 100) {
						continue;
					}
					
					if(visited[nextR][nextC]) {
						continue;
					}

					if (board[nextR][nextC] == 1) {
						nowR = nextR;
						nowC = nextC;
						visited[nowR][nowC]=true;
						isConvert = true;
						break;
					}
				}

				if (isConvert) {
					continue;
				}

				nowR += dr[2];
				nowC += dc[2];
				visited[nowR][nowC]=true;
			}

		}
	}
}
