import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m,n,h;
	static int[][][] box;
	static int[] dh= {-1,1,0,0,0,0};
	static int[] dr= {0,0,-1,1,0,0};
	static int[] dc= {0,0,0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		box=new int[h][n][m];
		
		Queue<int[]> queue=new LinkedList<>();
		boolean isAlreadyRipped=true;
		
		for(int d=0;d<h;d++) {
			
			for(int r=0;r<n;r++) {
				st = new StringTokenizer(br.readLine());
				
				for(int c=0;c<m;c++) {
					box[d][r][c]=Integer.parseInt(st.nextToken());
					
					if(box[d][r][c]==0) isAlreadyRipped=false;
					if(box[d][r][c]==1) queue.offer(new int[] {d,r,c,0});
				}
			}
		}
		
		if(isAlreadyRipped) {
			System.out.println(0);
			return;
		}
		
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			int curD=cur[0];
			int curR=cur[1];
			int curC=cur[2];
			int day=cur[3];
			
			for(int i=0;i<6;i++) {
				int nextD=curD+dh[i];
				int nextR=curR+dr[i];
				int nextC=curC+dc[i];
				int nextDay=day+1;
				
				if(nextD<0 || nextD>=h || nextR<0 || nextR>=n || nextC<0 || nextC>=m) continue;
				
				if(box[nextD][nextR][nextC]==0) {
					box[nextD][nextR][nextC]=nextDay;
					queue.offer(new int[] {nextD,nextR,nextC,nextDay});
				}
			}
		}
		
		int total=Integer.MIN_VALUE;
		
		for(int d=0;d<h;d++) {
			for(int r=0;r<n;r++) {
				for(int c=0;c<m;c++) {
					
					if(box[d][r][c]==0) {
						System.out.println(-1);
						return;
					}
					
					total=Math.max(total, box[d][r][c]);
				}
			}
		}
		
		System.out.println(total);
	}
}
