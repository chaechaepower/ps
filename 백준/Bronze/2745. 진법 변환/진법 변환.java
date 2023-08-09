import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());

		int result = 0;

		for (int i = N.length() - 1; i >= 0; i--) {
			char c = N.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				result += Math.pow(B, (N.length() - 1 - i)) * (10 + (c - 'A'));
			} else { // c >='0' && c<='9'
				result += Math.pow(B, (N.length() - 1 - i)) * (c - '0');
			}
		}
		System.out.println(result);
	}

}