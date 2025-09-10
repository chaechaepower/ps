import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					
					if(i!=j && arr[i][j]==0) {
						arr[i][j]=10000;
					}
				}
			}

			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					if(i==k) continue;
					for(int j=0;j<n;j++) {
						if(j==k) continue;
			
						arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum=0;
				for(int j=0;j<n;j++) {
					sum+=arr[i][j];
				}
				if(sum<min) min=sum;
			}
			
			System.out.printf("#%d %d\n",t,min);
		}
	}
}
