import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static int r, c;
	static int[] dr = { -1, 0, 1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];

		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			if(dfs(i, 0)) cnt++;
		}
		
		System.out.println(cnt);
	}

	public static boolean dfs(int row, int col) {
		arr[row][col]='x';
		
		if(col==c-1) {
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = row + dr[d];
			int nc = col + 1;

			if (nc < 0 || nc >= c || nr < 0 || nr >= r) continue;
			if (arr[nr][nc] == 'x') continue;
		
			if(dfs(nr,nc)) return true;
		}
		
		return false;
	}
}
