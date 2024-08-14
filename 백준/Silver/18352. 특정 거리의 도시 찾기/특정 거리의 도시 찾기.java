import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    
    static List<Integer>[] graph;
    static int[] visited; //도시 방문 여부 및 거리 저장
    static int n;
    static int m;
    static int k;
    static int x;

    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        
        visited=new int[n+1];
        graph=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }   

        bfs(x);

        StringBuilder sb=new  StringBuilder();
        for(int i=1;i<=n;i++){
            if (visited[i]==k) {
                sb.append(i).append('\n');
            }
        }
        if (sb.toString().isEmpty()) {
            sb.append(-1);
        }
        System.out.println(sb);

    }

    static void bfs(int v){
        Queue<Integer> queue=new ArrayDeque<>();
        visited[v]=0;
        queue.offer(v);
        
        while (!queue.isEmpty()) {
            int n=queue.poll();
            
            for(int i=0;i<graph[n].size();i++){
                int adj=graph[n].get(i);
                if (visited[adj]==0&&adj!=v) {
                    queue.offer(adj);
                    visited[adj]=visited[n]+1;
                }
            }
        }

    }
}