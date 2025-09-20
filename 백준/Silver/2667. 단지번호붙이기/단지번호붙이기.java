import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int n, groups; // n, 단지수
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();

			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					groups++;
					dfs(i, j);
				}
			}
		}

		int[] counts=new int[groups+1]; //1~group번 단지의 집의 수
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0) {
					counts[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(counts);

		System.out.println(groups);
		for(int i=1;i<counts.length;i++) {
			System.out.println(counts[i]);
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		map[r][c]=groups;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;

			if (!visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}

/*
 * 연결된 그래프의 개수 - 각 그래프의 노드 수
 * 
 */
