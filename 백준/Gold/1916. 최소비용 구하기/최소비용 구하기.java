
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수

		List<Node>[] adjList=new ArrayList[n+1]; // 인접 리스트
		for(int i=1;i<n+1;i++) adjList[i]=new ArrayList<>();
		
		StringTokenizer st;
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());;
			
			adjList[u].add(new Node(v,w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		/*
		 *  다익스트라
		 *  1. 미방문 정점 중 최소 비용을 가진 정점을 선택
		 *  2. 해당 정점과 연결된 미방문 정점의 비용을 갱신 (경유지 거치기 VS 기존 비용)
		 * */
		
		// 방문 배열, 최소 비용 배열, PQ
		int[] minList=new int[n+1]; // minList[i]: start에서 i까지의 최소 비용 
		Arrays.fill(minList, Integer.MAX_VALUE);
		minList[start]=0;
		
		boolean[] visited=new boolean[n+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			
			if(visited[cur.to]) continue; 
			
			visited[cur.to]=true;
			
			for(Node node:adjList[cur.to]) {
				if(visited[node.to]) continue; 
				
				if(minList[node.to]>minList[cur.to]+node.weight) {
					minList[node.to]=minList[cur.to]+node.weight;
					pq.offer(new Node(node.to,minList[node.to]));
				}
			}
		}
		
		System.out.println(minList[end]);
	}
}
