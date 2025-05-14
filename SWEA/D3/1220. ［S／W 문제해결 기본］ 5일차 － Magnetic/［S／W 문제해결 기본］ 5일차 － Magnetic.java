import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n=Integer.parseInt(br.readLine()); //100고정 
			int[][] arr=new int[n][n];
			
			StringTokenizer st;

			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			boolean isCurN=false;
			int answer=0;
			
			for(int j=0;j<n;j++) {
				isCurN=false;
				
				for(int i=0;i<n;i++) {
					if(arr[i][j]==1) { //N이면
						isCurN=true;
						continue;
					}
					
					if(arr[i][j]==2){
						if(isCurN) {
							answer++;
						}
						isCurN=false;
					}
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
