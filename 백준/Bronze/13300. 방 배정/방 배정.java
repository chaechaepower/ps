import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] students = new int[2][7]; // [i][0]은 사용 x

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			students[s][y]++;
		}

		int sum = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (students[i][j] == 0) {
					continue;
				} else if (students[i][j] < k) {
					sum++;
				} else {
					if (students[i][j] % k == 0) {
						sum += students[i][j] / k;
					} else {
						sum += students[i][j] / k + 1;
					}
				}

			}
		}

		System.out.println(sum);
	}
}
