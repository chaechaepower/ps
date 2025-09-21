import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board; 
	static boolean[] visited;
	static int r,c;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken()); 
		c=Integer.parseInt(st.nextToken());  
		
		board=new int[r][c];
		
		for(int i=0;i<r;i++) {
			String line=br.readLine();
			
			for(int j=0;j<c;j++) {
				board[i][j]=line.charAt(j)-'A';
			}
		}
		
		visited=new boolean[26]; //0은 A, 1은 B .. 
		dfs(0,0,1);
		System.out.println(max);
	}
	
	private static void dfs(int i, int j, int len) {
		visited[board[i][j]]=true;
		max=Math.max(max, len);
		
		for(int d=0;d<4;d++) {
			int nr=i+dr[d];
			int nc=j+dc[d];
			
			if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
			
			if(visited[board[nr][nc]]) continue;
			
			dfs(nr,nc, len+1);
			visited[board[nr][nc]]=false;
		}
		
	}
}	
