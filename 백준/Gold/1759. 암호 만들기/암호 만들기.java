import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static char[] arr;
	static char[] result;
	static boolean[] visited;
	static int l;
	static int c;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[c];
		result = new char[l];
		visited = new boolean[c];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		dfs(0, 0);
		System.out.println(sb);
	}

	static void dfs(int at, int depth) {

		if (depth == l) {
			if (isValidLen()) {
				sb.append(result).append('\n');
			}
			return; // isValidLen()이 false여도 return
		}

		for (int i = at; i < c; i++) {
			result[depth] = arr[i];
			dfs(i + 1, depth + 1);
		}

	}

	static boolean isValidLen() {
		int mo = 0; // 모음의 개수
		int ja = 0; // 자음의 개수
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
				mo++;
			else
				ja++;

		}
		if (mo >= 1 && ja >= 2)
			return true;
		else
			return false;
	}
}