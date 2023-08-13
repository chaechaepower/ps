import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] check;
	static boolean IsEven;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int t=0;t<testN;t++) {
			st=new StringTokenizer(bf.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			
			graph=new ArrayList[V+1];
			visited=new boolean[V+1];
			check=new int[V+1];
			IsEven=true;
			
			for(int i=1;i<V+1;i++) {
				graph[i]=new ArrayList<>();
			}
			
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(bf.readLine());
				int start=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				
				graph[start].add(end); graph[end].add(start);		
			}
			
			for(int i=1;i<V+1;i++) {
				if(IsEven) {
					dfs(i);
				}
				else {
					break;
				}
					
			}
			
			if(IsEven) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			
		}
		
	} 

	static void dfs(int v) {
		
		visited[v]=true;
		
		for(int e:graph[v]) {
			if(!visited[e]) {
				check[e]=(check[v]+1)%2;
				dfs(e);
			}
			else if(check[e]==check[v]) {
					IsEven=false;
			}
		}
	}
}