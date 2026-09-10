import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[][] magnetics;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int k = Integer.parseInt(br.readLine());

			StringTokenizer st;

			magnetics = new int[4][8];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 8; j++) {
					magnetics[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] rotate;

			while (k-- > 0) {
				rotate = new int[4];
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()); // n번째 자석 1~4
				int dir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계
				int idx = n - 1;
				
				rotate[idx]=dir;

				// 왼
				int leftDir = dir;

				for (int i = idx; i > 0; i--) {
					// i의 6이랑 i-1의 2랑 비교
					if (magnetics[i][6] == magnetics[i - 1][2]) {
						break;
					}

					leftDir *= -1;
					rotate[i - 1] = leftDir;
				}

				// 오
				int rightDir = dir;

				for (int i = idx; i < 3; i++) {
					// i의 2랑 i+1의 6이랑 비교
					if (magnetics[i][2] == magnetics[i + 1][6]) {
						break;
					}

					rightDir *= -1;
					rotate[i + 1] = rightDir;
				}
				
				// 회전 
				for(int i=0;i<4;i++) {
					if(rotate[i]!=0) {
						rotate(i,rotate[i]);
					}
				}
			}

			int answer = 0;

			for (int i = 0; i < 4; i++) {
				// s:1
				if (magnetics[i][0] == 0) {
					continue;
				}

				answer += Math.pow(2, i);
			}

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void rotate(int idx, int dir) {
		// 시계 방향
		if (dir == 1) {
			int last = magnetics[idx][7];

			for (int i = 7; i >= 1; i--) {
				magnetics[idx][i] = magnetics[idx][i - 1];
			}

			magnetics[idx][0] = last;
		}

		// 반시계 방향
		else {
			int first = magnetics[idx][0];

			for (int i = 0; i < 7; i++) {
				magnetics[idx][i] = magnetics[idx][i + 1];
			}

			magnetics[idx][7] = first;
		}
	}

}

/*
 * 1. n번 자석을 회전한다. 2. 양옆 자석도 영향을 받는다.
 * 
 * 자성이 다르면 회전
 * 
 */
