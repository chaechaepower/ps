import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[101][101];

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					board[j][k] = 1;
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				if (board[i][j] == 1) {

					int[] dx = { -1, 1, 0, 0 };
					int[] dy = { 0, 0, -1, 1 };

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
							continue;
						}

						if (board[nx][ny] == 0) {
							cnt++;
						}
					}
				}

			}
		}

		System.out.println(cnt);
	}
}
