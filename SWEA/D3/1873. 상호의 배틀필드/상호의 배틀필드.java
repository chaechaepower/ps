import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static char[][] board;
	static int h;
	static int w;
	static int curR;
	static int curC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			board = new char[h][w];

			for (int i = 0; i < h; i++) {
				char[] arr = br.readLine().toCharArray();

				for (int j = 0; j < w; j++) {
					board[i][j] = arr[j];

					if (board[i][j] == '^' || board[i][j] == 'v' || board[i][j] == '<' || board[i][j] == '>') {
						curR = i;
						curC = j;
					}
				}
			}

			int promptN = Integer.parseInt(br.readLine());

			for (char prompt : br.readLine().toCharArray()) {
				switch (prompt) {
				case 'U':
					move('^');
					break;
				case 'D':
					move('v');
					break;
				case 'L':
					move('<');
					break;
				case 'R':
					move('>');
					break;
				case 'S':
					char curDir = board[curR][curC];
					shoot(curR + dr[findDelIdx(curDir)], curC + dc[findDelIdx(curDir)], curDir);
					break;
				}
			}
			
			System.out.printf("#%d ",t);
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static int findDelIdx(char dir) {
		switch (dir) {
		case '^':
			return 0;
		case 'v':
			return 1;
		case '<':
			return 2;
		case '>':
			return 3;
		default:
			return -1;
		}
	}

	private static void move(char dir) {
		board[curR][curC] = dir;

		int tarR = curR + dr[findDelIdx(dir)];
		int tarC = curC + dc[findDelIdx(dir)];

		if (tarR < 0 || tarR >= h || tarC < 0 || tarC >= w) {
			return;
		}

		if (board[tarR][tarC] == '.') {
			board[curR][curC] = '.';
			curR = tarR;
			curC = tarC;
			board[curR][curC] = dir;
		}
	}

	private static void shoot(int tarR, int tarC, char dir) {
		if (tarR < 0 || tarR >= h || tarC < 0 || tarC >= w) {
			return;
		}

		if (board[tarR][tarC] == '#') {
			return;
		}

		if (board[tarR][tarC] == '*') {
			board[tarR][tarC] = '.';
			return;
		}

		shoot(tarR + dr[findDelIdx(dir)], tarC + dc[findDelIdx(dir)], dir);
	}
}
