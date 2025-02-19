import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int l,r;
	static int[][] ground;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static int days; //정답 
	static boolean[][] visited;
	static List<int[]> list;
	static int popSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		ground=new int[n][n];
				
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				ground[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		callBfs();
		
		System.out.println(days);
	}
	
	static void callBfs() {
		
		while(true) { //매 반복마다 days++ 
			
			visited=new boolean[n][n];
			boolean isMove=false;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						list=new ArrayList<>();
						popSum=0;
						bfs(i,j);
					}
					
					if(list.size()>1) { //연합 나라가 2개 이상
						//인구수 갱신 
						imigration();
						isMove=true; 
					}
				}
			}
			
			if(!isMove) {
				break;
			}else {
				days++; 
			}
		}
		
	}
	
	static void imigration() {
		int pop=popSum/list.size();
		
		for(int[] pos:list) {
			int r=pos[0];
			int c=pos[1];
			
			ground[r][c]=pop;
		}
	}
	
	static void bfs(int row, int col) {
		Queue<int[]> queue=new LinkedList<>();
		queue.offer(new int[] {row,col});
		visited[row][col]=true; 
		list.add(new int[] {row,col});
		popSum+=ground[row][col];
				
		while(!queue.isEmpty()) {
			int[] now=queue.poll();
			int nowR=now[0];
			int nowC=now[1];
			
			for(int i=0;i<4;i++) {
				int newR=nowR+dr[i];
				int newC=nowC+dc[i];
				
				if(newR<0 || newR>n-1 || newC<0 || newC>n-1) {
					continue;
				}
				
				if(visited[newR][newC]) {
					continue;
				}
				
				int diff=Math.abs(ground[nowR][nowC]-ground[newR][newC]);
								
				if(l<=diff && diff<=r) {
					queue.offer(new int[] {newR, newC});
					visited[newR][newC]=true;
					list.add(new int[] {newR, newC});
					popSum+=ground[newR][newC];
				}
			}
		}
		
	}
}
	


/*
 * bfs로 바로 연합을 구한다..
while(
	모든 행,열에 대해 반복 
		if(!visited[][]인 곳 방문)
		
			while(큐가 빌 때까지){
				list(연합 나라들)에 노드 넣기 
				sum 구하기 
			}
			
		while문 한 번 끝나면 하나의 연합을 구할 수 있음.
		list가 1이상이면 그 연합에 대해 인구수 갱신 
		isMove=true;
	
	if(!isMove){
		끝. 
	}
)

그다음 while문은 !visited[]인 곳 방문
	

 * 
 * */
