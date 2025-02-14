import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int size = 2; // 상어 크기
	static int stack; // 먹은 물고기 수
	static int time; // 더이상 먹을 수 있는 물고기가 없을 때까지 걸리는 시간(정답)
	static int[] cur;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		cur=new int[3];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					cur[0] = i;
					cur[1] = j;
					arr[i][j] = 0; // *** 안해주면, 아기 상어의 크기가 9보다 클 경우, 9를 물고기로 착각해서 먹게됨. 현재 상어 위치만 있으면 됨. ***
				}
			}
		}
		bfs();
		System.out.println(time);
	}
	
	static void bfs() {
		while(true) {
			PriorityQueue<int[]> pq= new PriorityQueue<>((o1,o2)->{
				if(o1[2]==o2[2]) {
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
					}else {
						return o1[0]-o2[0];
					}
				}else {
					return o1[2]-o2[2];
				}
			}); //0:행, 1:열, 2:상어와의 거리 
			
			pq.offer(new int[] {cur[0], cur[1], 0});
			boolean eat=false;
			boolean[][] visited=new boolean[n][n];
			visited[cur[0]][cur[1]]=true;
			
			while(!pq.isEmpty()) {
				cur=pq.poll();
				int curR=cur[0];
				int curC=cur[1];
				int curD=cur[2];
				
				//상어가 지나가다가 먹을 수 있는 먹이면 먹음. 
				if(arr[curR][curC]!=0 && arr[curR][curC]<size) {
					stack++;
					arr[curR][curC]=0;
					time+=curD;
					eat=true;
					break;
				}
				
				//상어가 지나감. 
				for(int i=0;i<4;i++) {
					int newR=curR+dr[i];
					int newC=curC+dc[i];
					
					if(newR<0 || newR>n-1 || newC<0 || newC>n-1) {
						continue;
					}
					
					if(arr[newR][newC]>size) {
						continue;
					}
					
					if(!visited[newR][newC]) {
						pq.offer(new int[] {newR, newC, curD+1});
						visited[newR][newC]=true;
					}
				}
			}
			
			if(!eat) {
				break;
			}
			
			if(stack==size) {
				size++;
				stack=0;
			}
		}
	}
}