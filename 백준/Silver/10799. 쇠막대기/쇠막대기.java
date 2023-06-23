import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		Deque<Character> stack = new ArrayDeque<>();

		int count = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(') {

				stack.addFirst(input.charAt(i));
				continue;
			}

			if (input.charAt(i) == ')') {

				stack.pollFirst();

				if (input.charAt(i - 1) == '(') { // 레이저
					count += stack.size();
				} else {
					count++;
				}

			}
		}

		System.out.println(count);

	}

}