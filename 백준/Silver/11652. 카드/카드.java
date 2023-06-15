import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(bf.readLine());
		}

		Arrays.sort(arr);

		int cnt = 1;
		int max = 1;
		long ans = arr[0];

		for (int i = 1; i < N; i++) {

			if (arr[i] == arr[i - 1])
				cnt++;
			else
				cnt = 1;

			if (max < cnt) {
				max = cnt;
				ans = arr[i];
			}
		}

		System.out.println(ans);

	}
}