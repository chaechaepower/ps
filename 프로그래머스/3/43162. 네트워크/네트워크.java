class Solution {
	boolean[] visited;

	public int solution(int n, int[][] computers) {
		visited = new boolean[n];
		int cnt=0;

		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			
			dfs(i, computers);
			cnt++;
		}
		
		return cnt;
	}
	
	public void dfs(int v, int[][] computers) {
		visited[v]=true;
		
		for(int i=0;i<computers.length;i++) {
			if(visited[i]) continue;
			
			if(computers[v][i]==1) {
				dfs(i,computers);
			}
		}
	}
}
