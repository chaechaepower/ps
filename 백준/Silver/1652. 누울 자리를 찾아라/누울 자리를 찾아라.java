import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
	
		char[][] room=new char[n][n];
		
		for(int i=0;i<n;i++) {
			room[i]=br.readLine().toCharArray();
		}
		
		int width=0;
		for(int row=0;row<n;row++) {
			int count=0;
			boolean isContinuous=false;
			
			for(int col=0;col<n;col++) {
				
				if(room[row][col]=='X') {
					if(isContinuous && count>=2) {
						width++;
					}
					
					isContinuous=false;
					count=0;
					continue;
				}
				
				if(room[row][col]=='.') {
					isContinuous=true;
					count++;
				}
			}
			
			if(room[row][n-1]=='.') {
				if(isContinuous && count>=2) {
					width++;
				}
			}
		}
		
		int height=0;
		for(int col=0;col<n;col++) {
			int count=0;
			boolean isContinuous=false;
			
			for(int row=0;row<n;row++) {
				
				if(room[row][col]=='X') {
					if(isContinuous && count>=2) {
						height++;
					}
					
					isContinuous=false;
					count=0;
					continue;
				}
				
				if(room[row][col]=='.') {
					isContinuous=true;
					count++;
				}
			}
			
			if(room[n-1][col]=='.') {
				if(isContinuous && count>=2) {
					height++;
				}
			}

		}
		
		System.out.println(width+" "+height);
	}
}
