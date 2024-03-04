import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] counting = new int[20000001];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			counting[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int cnt = counting[Integer.parseInt(st.nextToken()) + 10000000];
			sb.append(cnt).append(' ');
		}

		System.out.println(sb);
	}

}