import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int n,w;

		public Vertex(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Main.Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] minEdge=new int[n+1]; // 정점과 연결된 최소 비용의 간선 길이 
		List<Vertex>[] graph=new ArrayList[n+1];
		for(int i=1;i<n+1;i++) graph[i]=new ArrayList<>();
		boolean[] visited=new boolean[n+1]; // 트리 여부 
		
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			graph[a].add(new Vertex(b,c));
			graph[b].add(new Vertex(a,c));
		}
		
		PriorityQueue<Vertex> pq=new PriorityQueue<>();
		pq.offer(new Vertex(1,0));
		Arrays.fill(minEdge, Integer.MAX_VALUE); 
		minEdge[1]=0;
		int result=0, cnt=0, max=Integer.MIN_VALUE;
		
		while(!pq.isEmpty()) {
			int minV=-1;
			
			Vertex cur=pq.poll();
			if(visited[cur.n]) continue;
			
			minV=cur.n;
			visited[minV]=true;
			result+=cur.w;
			max=Math.max(max, cur.w);
			cnt++;
			
			if(cnt==n) break;
			
			for(Vertex next: graph[cur.n]) {
				if(visited[next.n]) continue;
				
				if(minEdge[next.n]>next.w) {
					minEdge[next.n]=next.w;
					pq.offer(new Vertex(next.n,minEdge[next.n]));
				}
			}
		}
		
		System.out.println(result-max);
	}
}

/*
 * 1. 비정점 트리에서 최소 비용 간선을 가진 정점 선택
 * 2. 그 정점과 연결된 비정점 트리의 정점을 최소 비용 간선으로 갱신 
 * */

