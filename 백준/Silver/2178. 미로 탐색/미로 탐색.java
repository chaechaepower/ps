import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int cnt;
	
	Pos(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}

public class Main {
	
	public static int n;
	public static int m;
	public static boolean[][] visited;
	public static boolean[][] maze;
	public static int[] xDir= {0,-1,0,1};
	public static int[] yDir= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		maze=new boolean[n+1][m+1];
		visited=new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			char[] line=br.readLine().toCharArray();
			
			for(int j=1;j<=m;j++) {
				maze[i][j]=line[j-1]=='1'?true:false;
			}
		}
		
		bfs(1,1);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue=new LinkedList<>();
		queue.offer(new Pos(x,y,1));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Pos pos=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nextX=pos.x+xDir[i];
				int nextY=pos.y+yDir[i];
				
				if(nextX==n && nextY==m) {
					System.out.println(pos.cnt+1);
					return;
				}
				
				if(nextX>=1 && nextX<=n && nextY>=1 && nextY<=m) {
					if(!visited[nextX][nextY]&&maze[nextX][nextY]) {
						queue.offer(new Pos(nextX,nextY,pos.cnt+1));
						visited[nextX][nextY]=true;
					}
				}
			}
		}
	}
}