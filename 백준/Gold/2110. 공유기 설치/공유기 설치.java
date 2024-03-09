import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] home = new int[n];

		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		System.out.println(upperBound(c, home) - 1);

	}

	static int upperBound(int c, int[] home) {
		int lo = 1; // 공유기 사이 최소 거리의 최솟값
		int hi = home[home.length - 1] - home[0] + 1; // 공유기 사이 최소 거리의 최댓값+1

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (c <= canInstall(mid, home)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

	static int canInstall(int len, int[] home) {
		int cnt = 1;
		int lastIndex = home[0];

		for (int i = 1; i < home.length; i++) {
			if (home[i] - lastIndex >= len) {
				cnt++;
				lastIndex = home[i];
			}
		}
		return cnt;
	}
}