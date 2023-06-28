import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";

		while ((str = br.readLine()) != null) {

			int[] cnt = new int[4];

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
					cnt[0]++;
				}
				if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
					cnt[1]++;
				}
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					cnt[2]++;
				}
				if (str.charAt(i) == ' ') {
					cnt[3]++;
				}
			}

			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}

	}

}