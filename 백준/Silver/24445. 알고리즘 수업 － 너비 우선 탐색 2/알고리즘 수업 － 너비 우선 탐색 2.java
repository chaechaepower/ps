import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int cnt=0; //방문 순서 카운트 
	static int n;

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
		visited=new boolean[n+1]; //방문 여부 체크.
		order=new int[n+1]; 
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1;i<n+1;i++) {
			Collections.sort(graph[i],Collections.reverseOrder());
		}
		
		bfs(r);
		
		for(int i=1;i<n+1;i++) {
			System.out.println(order[i]);
		}
		
	}

	static void bfs(int v) {
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(v);
		visited[v]=true;
		
		while(!queue.isEmpty()) {
			int node=queue.poll();
			order[node]=++cnt;
			
			for(int e: graph[node]) {
				if(!visited[e]) {
					visited[e]=true;
					queue.offer(e);
				}
			}
		}
	}

}
