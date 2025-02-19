import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int l,r;
	static int[][] ground;
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static List<Integer>[] adjList;
	static int days; //정답 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		ground=new int[n][n];
		adjList=new ArrayList[n*n]; // ground[r][m] <-> adjList[r/n][r%n]
				
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				ground[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		control();
		System.out.println(days);
		
	}
	
	static void control() {
		
		while(true) {
			
			openBoundray();
			
			boolean flag=false;
			for(int i=0;i<n*n;i++) {
				if(!adjList[i].isEmpty()) {
					flag=true;
				}
			}
			
			if(flag) {
				imigration();
				days++;
			}else {
				return;
			}
			
		}
		
	}
	
	//국경선을 연다. 
	static void openBoundray() {
		boolean[][] visited=new boolean[n][n];
		for(int i=0;i<n*n;i++) {
			adjList[i]=new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//i행 j열의 인접한 나라에 대해 조사 
				int nowPop=ground[i][j];
				visited[i][j]=true;
				
				for(int k=0;k<4;k++) {
					int newR=i+dr[k];
					int newC=j+dc[k];
					
					if(newR<0 || newR>n-1 || newC<0 || newC>n-1) {
						continue;
					}
					
					if(!visited[newR][newC]) {
						
						int newPop=ground[newR][newC];
						int diffPop=Math.abs(newPop-nowPop); //두 인접한 나라의 인구수 
						
						if(l<=diffPop && diffPop<=r) {
							int nowIdx=n*i+j; //i,j를 1차원 배열로 인덱싱
							int newIdx=n*newR+newC; 
							
							//인접리스트에 추가 
							adjList[nowIdx].add(newIdx);
							adjList[newIdx].add(nowIdx);
						}
					}
				}
			}
		}
	}	
	
	//연합을 구해서 인구이동을 한다. 
	static void imigration() {
		boolean[] visited=new boolean[n*n]; //연합 구할 때 방문 여부 
		List<Integer> nations;//연합에 포함된 나라 
		
		for(int i=0;i<n*n;i++) {
			
			if(adjList[i].isEmpty() || visited[i]) {
				continue;
			}
			nations=new ArrayList<>();
			
			dfs(i, visited, nations);
			
			int imiPop=0;//갱신할 인구 수 
			
			//갱신할 인구 수를 구한다.
			int popSum=0; //연합 나라의 총 인구 수 
			for(int e:nations) {
				int row=e/n;
				int col=e%n;
				popSum+=ground[row][col];
			}
			imiPop=popSum/nations.size();
			
			//갱신한다. 
			for(int e:nations) {
				int row=e/n;
				int col=e%n;
				ground[row][col]=imiPop;
			}
		}
		
	}
	
	//연합 나라 구하기 
	static void dfs(int v, boolean[] visited, List<Integer> nations) {
		visited[v]=true;
		nations.add(v);
		
		for(int e: adjList[v]) {
			if(!visited[e]) {
				dfs(e, visited, nations);
			}
		}
		
	}
}


