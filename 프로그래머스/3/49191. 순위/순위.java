import java.io.IOException;

class Solution {

	public static void main(String[] args) throws IOException {
	}

	public static int solution(int n, int[][] results) {
		boolean[][] graph=new boolean[n+1][n+1];
		
		for(int i=0;i<results.length;i++) {
			int win=results[i][0];
			int lose=results[i][1];
			
			graph[win][lose]=true;
		}
		
		for(int k=1;k<n+1;k++) {
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					
					if(graph[i][k] && graph[k][j]) {
						graph[i][j]=true;
					}
				}
			}
		}
		
		int answer=0;
		
		for(int i=1;i<n+1;i++) {
			int cnt=0;
			
			for(int j=1;j<n+1;j++) {
				if(graph[i][j] || graph[j][i]) {
					cnt++;
				}
			}
			
			if(cnt==n-1) {
				answer++;
			}
		}
		
		return answer;
	}
}

/*
 * 
 * 
 * */
 