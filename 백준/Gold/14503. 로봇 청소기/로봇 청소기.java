import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] maze;
	static int n, m;
	static int[] dr = { -1, 0, 1, 0 }; // 북동남서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int startD = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(clean(startR, startC, startD));
	}

	// 청소하는 칸의 개수 return
	static int clean(int r, int c, int d) {
		int roomCnt = 0;

		while (true) {
			if (maze[r][c] == 0) { // 청소되지 않은 경우,
				maze[r][c] = 2; // 청소한다.
				roomCnt++;
			}

			boolean isAllClean = true;
			int rotD = d;
			for (int i = 0; i < 4; i++) {
				rotD = (rotD + 3) % 4;
				

				int newR = r + dr[rotD];
				int newC = c + dc[rotD];

				if (newR < 0 || newR > n - 1 || newC < 0 || newC > m - 1) {
					continue;
				}

				if (maze[newR][newC] == 0) { // 청소되지 않은 빈 칸이 있는 경우
					r = newR;
					c = newC;
					d = rotD;
					isAllClean = false;
					break;
				}
			}

			if (isAllClean) { // 4방향이 청소된 경우
				int backD = (d + 2) % 4;
				int newR = r + dr[backD];
				int newC = c + dc[backD];

				if (newR < 0 || newR > n - 1 || newC < 0 || newC > m - 1) {
					break;
				}

				if (maze[newR][newC] != 1) {
					r = newR;
					c = newC;
				}else {
					break;
				}
			}
		}
		return roomCnt;
	}
}
