import java.util.*;
import java.math.*;
import java.io.*;

class Main{
    static int n;
    static int[][] edges;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st;

        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(br.readLine());

            for(int j=1;j<n+1;j++){
                 edges[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        min=Integer.MAX_VALUE;
        visited[1]=true;
        dfs(1,1,0);
        System.out.println(min);
    }

    private static void dfs(int depth, int now, int total){
        if(total>=min){
            return;
        }

        if(depth==n){
            // 1로 가는 비용 더하기
            if(edges[now][1]==0){
                return;
            }

            total += edges[now][1];
            min = Math.min(total, min);

            return;
        }
        
        for(int i=1;i<n+1;i++){
            if(!visited[i] && edges[now][i]!=0){
                visited[i]=true;
                dfs(depth+1, i, total+edges[now][i]);
                visited[i]=false;
            }
        }
    }
}

/*
완탐해서 비용 젤 작은거
- 비용 0이면 못감
- 1번부터 시작
- 1로 다시 돌아와야함(dfs마지막에 더하기)

*/