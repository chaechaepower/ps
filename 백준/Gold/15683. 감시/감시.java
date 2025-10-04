import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 }; // 위 아래 왼 오 
	static int[] dc = { 0, 0, -1, 1 };
	static List<int[]> cctvs;
	static int minBlindArea=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		cctvs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (1 <= board[i][j] && board[i][j] <= 5) {
					cctvs.add(new int[] { i, j, board[i][j] });
				}
			}
		}
	
		dfs(0, board); 
		System.out.println(minBlindArea);
	}
	
	static int[][][] dirs= {
			{},
			{{0},{1},{2},{3}},
			{{0,1},{2,3}},
			{{0,3},{1,3},{1,2},{0,2}},
			{{0,2,3},{0,1,3},{1,2,3},{0,1,2}},
			{{0,1,2,3}}
	};

	private static void dfs(int i, int[][] board) {
		if(i==cctvs.size()) {
			minBlindArea=Math.min(minBlindArea, countBlindArea(board));
			return;
		}
		
		int[] cctv=cctvs.get(i);
		int r=cctv[0];
		int c=cctv[1];
		int type=cctv[2];
		
		for(int[] dirSet:dirs[type]) {
			int[][] copied=copyBoard(board);
			for(int dir:dirSet) {
				watch(r,c,dir,copied);
			}
			dfs(i+1,copied);
		}
	}

	private static void watch(int r, int c, int dir, int[][] board) {
		int nr=r;
		int nc=c;
		
		while(true) {
			nr+=dr[dir];
			nc+=dc[dir];
			
			if(nr<0 || nr>=n || nc<0 || nc>=m) break;
			if(board[nr][nc]==6) break;
			
			board[nr][nc]=-1;
		}
	}

	private static int countBlindArea(int[][] board) {
		int count=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j]==0) {
					count++;
				}
			}
		}
		
		return count;
	}

	private static int[][] copyBoard(int[][] origin) {
		int[][] copy=new int[n][m];
		for(int i=0;i<n;i++) {
			copy[i]=origin[i].clone();
		}
		return copy;
	}
}

/*
 * 사각지대의 최소 크기 == cctv로 최대한 많이 감시 
 * 
 * 1. 감시 방향의 모든 경우의 수 계산
 * 2. 
 * 
 * 1 -> {0},{1},{2},{3}
 * 2 -> {0,1},{2,3}
 * 3 -> {0,3},{1,3},{1,2},{0,2}
 * 4 -> {0,2,3},{0,1,3},{1,2,3},{0,1,2}
 * 5 -> {0,1,2,3}
 */

