import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder[] sbArr = new StringBuilder[201];

		for (int i = 0; i < 201; i++) {
			sbArr[i] = new StringBuilder();
		}

		StringTokenizer st;

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			sbArr[age].append(age).append(" ").append(name).append("\n");

		}

		StringBuilder sb = new StringBuilder();

		for (StringBuilder val : sbArr) {
			sb.append(val);
		}

		System.out.println(sb);

	}

}