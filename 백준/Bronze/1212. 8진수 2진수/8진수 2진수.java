import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		StringBuilder sb = new StringBuilder();

		String[] arr = { "000", "001", "010", "011", "100", "101", "110", "111" };

		if (N.equals("0")) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N.length(); i++) {
			sb.append(arr[N.charAt(i) - '0']);
		}

		while (sb.charAt(0) == '0') {
			sb = new StringBuilder(sb.substring(1));
		}

		System.out.println(sb);

	}

}