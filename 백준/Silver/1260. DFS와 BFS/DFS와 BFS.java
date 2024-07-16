import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static StringBuilder sb=new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());

        list=new LinkedList[n+1];
        visited=new boolean[n+1];

        for(int i=1;i<=n;i++){
            list[i]=new LinkedList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(list[i]);
        }

        dfs(start);
        sb.append('\n');
        visited=new boolean[n+1];
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int node){
        visited[node]=true;
        sb.append(node).append(' ');
        
        for(int e:list[node]){
            if(!visited[e]){
                dfs(e);
            }
        }
    }


    public static void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
         
        queue.offer(start);
        visited[start]=true;
        
        while (!queue.isEmpty()) {

            int node=queue.poll();
            sb.append(node).append(' ');
            
            for(int i=0;i<list[node].size();i++){
                int adj=list[node].get(i);
                if(!visited[adj]){
                    queue.offer(adj);
                    visited[adj]=true;
                }
            }
        }
        sb.append('\n');
        
    }
}