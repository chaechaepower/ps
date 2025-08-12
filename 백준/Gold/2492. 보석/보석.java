import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Point[] jewels = new Point[t];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int total = 0;
		int ansX = 0;
		int ansY = 0;

		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				int x = jewels[i].x + k > n ? n - k : jewels[i].x;
				int y = jewels[j].y + k > m ? m - k : jewels[j].y;
				int x2 = x + k;
				int y2 = y + k;

				int cnt = 0;

				for (int l = 0; l < t; l++) {
					if (jewels[l].x >= x && jewels[l].x <= x2 && jewels[l].y >= y && jewels[l].y <= y2) {
						cnt++;
					}
				}

				if (cnt > total) {
					total = cnt;
					ansX = x;
					ansY = y2;
				}
			}
		}

		System.out.printf("%d %d\n%d", ansX, ansY, total);
	}
}
