import java.util.*;
import java.io.*;

public class Solution {
	static int n, w, h;
	static int[][] map, temp;
	static int[] seq;
	static int min;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		StringTokenizer st;
		
		for (int t = 1; t <= testN; t++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			
			map=new int[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			min=Integer.MAX_VALUE;
			seq=new int[n]; // 구슬 떨어뜨리는 위치(w) - 순서대로 
			dfs(0);
			System.out.printf("#%d %d\n",t,min);
		}
	}
	
	private static void dfs(int depth) {
		if(depth==n) {
			// bfs
			temp=new int[h][];
			for(int i=0;i<h;i++) {
				temp[i]=Arrays.copyOf(map[i],w);
			}
			
			bfs();
			// TODO: 최대값 비교 
			
			int sum=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(temp[i][j]>0) sum++;
				}
			}
			
			min=Math.min(sum,min);
			
			return;
		}
		
		for(int i=0;i<w;i++) {
			seq[depth]=i;
			dfs(depth+1);
		}
	}

	private static void bfs() {
		
		for(int i=0;i<n;i++) {
			int first=seq[i];
			Queue<int[]> queue=new LinkedList<>();
			
			// 맨 위에 벽돌 넣기 
			for(int r=0;r<h;r++) {
				int range=temp[r][first];
				
				if(range>0) {
					queue.offer(new int[] {r,first,range}); // h,w,range
					break;
				}
			}
			
			// 연쇄 처리 
			while(!queue.isEmpty()) {
				int[] now=queue.poll();
				int nowR=now[0];
				int nowC=now[1];
				int nowRange=now[2];
				
				temp[nowR][nowC]=0;
				
				for(int d=0;d<4;d++) {
					int nextR=nowR;
					int nextC=nowC;
							
					for(int range=0;range<nowRange-1;range++) {
						nextR+=dr[d];
						nextC+=dc[d];
						
						if (nextR < 0 || nextR >= h || nextC < 0 || nextC >= w) {
						    break;
						}
						
						if(temp[nextR][nextC]>1) {
							queue.offer(new int[] {nextR,nextC,temp[nextR][nextC]}); // h,w,range
						}
						
						temp[nextR][nextC]=0;
					}
				}
			}
			
			// 떨구기 
			for(int c=0;c<w;c++) {
				int bottom=h-1;
				
				for(int r=h-1;r>=0;r--) {
					if(temp[r][c]!=0) {
						int value=temp[r][c];
						temp[r][c]=0;
						temp[bottom][c]=value;
						
						bottom--;
					}
				}
			}
		}
	}
}

/*
 
n 한 회차당 큐 생성 
2이상인거 큐에 넣기 
큐 다 처리 후 떨구기 

구슬 떨구는 경우의 수 : 중복 순열 
 
 
  
 */
