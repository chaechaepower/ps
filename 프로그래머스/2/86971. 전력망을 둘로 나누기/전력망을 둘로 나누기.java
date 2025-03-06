import java.lang.*;

class Solution {
    int[][] map; //인접 행렬
    boolean[] visited;
    int ans=Integer.MAX_VALUE;
    int cnt;
    
    public int solution(int n, int[][] wires) {
        map=new int[n+1][n+1]; //0은 안씀
        
        for(int i=0;i<wires.length;i++){ //간선 정보 저장
            int v1=wires[i][0];
            int v2=wires[i][1];
            
            map[v1][v2]=1;
            map[v2][v1]=1;
        }

        
        for(int i=0;i<wires.length;i++){
            int v1=wires[i][0];
            int v2=wires[i][1];
            
            map[v1][v2]=0;
            map[v2][v1]=0;
            
            visited=new boolean[n+1]; 
            
            int diff=0;
            for(int v=1;v<=n;v++){
                if(!visited[v]){
                    cnt=0;
                    dfs(v,n);
                    System.out.println(cnt);
                    if(v==1){
                        diff=cnt;
                    }else{
                        diff=Math.abs(cnt-diff);
                    }
                }
            }
            System.out.println(diff);
            System.out.println();
            ans=Math.min(diff,ans);
            
            map[v1][v2]=1;
            map[v2][v1]=1;
        }
        
        return ans;

    }
    
    void dfs(int v, int n){
        visited[v]=true;
        cnt++;
        
        for(int i=1;i<=n;i++){
            if(!visited[i] && map[v][i]==1 && map[i][v]==1){
                dfs(i,n);
            }
        }
    }
}

/*
인접 행렬 또는 인접 리스트로 그래프 정보 나타냄.
간선을 하나 없애고 그 경우에 대해 dfs를 실행한 뒤 노드 개수 차이 계산
노드 개수 차이가 최대일 때를 구하자.

*/