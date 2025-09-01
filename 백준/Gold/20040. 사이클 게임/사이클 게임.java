import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n; // 유적지 개수
	static int cnt; // 통로 개수
	static int[] parents;

	private static void makeSet() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot == yRoot)
			return false; // 사이클 발생

		parents[yRoot] = xRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n];
		makeSet();

		boolean isCycle = false;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (union(x, y)) {
				cnt++;
			} else {
				cnt++;
				isCycle = true;
				break;
			}
		}
		System.out.println(isCycle ? cnt : 0);
	}

}
