import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			
			for(int k=1;k<=n+1;k++) {
				// 영역을 다 대조해본다
				int fee = k * k + (k - 1) * (k - 1);

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) { // 중심점 -> i,j

						int count = 0;

						for (int r = 0; r < n; r++) {
							for (int c = 0; c < n; c++) {

								if (Math.abs(i - r) + Math.abs(j - c) < k) {
									if (map[r][c] == 1) {
										count++;
									}
								}
							}
						}

						int result = count * m - fee;

						if (result >= 0) {
							max = Math.max(max, count);
						}
					}
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
}
