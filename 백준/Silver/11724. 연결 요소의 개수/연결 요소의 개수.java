import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	public static boolean[] visited;
	public static List<Integer>[] edge;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		visited=new boolean[n+1];
		edge=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			edge[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			
			edge[v1].add(v2);
			edge[v2].add(v1);
		}
		
		int cnt=0;
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int v) {
		visited[v]=true;
		
		for(int e:edge[v]) {
			if(!visited[e]) {
				dfs(e);
			}
		}
	}
}