import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1]; // 0은 사용x
			for (int i = 1; i < n + 1; i++) {
				parents[i] = i; // 자기 자신을 부모로 초기화
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int cnt=0;
			for(int i=1;i<n+1;i++) {
				if(find(i)==i) cnt++;
			}

			System.out.printf("#%d %d\n", t, cnt);
		}
	}

	private static int find(int x) { // x의 부모를 찾음
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
	}
}
