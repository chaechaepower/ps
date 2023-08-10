import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		StringBuilder sb = new StringBuilder();

		if (N.length() % 3 == 1) {
			sb.append(N.charAt(0) - '0');
		}
		if (N.length() % 3 == 2) {
			sb.append(2 * (N.charAt(0) - '0') + N.charAt(1) - '0');
		}

		for (int i = N.length() % 3; i < N.length(); i += 3) {
			sb.append(4 * (N.charAt(i) - '0') + 2 * (N.charAt(i + 1) - '0') + N.charAt(i + 2) - '0');
		}

		System.out.println(sb);
	}

}