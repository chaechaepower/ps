import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr= {0, 1,-1, 1}; //가로, 세로, 우상향 대각선, 좌하향 대각선
	static int[] dc= {1, 0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n=Integer.parseInt(br.readLine());
			
			char[][] board=new char[n][n];
	
			for(int i=0;i<n;i++) {
				board[i]=br.readLine().toCharArray();
			}
		
			boolean isFound=false;
			
			for(int i=0;i<n && !isFound;i++) {
				for(int j=0;j<n && !isFound;j++) {
					
					if(board[i][j]=='o') {
	
						for(int k=0;k<4;k++) {
							int count=1;
							int nr=i;
							int nc=j;
							
							for(int p=1;p<5;p++) {
								nr+=dr[k];
								nc+=dc[k];
								
								if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]=='o') {
									count++;
								}
								else {
									break;
								}
							}
							
							if(count==5) {
								isFound=true;
								break;
							}
						}
					}
				}
			}
			
            System.out.printf("#%d %s\n", t, isFound ? "YES" : "NO");

		}
	}
}
