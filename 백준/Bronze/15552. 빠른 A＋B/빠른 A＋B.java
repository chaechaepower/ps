import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int sum;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());

			sum = 0;
			sum += Integer.parseInt(st.nextToken());
			sum += Integer.parseInt(st.nextToken());

			sb.append(sum);
			sb.append('\n');

		}

		System.out.println(sb);
	}
}