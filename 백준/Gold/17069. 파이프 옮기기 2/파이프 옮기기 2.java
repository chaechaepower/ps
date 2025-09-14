import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[][] board=new int[n+1][n+1];
		StringTokenizer st;
		
		for(int i=1;i<n+1;i++) {
			st=new StringTokenizer(br.readLine());
			
			for(int j=1;j<n+1;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		long[][][] dp=new long[n+1][n+1][3]; // 0: 가로 1: 세로 2: 대각선 
		dp[1][2][0]=1;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(board[i][j]==1) continue;
				
				if(j-1>=0 && board[i][j-1]==0) {
					dp[i][j][0]+=dp[i][j-1][0]+dp[i][j-1][2];
				}
				
				if(i-1>=0 && board[i-1][j]==0) {
					dp[i][j][1]+=dp[i-1][j][1]+dp[i-1][j][2];
				}
				
				if(i-1>=0 && j-1>=0 && board[i-1][j]==0 && board[i][j-1]==0 && board[i-1][j-1]==0) {
					dp[i][j][2]+=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				}
			}
		}
		
		System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
	}
}

/*
 * dp 배열 채우기 
 * 메모리 크기가 M 이상인 것 중 비용이 최소인 것 
 * */
 