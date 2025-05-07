import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			String str = br.readLine();
			int len = str.length();

			boolean isPel = true;

			for (int i = 0; i < len / 2; i++) {
				if (str.charAt(i) != str.charAt(len - 1 - i)) {
					isPel = false;
					break;
				}
			}

			System.out.printf("#%d %d\n", t, isPel ? 1 : 0);
		}
	}
}
