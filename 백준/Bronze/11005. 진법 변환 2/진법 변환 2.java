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

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		char[] nArr = null;
		if (B > 10) {
			nArr = new char[B - 10];

			for (int i = 0; i < B - 10; i++) {
				nArr[i] = (char) ('A' + i);
			}
		}

		List<Integer> list = new ArrayList<>();

		while (N > 0) {
			int sh = N / B;
			int re = N % B;
			list.add(re);
			N = sh;
		}

		Collections.reverse(list);

		StringBuilder sb = new StringBuilder();

		for (int e : list) {
			if (e >= 10) {
				sb.append(nArr[e - 10]);
			} else {
				sb.append(e);
			}
		}

		System.out.println(sb);
	}
}