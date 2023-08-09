import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		if (N.equals("0")) {
			System.out.println(0);
			return;
		}

		// 2 to 10

		List<Integer> oct = new ArrayList<>();

		for (int i = N.length() - 1; i >= 0; i -= 3) {
			int tmp = 1;
			String part = null;

			if (i == 0) {
				part = "00";
				part += N.substring(i, i + 1);
			} else if (i == 1) {
				part = "0";
				part += N.substring(i - 1, i + 1);

			} else {
				part = N.substring(i - 2, i + 1);
			}

			int sum = 0;
			for (int j = 2; j >= 0; j--) {
				char c = part.charAt(j);

				if (c == '0') {
				} else { // c=='1'
					sum += tmp;
				}
				tmp *= 2;
			}
			oct.add(sum);
		}

		for (int i = oct.size() - 1; i >= 0; i--) {
			System.out.print(oct.get(i));
		}
	}

}