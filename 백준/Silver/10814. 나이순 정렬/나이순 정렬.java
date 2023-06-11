import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] idxAge = new int[N][2];
		String[] name = new String[N];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			idxAge[i][0] = i;
			idxAge[i][1] = Integer.parseInt(st.nextToken());
			name[i] = st.nextToken();
		}

		Arrays.sort(idxAge, (e1, e2) -> {
			if (e1[1] == e2[1])
				return e1[0] - e2[0];
			else
				return e1[1] - e2[1];
		});

		for (int i = 0; i < N; i++) {
			sb.append(idxAge[i][1]).append(" ").append(name[idxAge[i][0]]).append('\n');
		}

		System.out.println(sb);

	}

}