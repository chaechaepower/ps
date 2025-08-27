import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Vertex implements Comparable<Vertex> {
		int n;
		double w;

		public Vertex(int n, double w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Solution.Vertex o) {
			return (int) (this.w - o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());

			int[] x = new int[n];
			int[] y = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			double tax = Double.parseDouble(br.readLine());

			// 점 사이 거리 계산
			List<Vertex>[] list = new ArrayList[n];
			for (int i = 0; i < n; i++)
				list[i] = new ArrayList<>();

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					int x1 = x[i];
					int x2 = x[j];
					int y1 = y[i];
					int y2 = y[j];

					double edge = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

					list[i].add(new Vertex(j, edge));
					list[j].add(new Vertex(i, edge));
				}
			}

			boolean[] visited=new boolean[n];
			double[] minEdge=new double[n];
			Arrays.fill(minEdge, Double.MAX_VALUE);
			int cnt=0;
			double result = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));

			while (!pq.isEmpty()) {
				// 1. 비트리 정점 중 최소 간선 정점 구함
				Vertex cur=pq.poll();
				if(visited[cur.n]) continue;
				
				visited[cur.n]=true;
				result+=cur.w;
				cnt++;
				if(cnt==n) break;
				
				// 2. 해당 정점과 연결된 정점의 최소 간선 길이 갱신 
				for(int i=0;i<list[cur.n].size();i++) {
					Vertex vertex=list[cur.n].get(i);
					if(visited[vertex.n]) continue;
					
					if(vertex.w<minEdge[vertex.n]) {
						minEdge[vertex.n]=vertex.w;
						pq.offer(new Vertex(vertex.n,vertex.w));
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,Math.round(result*tax));
		}
	}
}
