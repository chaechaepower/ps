import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testIdx = Integer.parseInt(br.readLine());
			
			char[][] board=new char[100][100];
			
			for(int i=0;i<100;i++) {
				board[i]=br.readLine().toCharArray();
			}
			
			int max=Integer.MIN_VALUE;
			
			//행 
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					
					for(int len=100-j;len>=1;len--) { //길이가 len인 회문을 찾음. 
					
						boolean isPel=true;
						
						for(int p=j;p<j+len/2;p++) {
							if(board[i][p]!=board[i][j+(j+len-1)-p]) {
								isPel=false;
								break;
							}
						}
						
						if(isPel && len>max) {
							max=len;
						}
					}
					
					
				}
			}
			//열 
			for(int j=0;j<100;j++) { 
				for(int i=0;i<100;i++) { 
					
					for(int len=100-i;len>=1;len--) { //길이가 len인 회문을 찾음. 
					
						boolean isPel=true;
						
						for(int p=i;p<i+len/2;p++) {
							if(board[p][j]!=board[i+(i+len-1)-p][j]) {
								isPel=false;
								break;
							}
						}
						
						if(isPel && len>max) {
							max=len;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",testIdx,max);
			
		}
	}
}

