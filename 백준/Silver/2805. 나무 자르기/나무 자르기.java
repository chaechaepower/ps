import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		long max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		max++;

		long min = 0;
		long mid = 0;

		while (min < max) {

			mid = (min + max) / 2;

			long len = 0;

			for (int i = 0; i < n; i++) {
				if (arr[i] - mid > 0) {
					len += arr[i] - mid;
				}
			}

			if (len < m) { // 길이를 길게 설정해서 len이 작게 나왔으므로 길이를 줄여야한다.
				max = mid;
			} else { // len>=m 길이를 짧게 설정해서 len이 길게 나왔으므로 길이를 늘려야한다. 같을 때는??
				min = mid + 1;
			}
		}

		System.out.println(max - 1);

	}

}