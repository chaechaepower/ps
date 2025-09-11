import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static enum Status{
		DEAD, INNACTIVE, ACTIVE;
	}
	
	static class Cell implements Comparable<Cell>{
		int r,c, power, time;
		Status status; 
		/* r,c: 위치
		 * power: 생명력
		 * time: 상태 변하는 시간 
		 * status: 상태(죽음, 비활성화, 활성화)
		 */

		public Cell(int r, int c, int power, int time, Status status) { 
			super();
			this.r = r;
			this.c = c;
			this.power=power;
			this.time = time;
			this.status = status;
		}
		
		@Override
		public int compareTo(Solution.Cell o) {
			return o.power-this.power;
		}
	}
	
	static boolean[][] visited;
	static List<Cell> list;
	static int N,M,K;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			visited=new boolean[N+2*K][M+2*K];
			list=new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				
				for(int j=0;j<M;j++) {
					int power=Integer.parseInt(st.nextToken());
					
					if(power!=0) {
						visited[i+K][j+K]=true;
						list.add(new Cell(i+K, j+K, power, power, Status.INNACTIVE));
					}
				}
			}
			
			simulate();
			System.out.printf("#%d %d\n",t,count());
		}		
	}

	private static int count() {
		int count=0;
		
		for(Cell cell:list) {
			if(cell.status!=Status.DEAD) count++;
		}
		
		return count;
	}

	private static void simulate() {
		PriorityQueue<Cell> pq=new PriorityQueue<>();
		
		for(int k=1;k<=K;k++) {
			
			while(!pq.isEmpty()) {
				Cell cell=pq.poll();
				int r=cell.r;
				int c=cell.c;
				
				if(!visited[r][c]) {
					visited[r][c]=true;
					list.add(cell);
				}
			}
			
			// 모든 셀을 하나씩 꺼내서 상태 변화 
			for(int i=0;i<list.size();i++) {
				Cell cur=list.get(i);
				
				if(cur.status==Status.DEAD) continue;
				
				if(cur.status==Status.INNACTIVE && cur.time==k) { // 번식 
					cur.status=Status.ACTIVE;
					cur.time=k+cur.power;
					
					for(int d=0;d<4;d++) {
						int nr=cur.r+dr[d];
						int nc=cur.c+dc[d];
						
						if(!visited[nr][nc]) {
							pq.offer(new Cell(nr,nc,cur.power, k+cur.power+1,Status.INNACTIVE));
						}
					}
				}
				
				else if(cur.status==Status.ACTIVE && cur.time==k) { // 죽음 
					cur.status=Status.DEAD;
				}
			}
		}
		
	}
}
