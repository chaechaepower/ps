import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[] visited;
    static int n;
    static int m;
    static List<Integer>[] list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        list=new ArrayList[n+1]; //0 사용 x
        visited=new boolean[n+1];
        
        for(int i=1;i<=n;i++) {
        	list[i]=new ArrayList<>();
        }
        
        StringTokenizer st;

        while(m-->0) {
        	st=new StringTokenizer(br.readLine());
        	
        	int v1=Integer.parseInt(st.nextToken());
        	int v2=Integer.parseInt(st.nextToken());
        	
        	list[v1].add(v2);
        	list[v2].add(v1);
        }
        
        visited[1]=true;
        dfs(1,0);
        
        int sum=0;
        for(int i=2;i<n+1;i++) {
        	if(visited[i]) {
        		sum++;
        	}
        }
        
        System.out.println(sum);
    }   
    
    public static void dfs(int v,int depth){
        if(depth==2){
            return;
        }

        for(int i=0;i<list[v].size();i++){
        	int num=list[v].get(i);
        	visited[num]=true;
            dfs(num,depth+1);
        }
    }
}

