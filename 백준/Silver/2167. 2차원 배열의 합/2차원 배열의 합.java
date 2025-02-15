import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int testN=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		while(testN-->0) {
			st=new StringTokenizer(br.readLine());
			
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			int sum=0;
			for(int p=i;p<=x;p++) {
				for(int q=j;q<=y;q++) {
					sum+=arr[p][q];
				}
			}
			sb.append(sum).append('\n');			
		}	
		System.out.println(sb);
	}
	
}

