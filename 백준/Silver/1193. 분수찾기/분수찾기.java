import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int result = 0;
		int i = 0;

		while (true) {
			++i;
			result += i;

			if (x <= result)
				break;
		}

		if (i % 2 == 0) {
			System.out.println((i - (result - x)) + "/" + (1 + (result - x)));
		} else {
			System.out.println((1 + (result - x)) + "/" + (i - (result - x)));
		}

	}
}