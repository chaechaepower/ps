import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[n][n];

			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			int sum = 0;

			int k = 0;
			for (int i = 0; i < n / 2; i++, k++) {
				for (int j = n / 2 - k; j <= n / 2 + k; j++) {
					sum += arr[i][j] - '0';
				}
			}

			for (int j = 0; j < n; j++) {
				sum += arr[n / 2][j] - '0';
			}

			k = n / 2 - 1;
			for (int i = n / 2 + 1; i < n; i++, k--) {
				for (int j = n / 2 - k; j <= n / 2 + k; j++) {
					sum += arr[i][j] - '0';
				}
			}

			System.out.printf("#%d %d\n", t, sum);
		}
	}
}
