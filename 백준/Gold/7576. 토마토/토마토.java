

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// public static boolean[][] visited;
	public static int[][] maze;
	public static Queue<int[]> queue = new LinkedList<>();
	public static int[] xDir = { 0, -1, 1, 0 };
	public static int[] yDir = { 1, 0, 0, -1 };
	public static int m;
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		maze = new int[n][m];
		// visited=new boolean[n][m];

		boolean isZero = false;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
				if (maze[i][j] == 1) {
					queue.offer(new int[] { i, j });
				} else if (maze[i][j] == 0) {
					isZero = true;
				}
			}
		}

		if (!isZero) {
			System.out.println(0);
			return;
		}

		bfs();

		if (checkZero()) {
			System.out.println(-1);
			return;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maze[i][j] > max)
					max = maze[i][j];
			}
		}
		System.out.println(max - 1);

	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int x = node[0];
			int y = node[1];

			for (int i = 0; i < 4; i++) {
				int newX = x + xDir[i];
				int newY = y + yDir[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if (maze[newX][newY] == 0) {
						queue.offer(new int[] { newX, newY });
						maze[newX][newY] = maze[x][y] + 1;
					}
				}
			}
		}
	}

	public static boolean checkZero() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maze[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
