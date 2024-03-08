import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			sb.append(binary(Integer.parseInt(st.nextToken()), arr)).append(' ');
		}
		System.out.println(sb);

	}

	static int binary(int key, int[] arr) {
		int lo = 0;
		int hi = arr.length-1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (key < arr[mid]) {
				hi = mid - 1;
			} else if (key > arr[mid]) {
				lo = mid + 1;
			} else {
				return 1;
			}
		}
		return 0;
	}

}