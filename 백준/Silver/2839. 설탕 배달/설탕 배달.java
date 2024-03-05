import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int min = 10000000;

		for (int x = 0; x <= n / 3; x++) {
			for (int y = 0; y <= n / 5; y++) {
				if (3 * x + 5 * y == n) {
					if (x + y < min) {
						min = x + y;
					}
				}
			}
		}
		if (min == 10000000)
			min = -1;

		System.out.println(min);

	}

}