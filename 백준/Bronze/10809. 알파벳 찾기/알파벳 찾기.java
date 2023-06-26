import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] cnt = new int[26];

		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = -1;
		}

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {

			int idx = str.charAt(i) - 97;

			if (cnt[idx] == -1) {
				cnt[idx] = i;
			}

		}

		for (int e : cnt) {
			sb.append(e).append(" ");
		}

		System.out.println(sb);

	}

}