import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m]; // 출력 저장 배열
		visited = new boolean[n];

		perm(n, m, 0);

		System.out.println(sb);
	}

	static void perm(int n, int m, int depth) {

		if (depth == m) {
			for (int e : arr) {
				sb.append(e).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {

				if (depth > 0 && i + 1 < arr[depth - 1]) { // 지금 내가 저장하려는 수가 앞전에 저장된 수보다 작으면 저장x.
					continue;
				}

				visited[i] = true;
				arr[depth] = i + 1;
				perm(n, m, depth + 1);
				visited[i] = false;
			}
		}
	}
}