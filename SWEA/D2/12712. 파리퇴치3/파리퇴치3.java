import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			int[][] board=new int[n][n];
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			max=Integer.MIN_VALUE;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					calculateMosquito(board,i,j,n,m);
				}
			}
			System.out.printf("#%d %d\n",t,max);
		}
	}
	
	private static void calculateMosquito(int[][] board, int r,int c, int n, int m) { //노즐 중심 좌표
		//+
		int plusSum=board[r][c];
		for(int i=1;i<m;i++) {
			if(c-i>=0 && c-i<n) {
				plusSum+=board[r][c-i];
			}
			if(r-i>=0 && r-i<n) {
				plusSum+=board[r-i][c];
			}
			if(r+i>=0 && r+i<n) {
				plusSum+=board[r+i][c];
			}
			if(c+i>=0 && c+i<n) {
				plusSum+=board[r][c+i];
			}
		}
		
		//x
		int multiplySum=board[r][c];
		
		for(int i=1;i<m;i++) {
			if(r-i>=0 && r-i <n && c-i>=0 && c-i <n) {
				multiplySum+=board[r-i][c-i];
			}
			if(r-i>=0 && r-i <n && c+i>=0 && c+i <n) {
				multiplySum+=board[r-i][c+i];
			}
			if(r+i>=0 && r+i <n && c-i>=0 && c-i <n) {
				multiplySum+=board[r+i][c-i];
			}
			if(r+i>=0 && r+i <n && c+i>=0 && c+i <n) {
				multiplySum+=board[r+i][c+i];
			}
		}
		
		max=Math.max(max, Math.max(plusSum, multiplySum));
	}
}
