import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] arr1=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr1[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		
		st.nextToken();
		int k=Integer.parseInt(st.nextToken());
		
		int[][] arr2=new int[m][k];
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<k;j++) {
				arr2[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] arr3=new int[n][k];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				int sum=0;
				for(int p=0;p<m;p++) {
					sum+=arr1[i][p]*arr2[p][j];
				}
				arr3[i][j]=sum;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++){
				sb.append(arr3[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}	
}
