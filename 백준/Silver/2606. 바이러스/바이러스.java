import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		
		adjList=new ArrayList[n+1]; //1~n대 컴퓨터에 대한 인접 리스트 
		visited=new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			adjList[i]=new ArrayList<>();
		}
		
		StringTokenizer st;
		
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
		dfs(1);
		System.out.println(cnt-1); //1번 컴퓨터 제외 
	}
	
	static void dfs(int v) {
		cnt++;
		visited[v]=true;
		
		for(int node:adjList[v]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
		
	}
}


