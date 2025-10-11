import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int r,c,t;
	static int[][] board;
	static List<int[]> dusts;
	static int[][] cleaner;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		
		board=new int[r][c];
		cleaner=new int[2][2];
		dusts=new ArrayList<>();
		
		for(int i=0,k=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			
			for(int j=0;j<c;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==-1) cleaner[k++]=new int[] {i,j};
			}
		}
		
		while(t-->0) {
			spreadDusts();
			cleanAir();
		}
		
		int total=0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(board[i][j]>0) total+=board[i][j];
			}
		}
			
		System.out.println(total);
	}
	
	private static void cleanAir() {
		int top = cleaner[0][0];
        int bottom = cleaner[1][0];

        // 반시계 
        for (int i = top - 1; i > 0; i--)
            board[i][0] = board[i - 1][0];
        for (int i = 0; i < c - 1; i++)
            board[0][i] = board[0][i + 1];
        for (int i = 0; i < top; i++)
            board[i][c - 1] = board[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[top][i] = board[top][i - 1];
        board[top][1] = 0; 

        // 시계 
        for (int i = bottom + 1; i < r - 1; i++)
            board[i][0] = board[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            board[r - 1][i] = board[r - 1][i + 1];
        for (int i = r - 1; i > bottom; i--)
            board[i][c - 1] = board[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[bottom][i] = board[bottom][i - 1];
        board[bottom][1] = 0; 
	}

	private static void spreadDusts() {
		dusts.clear();
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(board[i][j]>0) dusts.add(new int[] {i,j,board[i][j]});
			}
		}
				
		for(int i=0;i<dusts.size();i++) {
			int[] cur=dusts.get(i);
			int curR=cur[0];
			int curC=cur[1];
			int amount=cur[2];
			
			int count=0;
			
			for(int d=0;d<4;d++) {
				int nr=curR+dr[d];
				int nc=curC+dc[d];
				
				if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
				if(board[nr][nc]==-1) continue;
				
				board[nr][nc]+=amount/5;
				count++;
			}
			
			board[curR][curC]-=(amount/5)*count;
		}
	}
}

