import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s = 0;

		StringTokenizer st;
		StringBuilder sb=new StringBuilder();

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch (str) {
			case "add":
				int x = Integer.parseInt(st.nextToken());

				if ((s & 1 << x) != 0) {
					continue;
				}
				s |= (1 << x);

				break;

			case "remove":
				x = Integer.parseInt(st.nextToken());

				if ((s & 1 << x) == 0) {
					continue;
				}

				s &= ~(1 << x);

				break;

			case "check":
				x = Integer.parseInt(st.nextToken());

				if ((s & (1 << x)) != 0) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}

				break;

			case "toggle":
				x = Integer.parseInt(st.nextToken());
				s ^= (1 << x);
				break;

			case "all":
				for (int i = 1; i <= 20; i++) {
					s |= 1 << i;
				}
				break;

			case "empty":
				s = 0;
				break;
			}
		}
		
		System.out.println(sb);
	}
}
