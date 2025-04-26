class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited=new boolean[n];
        
        int count=0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, n, computers);
                count++;
            }
        }
        
        return count;
    }
    
    void dfs(int v, int n, int[][] computers){
        for(int i=0;i<n;i++){
            if(i!=v && !visited[i] && computers[v][i]==1){
                visited[i]=true;
                dfs(i, n, computers);
            }
        }
    }
}