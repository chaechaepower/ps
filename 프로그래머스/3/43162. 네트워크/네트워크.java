class Solution {
    boolean[] visited;

	public int solution(int n, int[][] computers) {
        visited= new boolean[n];
        
        int count=0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,n,computers);
                count++;
            }
        }
        
        return count;
	}
    
    private void dfs(int v,int n,int[][] computers){
        visited[v]=true;
        
        for(int i=0;i<n;i++){
            if(visited[i] || i==v) continue;
            
            if(computers[i][v]==1) {
                dfs(i,n,computers);
            }
        }
    }
}

