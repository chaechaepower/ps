import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] magnetic;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int k = Integer.parseInt(br.readLine());
			magnetic = new int[5][8]; // 0은 사용x. 1,2,3,4 자석

			StringTokenizer st;
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				int[] rotate = new int[5];
				rotate[idx] = dir;

				// idx 왼쪽
				for (int i = idx - 1; i > 0; i--) {
					if (magnetic[i][2] == magnetic[i + 1][6])
						break;
					rotate[i] = -rotate[i + 1];
				}

				// idx 오른쪽
				for (int i = idx + 1; i < 5; i++) {
					if (magnetic[i-1][2] == magnetic[i][6])
						break;
					rotate[i] = -rotate[i - 1];
				}

				for (int i = 1; i < 5; i++) {
					rotate(i, rotate[i]);
				}

			}

			int[] score = new int[5];
			score[1] = 1;
			score[2] = 2;
			score[3] = 4;
			score[4] = 8;

			int ans = 0;
			for (int i = 1; i < 5; i++) {
				if (magnetic[i][0] == 1) {
					ans += score[i];
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void rotate(int idx, int dir) {
		if (dir == 0)
			return;

		if (dir == 1) { // 시계
			int temp = magnetic[idx][7];
			for (int i = 7; i >= 1; i--) {
				magnetic[idx][i] = magnetic[idx][i - 1];
			}
			magnetic[idx][0] = temp;
		}

		if (dir == -1) { // 반시계
			int temp = magnetic[idx][0];
			for (int i = 0; i < 7; i++) {
				magnetic[idx][i] = magnetic[idx][i + 1];
			}
			magnetic[idx][7] = temp;
		}
	}
}
