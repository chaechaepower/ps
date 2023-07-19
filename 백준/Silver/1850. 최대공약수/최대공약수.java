import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a1 = Long.parseLong(st.nextToken());
		long b1 = Long.parseLong(st.nextToken());

		long abGcd = gcd(a1, b1);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < abGcd; i++) {
			sb.append(1);
		}

		System.out.println(sb);

	}

	static long gcd(long a, long b) {

		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}