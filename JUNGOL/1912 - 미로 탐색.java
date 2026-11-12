import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
	static int n,m,idx;
    static int[] result;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for(int i=1;i<n+1;i++){
            Collections.sort(list[i]);
        }

        

        visited = new boolean[n+1];
        result = new int[n];
        visited[1]=true;
        result[idx++]=1;
        dfs(1);
        for(int e: result){
            System.out.print(e+" ");
        }
    }

    private static void dfs(int now){
        if(idx==n){
            return;
        }

        for(int next:list[now]){
            if(!visited[next]){
                result[idx++]=next;
                visited[next]=true;
                dfs(next);
            }
        }
    }
}

/*

*/