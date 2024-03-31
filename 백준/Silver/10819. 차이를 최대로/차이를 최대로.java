import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static int[] arr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		perm(0, n - 1);
		System.out.println(max);

	}

	static void perm(int i, int n) {

		int sum = 0;

		if (i == n) {
			for (int j = 1; j <= n; j++) {
				sum += Math.abs(arr[j] - arr[j - 1]);
			}
			if (sum > max) {
				max = sum;
			}
		}

		for (int j = i; j <= n; j++) {
			int t = arr[i]; // i,j swap
			arr[i] = arr[j];
			arr[j] = t;

			perm(i + 1, n);

			t = arr[i]; // i,j swap
			arr[i] = arr[j];
			arr[j] = t;
		}
	}
}