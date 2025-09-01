import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		
		List<int[]>[] adjList=new ArrayList[V+1]; //0은 사용 x 
		for(int i=1;i<V+1;i++) adjList[i]=new ArrayList<>();

		int[] minDistance = new int[V+1]; // start 저점에서 자신으로의 최소 비용
		boolean[] visited = new boolean[V+1];

		for (int i = 0; i < E; i++) { // 인접리스트 생성
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new int[] {v,w});
		}

		final int INF = Integer.MAX_VALUE;
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;

		for (int i = 1; i < V+1; i++) {
			// step1. 미방문 정점중에 출발점에서 가장 가까운 정점 찾기
			int min = INF;
			int stopOver = -1;

			for (int j = 1; j < V+1; j++) {
				if (visited[j]) continue;
				
				if (min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if (stopOver == -1) break;
			visited[stopOver] = true;

			// step2. step1에서 선택된 정점을 경유지로 하여, 아직 미방문 정점으로의 경로 비용 계산 후 최소비용으로 업데이트..
			for(int[] node : adjList[stopOver]) {
				int v=node[0];
				int w=node[1];
				
				if(visited[v]) continue;
				
				if(min+w < minDistance[v]) {
					minDistance[v] = min + w;
				}
			}
		}

		for(int i=1;i<V+1;i++) {
			System.out.println(minDistance[i]==INF?"INF":minDistance[i]);
		}
	}
}