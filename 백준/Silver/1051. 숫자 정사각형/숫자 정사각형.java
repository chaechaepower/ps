import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx= {0, 1, 1};
	static int[] dy= {1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			
			for(int j=0;j<m;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		int max=1;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				int leftTop=arr[i][j];
				
				//정사각형의 크기: 2~n까지 반복
				for(int k=2;k<=n;k++) {
					int size=k;
					int diff=size-1;
					
					//꼭짓점 확인 
					boolean flag=true;
					for(int p=0;p<3;p++) {
						int r=i+dx[p]*diff;
						int c=j+dy[p]*diff;
						
						if(r<0 || r>n-1 || c<0 || c>m-1) {
							flag=false;
							break;
						}
						
						if(arr[r][c]!=leftTop) {
							flag=false;
							break;
						}
					}
					
					if(flag) {
						max=Math.max(max, size*size);
					}
				}
				
			}
		}
		
		System.out.println(max);
		
	}
	
}
	
