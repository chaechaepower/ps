import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			boolean[] isSubmit = new boolean[n + 1]; // 0제외

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				isSubmit[Integer.parseInt(st.nextToken())] = true;
			}

			System.out.printf("#%d ", t);
			for (int i = 1; i < isSubmit.length; i++) {
				if (!isSubmit[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}

}
