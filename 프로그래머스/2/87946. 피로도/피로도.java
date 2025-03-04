class Solution {
    
    int arrLen;
    boolean[] visited;
    int ans=Integer.MIN_VALUE;
    int[] idxSeq;
    
    public int solution(int k, int[][] dungeons) {
        
        arrLen=dungeons.length;
        visited=new boolean[arrLen];
        idxSeq=new int[arrLen];
        
        dfs(0, k, dungeons);
        return ans;
    }
    
    public void dfs(int depth, int k, int[][] dungeons){
        
        if(depth==arrLen){
            calMaxCnt(k, dungeons);
            return;
        }
        
        for(int i=0;i<arrLen;i++){
            if(!visited[i]){
                visited[i]=true;
                idxSeq[depth]=i;
                dfs(depth+1, k, dungeons);
                visited[i]=false;
            }
            
        }
        
    }
    
    public void calMaxCnt(int k, int[][] dungeons){
        int cnt=0;
        
        for(int i=0;i<arrLen;i++){
            int idx=idxSeq[i];
            
            if(k>=dungeons[idx][0]){
                k-=dungeons[idx][1];
                cnt++;
                
                if(k<=0){
                    ans=Math.max(ans,cnt);
                    return;
                }
            }
        }
        ans=Math.max(ans,cnt);
        
    }
    
}

/*
k가 dungeons[i][0] 보다 크거나 같아야 가능
k-=dungeons[i][1]



*/