

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		map=new char[n][n];
		
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			
			for(int j=0;j<n;j++) {
				map[i][j]=line.charAt(j);
			}
		}
		
		int colored=0, nonColored=0; // 정상, 색맹
		
		visited=new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					dfsColored(i,j);
					colored++;
				}
			}
		}
		
		visited=new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					dfsNonColored(i,j);
					nonColored++;
				}
			}
		}
		
		System.out.printf("%d %d",colored, nonColored);
	}

	private static void dfsColored(int i, int j) {
		visited[i][j]=true;
		
		for(int d=0;d<4;d++) {
			int nextR=i+dr[d];
			int nextC=j+dc[d];
			
			if(nextR<0 || nextR>=n || nextC<0 || nextC>=n) continue;
						
			if(visited[nextR][nextC]) continue;
			
			if(map[nextR][nextC]!=map[i][j]) continue;

			dfsColored(nextR, nextC);
		}
	}
	
	private static void dfsNonColored(int i, int j) {
		visited[i][j]=true;
		
		for(int d=0;d<4;d++) {
			int nextR=i+dr[d];
			int nextC=j+dc[d];
			
			if(nextR<0 || nextR>=n || nextC<0 || nextC>=n) continue;
						
			if(visited[nextR][nextC]) continue;
			
			if((map[i][j]!='B'&&map[nextR][nextC]=='B') || (map[i][j]=='B'&&map[nextR][nextC]!='B')) continue;

			dfsNonColored(nextR, nextC);
		}
	}
}
