import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];

		if(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(M-->0) {
				broken[Integer.parseInt(st.nextToken())]=true;
			}
		}

		int min = Math.abs(N - 100);

		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);

			boolean isBreak = false;
			for (int j = 0; j < str.length(); j++) { // 탐색하고자하는 숫자에 고장난 버튼의 수가 포함되었는지 조사
				if (broken[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}

			if (!isBreak) {
				int result = str.length() + Math.abs(N - i);
				min = Math.min(min, result);
			}
		}

		System.out.println(min);

	}
}