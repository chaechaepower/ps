import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int count = 0;

		int stick = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(') {

				stick++;
				continue;
			}

			if (input.charAt(i) == ')') {

				stick--;

				if (input.charAt(i - 1) == '(') { // 레이저
					count += stick;
				} else {
					count++;
				}

			}
		}

		System.out.println(count);

	}

}