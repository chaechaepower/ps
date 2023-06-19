import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {

			sb.append(solve(br.readLine())).append('\n');
		}

		System.out.println(sb);

	}

	public static String solve(String ps) {

		int count = 0;

		for (char c : ps.toCharArray()) {

			if (c == '(') {
				count++;
			}

			else if (count == 0) {
				return "NO";
			}

			else {
				count--;
			}

		}

		if (count == 0) {
			return "YES";
		} else {
			return "NO";

		}
	}

}