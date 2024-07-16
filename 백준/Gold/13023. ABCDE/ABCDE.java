import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;

    public static boolean[] visited;
    public static List<Integer>[] list;
    public static boolean exist;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }

        visited=new boolean[n];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        for(int i=0;i<n;i++){
            if(!exist){
                visited[i]=true;
                dfs(1,i); 
                visited[i]=false;
            }
        }

        if (exist) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    public static void dfs(int depth, int ver){
        if(depth==5){
            exist=true;
            return;
        }

        for(int i=0;i<list[ver].size();i++){
            int node=list[ver].get(i);

            if (!visited[node]) {
                visited[node]=true;
                dfs(depth+1, node);
                visited[node]=false;            
            }
        }
    }
}