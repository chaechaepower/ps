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

			int[] stations = new int[5001]; // 1~5000

			while (n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for (int i = a; i <= b; i++) {
					stations[i]++;
				}
			}

			int p = Integer.parseInt(br.readLine());

			System.out.printf("#%d ", t);
			while (p-- > 0) {
				int count = stations[Integer.parseInt(br.readLine())];
				System.out.printf("%d ", count);
			}
			System.out.println();
		}

	}
}
