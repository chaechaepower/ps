import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list, (e1, e2) -> e2 - e1);

			int total = 0;
			int discount = 0;

			for (int i = 0; i < n; i++) {
				total += list.get(i);

				if ((i - 2) % 3 == 0) {
					discount += list.get(i);
				}
			}

			System.out.printf("#%d %d\n", t, total - discount);
		}
	}
}