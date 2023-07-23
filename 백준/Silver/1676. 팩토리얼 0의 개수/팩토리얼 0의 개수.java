import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		BigInteger fac = new BigInteger("1");

		for (int i = N; i >= 1; i--) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}

		long result = 0;

		String s = fac.toString();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				result++;
			} else {
				break;
			}
		}

		System.out.println(result);

	}
}