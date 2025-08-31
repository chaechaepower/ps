import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, white, blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0,0,n);
		System.out.println(white + "\n" + blue);
	}

	private static void recur(int startR, int startC, int size) {
		
		if(size==1 || isColorSame(startR, startC, size)) {
			int color=board[startR][startC];
			
			if(color==1) blue++;
			else white++;
			return;
		}
		
		else {
			recur(startR, startC, size/2);
			recur(startR, startC+size/2, size/2);
			recur(startR+size/2, startC, size/2);
			recur(startR+size/2, startC+size/2, size/2);
		}
	}

	private static boolean isColorSame(int startR, int startC, int size) {
		
		for(int i=startR;i<startR+size;i++) {
			for(int j=startC;j<startC+size;j++) {
				if(board[startR][startC]!=board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

/*
 * 1. 정사각형 내 모든 원소가 같은지 확인 
 * 1-1. 같으면 그 색깔 +1 후 return 
 * 1-2. 다르면 n/2 나눈 뒤 호출
 * 
 */
