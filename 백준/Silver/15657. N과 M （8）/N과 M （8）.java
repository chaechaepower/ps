import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static int[] input;
	static int[] result;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		result = new int[m];
		input = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		dfs(0, 0);

		System.out.println(sb);
	}

	static void dfs(int at, int depth) {
		if (depth == m) {
			for (int e : result) {
				sb.append(e).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i < n; i++) {
			result[depth] = input[i];
			dfs(i, depth + 1);
		}
	}
}