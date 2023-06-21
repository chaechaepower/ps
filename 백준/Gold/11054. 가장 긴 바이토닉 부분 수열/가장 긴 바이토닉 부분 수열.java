import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static Integer[] inc;
	static Integer[] dec;
	static int[] seq;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		seq = new int[N];
		inc = new Integer[N];
		dec = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			increase(i);
			decrease(i);
		}

		int max = inc[0] + dec[0] - 1;

		for (int i = 0; i < N; i++) {
			if (inc[i] + dec[i] - 1 > max) {
				max = inc[i] + dec[i] - 1;
			}
		}

		System.out.println(max);

	}

	public static int increase(int n) {

		if (inc[n] == null) {

			inc[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (seq[i] < seq[n]) {
					inc[n] = Math.max(1 + increase(i), inc[n]);
				}
			}
		}

		return inc[n];
	}

	public static int decrease(int n) {

		if (dec[n] == null) {

			dec[n] = 1;

			for (int i = n + 1; i < seq.length; i++) {
				if (seq[i] < seq[n]) {
					dec[n] = Math.max(1 + decrease(i), dec[n]);
				}
			}
		}
		return dec[n];
	}

}