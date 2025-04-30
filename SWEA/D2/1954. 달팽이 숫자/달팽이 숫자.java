import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb=new StringBuilder();
	static int[] dr= {0, 1, 0, -1};
	static int[] dc= {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			int n=Integer.parseInt(br.readLine());
			
			if(n==1) {
				sb.append('#').append(t).append('\n');
				sb.append(1).append('\n');
				continue;
			}
			
			int[][] arr=new int[n][n];
			
			int row=0;
			int col=0;
			int dir=0;
			
			for(int i=1;i<=n*n;i++) {
				arr[row][col]=i;
				
				int nextRow=row+dr[dir];
				int nextCol=col+dc[dir];
				
				if(nextRow>=n || nextRow<0 || nextCol>=n || nextCol<0 
						|| arr[nextRow][nextCol]>0) {
					dir=(dir+1)%4;
					row=row+dr[dir];
					col=col+dc[dir];
				}
				else {
					row=nextRow;
					col=nextCol;
				}
			}
			
			sb.append('#').append(t).append('\n');
			printArray(arr);
		}
		
		System.out.println(sb);
	}
	
	static void printArray(int[][] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {

				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
	}
	
}
