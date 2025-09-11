import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 
public class Solution {
	static int n, adj[][];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testN; t++) {
			n=Integer.parseInt(br.readLine());
			int m=Integer.parseInt(br.readLine());
			
			adj=new int[n+1][n+1];// 학생 번호가 1번부터: 나보다 키가 큰 관계 표현
			//메모 안된 상태 초기화 
			for(int i=1;i<n+1;i++) adj[i][0]=-1;
			
			for(int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				adj[a][b]=1; // a보다 b가 크다
			}
			
			for(int i=1;i<n+1;i++) { // 모든 학생에 대해 자신보다 키가 큰 학생 탐색(이 과정에서 간접과계를 직접관례로 경로 압축)
				if(adj[i][0]==-1) gtDfs(i); // 탐색
			}
			
			// 자신보다 작은 학생 카운트 
			for(int i=1;i<n+1;i++) { // 열 
				for(int j=1;j<n+1;j++) { // 행
					adj[0][i]+=adj[j][i]; // 자신보다 작은 학생 누적(밑으로)
				}
			}
			
			int ans=0;
			for(int i=1;i<n+1;i++) {
				if(adj[i][0]+adj[0][i]==n-1) { // i학생보다 큰 애 수 + 작은 애 수
					ans++;
				}
			}
			
			System.out.printf("#%d %d\n",t,ans);
		}
	}

	private static void gtDfs(int cur) { // 나보다 키가 큰 학생 탐색
		for (int i = 1; i < n + 1; i++) {
			if (adj[cur][i] == 1) { 
				if(adj[i][0]==-1) gtDfs(i); // 아직 탐색 안했으므로 하고 오기
				
				// i가 탐색을 이미 해서 내려왔거나 i 탐색을 마치고 내려왔거나.
				if(adj[i][0]>0) { // i보다 큰 학생이 있다면, cur<i<j가 있다는 뜻. ==> cur<j의 관계로 표현 
					for(int j=1;j<n+1;j++) { // i보다 큰 j학생 찾아서 cur<j 관계로 표현 
						if(adj[i][j]==1) adj[cur][j]=1;
					}
				}				
			}
		}
		
		// 자신보다 큰 학생들 수 카운팅 후 메모
		int cnt=0;
		for(int i=1;i<n+1;i++) {
			if(adj[cur][i]>0) {
				cnt++;
			}
		}
		adj[cur][0]=cnt; //메모
	}
}
