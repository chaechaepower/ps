import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchN = Integer.parseInt(br.readLine());

		boolean[] switchs = new boolean[switchN + 1]; // 스위치는 1~switchN번까지

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= switchN; i++) {
			int onoff = Integer.parseInt(st.nextToken());
			switchs[i] = onoff == 1 ? true : false;
		}

		int studentN = Integer.parseInt(br.readLine());

		while (studentN-- > 0) {
			st = new StringTokenizer(br.readLine());

			int gen = Integer.parseInt(st.nextToken());
			int allo = Integer.parseInt(st.nextToken());

			if (gen == 1) { // 남
				int i = 1;
				while (true) {
					if (allo*i > switchN) {
						break;
					}
					switchs[allo*i] = !switchs[allo*i];
					i++;
				}
			}

			else { // 여
				int diff = 1;

				while (true) {
					int startI = allo - diff;
					int endI = allo + diff;

					if (startI < 1 || endI > switchN) {
						diff--;
						break;
					}

					if (switchs[startI] != switchs[endI]) {
						diff--;
						break;
					}
					diff++;
				}

				for (int i = allo - diff; i <= allo + diff; i++) {
					switchs[i] = !switchs[i];
				}

			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= switchN; i++) {

			if (i % 20 == 0) {
				sb.append(switchs[i] == true ? 1 : 0);
				sb.append('\n');
			} else {
				sb.append(switchs[i] == true ? 1 : 0);
				sb.append(' ');
			}
		}

		System.out.println(sb);
	}

}
