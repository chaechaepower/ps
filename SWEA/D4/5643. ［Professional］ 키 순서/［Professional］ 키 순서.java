import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, adj[][], radj[][];
	static int count; // 자신보다 키가 크거나 작은 학생 수

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testN; t++) {
			n=Integer.parseInt(br.readLine());
			int m=Integer.parseInt(br.readLine());
			
			adj=new int[n+1][n+1];// 학생 번호가 1번부터: 나보다 키가 큰 관계 표현
			radj=new int[n+1][n+1];// 학생 번호가 1번부터: 나보다 키가 작은 관계 표현 
			
			for(int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				radj[b][a] = adj[a][b]=1; // a보다 b가 크다
			}
			
			int ans=0;
			for(int i=1;i<n+1;i++) { // 모든 학생에 대해 자신보다 키가 큰 학생 탐색, 작은 학생 탐색 
				count=0;
				boolean[] visited=new boolean[n+1];
				dfs(i,adj, visited); // i학생보다 큰 학생 수가 count에 저장됨.
				dfs(i,radj, visited); // i학생보다 작은 학생 수가 count에 저장됨.
				if(count==n-1) ++ans;
			}
			
			System.out.printf("#%d %d\n",t,ans);
		}
	}
	
	private static void dfs(int cur, int[][] adj, boolean[] visited) { // 나보다 키가 큰 학생 탐색 
		visited[cur]=true;
		
		for(int i=1;i<n+1;i++) {
			if(adj[cur][i]==1 && !visited[i]) { // 방문했던 곳 다시 돌아올 필요 없으므로 방문 여부 검사 
				++count; // 나보다 큰 애를 볼 때마다 1씩 증가 
				dfs(i,adj, visited);
			}
		}
	}
}
