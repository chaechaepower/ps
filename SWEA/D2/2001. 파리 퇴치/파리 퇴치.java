import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int max=Integer.MIN_VALUE;
			
			for(int i=0;i<=n-m;i++) {
				
				for(int j=0;j<=n-m;j++) {
					int sum=0;
					
					for(int p=i;p<i+m;p++) {
						for(int q=j;q<j+m;q++) {
							sum+=map[p][q];
						}
					}
					
					max=Math.max(max,sum);
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
	}
}
