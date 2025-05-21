

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static boolean[] visited;
	static int maxLen;
	static int curLen;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (m == 0) {
				System.out.printf("#%d %d\n", t, 1);
				continue;
			}
			
			graph=new int[n+1][n+1];
			visited=new boolean[n+1];
			
			while(m-->0) {
				st = new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(st.nextToken());
				int v2=Integer.parseInt(st.nextToken());
				
				graph[v1][v2]=1;
				graph[v2][v1]=1;
			}
			
			maxLen=0;
			
			for(int i=1;i<=n;i++) {
				visited=new boolean[n+1];
				visited[i]=true;
				curLen=1;
				dfs(i);
			}
			
			System.out.printf("#%d %d\n",t,maxLen);
		}
	}

	private static void dfs(int v) {
		for(int i=1;i<=n;i++) {
			if(v!=i && graph[v][i]==1 & !visited[i]) {
				visited[i]=true;
				curLen++;
				
				dfs(i);
				maxLen=Math.max(maxLen, curLen);
				
				visited[i]=false;
				curLen--;
			}
		}
		
	}
}
