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

		int[] arr = new int[n + 1]; // 1~n번
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int len = start + end;
			for (int i = start; i <= len / 2; i++) {
				int temp = arr[i];
				arr[i] = arr[len - i];
				arr[len - i] = temp;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
