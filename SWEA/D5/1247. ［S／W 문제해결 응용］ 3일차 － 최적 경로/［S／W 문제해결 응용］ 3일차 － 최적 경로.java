import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] clients;
	static boolean[] visited;
	static int min;
	static int n;
	static int[] business, home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());

			business = new int[2];
			home = new int[2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			business[0] = Integer.parseInt(st.nextToken());
			business[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			clients = new int[n][2];
			for (int i = 0; i < n; i++) {
				clients[i][0] = Integer.parseInt(st.nextToken());
				clients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited=new boolean[n];
			min=Integer.MAX_VALUE;
			dfs(0,business,0);
			
			System.out.printf("#%d %d\n",t,min);
		}
	}

	public static void dfs(int depth, int[] prev, int total) {
		if(total>min) return;
		
		if(depth==n) {
			total+=Math.abs(prev[0]-home[0]) + Math.abs(prev[1]-home[1]);
			min=Math.min(min, total);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int diff=Math.abs(prev[0]-clients[i][0]) + Math.abs(prev[1]-clients[i][1]);
				dfs(depth+1, clients[i], total+diff);
				visited[i]=false;
			}
		}
	}
}

/*
 * 집 방문 순서 이동 거리가 최단 이동 거리보다 크면 바로 return 이전 위치 저장
 * 
 * 
 */
