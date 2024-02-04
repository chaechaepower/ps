import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		br.close();

		for (int i = M; i <= N; i++) {
			is_prime(i);
		}
	}

	public static void is_prime(int num) {
		if (num < 2) {
			return;
		}

		if (num == 2) {
			System.out.println(num);
			return;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return;
			}
		}

		System.out.println(num);
	}
}