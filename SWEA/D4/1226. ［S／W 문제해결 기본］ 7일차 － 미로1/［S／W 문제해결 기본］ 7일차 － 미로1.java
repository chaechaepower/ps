import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static boolean[][] visited;
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0, };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			br.readLine(); // 테스트 번호 스킵

			board = new char[16][16];
			for (int i = 0; i < 16; i++) {
				board[i] = br.readLine().toCharArray();
			}

			visited = new boolean[16][16];
			System.out.printf("#%d %d\n", t+1, bfs());
		}
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, 1 });
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int d = 0; d < 4; d++) {
				int nextX = nowX + dx[d];
				int nextY = nowY + dy[d];

				// 범위 
				if (nextX < 0 || nextX >= 16 || nextY < 0 || nextY >= 16) {
					continue;
				}
				
				// 방문 여부 
				if (visited[nextX][nextY]) {
					continue;
				}
				
				// 벽 
				if(board[nextX][nextY]=='1') {
					continue;
				}

				// 도착 확인 
				if (board[nextX][nextY]=='3') {
					return 1;
				}

				queue.offer(new int[] { nextX, nextY });
				visited[nextX][nextY] = true;
			}
		}
		
		return 0;
	}
}
