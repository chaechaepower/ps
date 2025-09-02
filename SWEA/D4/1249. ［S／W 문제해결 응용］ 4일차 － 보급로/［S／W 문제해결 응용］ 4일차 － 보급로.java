import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	static int[][] board;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}
			
			System.out.printf("#"+t+" "+Dikstra()+"\n");
		}
	}

	private static int Dikstra() {
		int[][] minCost = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				minCost[i][j]=Integer.MAX_VALUE;
			}
		}
		minCost[0][0] = board[0][0];

		PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.offer(new int[] { 0, 0, board[0][0] });

		while (!pq.isEmpty()) {
			// 최소 시간이 가장 작은 정점 선택
			int[] cur = pq.poll();

			// 그 정점과 연결된 비방문 정점의 최소 시간 갱신 
			for(int d=0;d<4;d++) {
				int nr=cur[0]+dr[d];
				int nc=cur[1]+dc[d];
				
				if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
				
				if(nr==n-1 && nc==n-1) {
					return cur[2];
				}
				
				if(cur[2]+board[nr][nc]<minCost[nr][nc]) { //가본적 없거나 경유지 거쳤을 때 더 시간이 더 짧다면 
					minCost[nr][nc]=cur[2]+board[nr][nc];
					pq.offer(new int[] { nr, nc, minCost[nr][nc] });
				}
			}
		}
		
		return -1;
	}
}

/*
 * S->G로 가는 최소 비용 목적지까지 가는데 마주하는 정점까지의 최소비용을 구하면 됨.
 * 
 * 
 */
