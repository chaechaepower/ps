
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static int n,m;
	public static boolean[][] visited;
	public static boolean[][] field;
	public static int[] xDir= {0, -1, 0, 1};
	public static int[] yDir= {1, 0, -1, 0};

 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(t-->0) {
			
			st=new StringTokenizer(br.readLine());
			
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			visited=new boolean[m][n];
			field=new boolean[m][n];
			
			for(int i=0;i<k;i++) {
				st=new StringTokenizer(br.readLine());
				
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				field[x][y]=true;
			}
			
			int cnt=0;
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j] && field[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int newX=x+xDir[i];
			int newY=y+yDir[i];
			
			if(newX>=0 && newX<m && newY>=0 && newY<n) {
				if(!visited[newX][newY] && field[newX][newY]) {
					dfs(newX,newY);
				}
			}
		}
	}
}

