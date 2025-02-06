import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static int[] visited;
	static int cnt;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[n+1]; //간선 정보. 인접 리스트. 정점의 번호는 1~n 
		for(int i=1;i<n+1;i++) {
			graph[i]=new ArrayList<>();
		}
		visited=new int[n+1]; //방문 순서 저장. 0이면 방문 안함. 1 이상이면 방문함. 
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1;i<n+1;i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(r);
		for(int i=1;i<n+1;i++) {
			System.out.println(visited[i]);
		}
	}

	static void dfs(int v) {
		cnt++;
		visited[v] = cnt;
		
		for(int e:graph[v]) {
			if(visited[e]==0) { // 길이 있고 방문한 적 없음.
				dfs(e); 
			}
		}
	}

}
