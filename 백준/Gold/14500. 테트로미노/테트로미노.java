import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
	static int max=Integer.MIN_VALUE;
	static int[] nums;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m];
		visited=new boolean[n][m];
		nums=new int[4];
		
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j]=true;
				nums[0]=arr[i][j];
				dfs(i,j,1);
				visited[i][j]=false;
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int depth) {
		if(depth==4) {
			int sum=0;
			for(int n:nums) {
				sum+=n;
			}
			max=Math.max(sum, max);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int newR=r+dr[i];
			int newC=c+dc[i];
			//System.out.println("newR: "+newR+", newC: "+newC);
			
			if(newR<0 || newR>n-1 || newC<0 || newC>m-1) {
				continue;
			}

			if(!visited[newR][newC]) {
				
				if(depth==2) {
					visited[newR][newC]=true;
					nums[depth]=arr[newR][newC];
					dfs(r, c, depth+1);
					visited[newR][newC]=false;
				}
				
				visited[newR][newC]=true;
				nums[depth]=arr[newR][newC];
				dfs(newR, newC, depth+1);
				visited[newR][newC]=false;
			}
		}
	}
}
