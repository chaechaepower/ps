import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n+1][n+1];
		
		while(k-->0) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=-1; // 정방향 
			arr[b][a]=1; // 역방향 
		}
		
		for(int p=1;p<n+1;p++) { // 경유지 
			
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					
					if(arr[i][p]==-1 && arr[p][j]==-1) {
						arr[i][j]=-1;
					}
					else if(arr[i][p]==1 && arr[p][j]==1) {
						arr[i][j]=1;
					}
				}
			}
		}
		
		int s=Integer.parseInt(br.readLine());
		while(s-->0) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			System.out.println(arr[a][b]);
		}
	}
}

