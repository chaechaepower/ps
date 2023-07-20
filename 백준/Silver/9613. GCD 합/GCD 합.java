import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			long result = 0;

			for (int j = 0; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {
					result += gcd(list.get(j), list.get(k));
				}
			}
			sb.append(result).append('\n');
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