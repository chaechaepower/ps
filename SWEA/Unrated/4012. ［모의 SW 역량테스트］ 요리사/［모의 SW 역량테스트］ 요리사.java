import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[][] arr;
	static boolean[] group;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			group = new boolean[n];
			min = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}

	private static void comb(int start, int cnt) {
		if (cnt == n / 2) {
			// 시너지 계산
			int aSum = 0, bSum = 0;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {

					if (group[i] && group[j]) {
						aSum += arr[i][j] + arr[j][i];
					} 
					else if (!group[i] && !group[j]) {
						bSum += arr[i][j] + arr[j][i];
					}
				}
			}

			min = Math.min(min, Math.abs(aSum - bSum));

			return;
		}

		for (int i = start; i < n; i++) {
			group[i] = true;
			comb(i + 1, cnt + 1);
			group[i] = false;
		}
	}
}

/*
 * 
 * a음식, b음식의 조합
 * 
 * 시너지의 합을 구하고 차이가 가장 작도록
 * 
 */
