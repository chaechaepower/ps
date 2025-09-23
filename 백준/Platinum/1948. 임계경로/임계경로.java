import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int n, weight;

		public Edge(int n, int weight) {
			super();
			this.n = n;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); // 도시 개수 
		int m=Integer.parseInt(br.readLine()); // 도로 개수 
		
		// indegree수 저장 배열, 그래프, 누적 시간, 각 도시까지 오는데 걸린 도로의 수 
		List<Edge>[] graph=new ArrayList[n+1];
		for(int i=1;i<n+1;i++) graph[i]=new ArrayList<>();
		
		List<Edge>[] rev=new ArrayList[n+1];
		for(int i=1;i<n+1;i++) rev[i]=new ArrayList<>();
		
		int[] indegree=new int[n+1];
		int[] result=new int[n+1];
		int[] count=new int[n+1];
		
		StringTokenizer st;
		while(m-->0) {
			st= new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v,w));
			indegree[v]++;
			
			rev[v].add(new Edge(u,w));
		}
		
		st= new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		count[start]++;
		
		// start -> end 가장 큰 비용 구하기 
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			
			for(Edge next:graph[cur]) {
				if(result[next.n]<result[cur]+next.weight){
					result[next.n]=result[cur]+next.weight;
					count[next.n]=count[cur]+1;
				}
				indegree[next.n]--;
				if(indegree[next.n]==0) queue.offer(next.n);

			}
		}
		
		System.out.println(result[end]);
		
		// 가장 큰 비용을 구성하는 도로의 총 수 
		int total=0;
		queue.offer(end);
		boolean[] visited=new boolean[n+1];
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			
			for(Edge pre:rev[cur]) {
				if(result[cur]==result[pre.n]+pre.weight) {
					total++;
					
					if(!visited[pre.n]) {
						queue.offer(pre.n);
						visited[pre.n]=true;
					}
				}
			}
		}
		
		System.out.println(total);
	}
}	


/*
 * 가장 큰 경로 비용
 * 이때 거치는 도로의 수(여러 개)
 * */
 
