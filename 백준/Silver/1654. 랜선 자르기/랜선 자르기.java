import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		long max = 0;

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		max++;

		long min = 0;
		long mid = 0;

		while (min < max) {
			mid = (min + max) / 2;

			long cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}

			if (n > cnt) {
				max = mid;
			} else {
				min = mid + 1;
			}

		}

		System.out.println(min-1); //upper bound를 구한 값이므로 즉, 초과갑을 구함. -1을 해줘야한다.

	}

}