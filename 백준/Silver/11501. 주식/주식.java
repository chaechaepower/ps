import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long result = 0;
			int sum = 0;
			int cnt = 0;
			int max = arr[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (arr[i] < max) {
					sum += arr[i];
					cnt++;
				} else {
					result += cnt * max - sum;
					max = arr[i];
					sum = 0;
					cnt = 0;
				}
			}

			result += cnt * max - sum;

			System.out.println(result);
		}
	}
}
