import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,k;
	static int[][] board;
	static int[][] rotate;
	static int min=Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		board=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		rotate=new int[k][3];
		
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			rotate[i][0]=Integer.parseInt(st.nextToken());
			rotate[i][1]=Integer.parseInt(st.nextToken());
			rotate[i][2]=Integer.parseInt(st.nextToken());
		}
		
		visited=new boolean[k];
		dfs(0, board);
		System.out.println(min);
	}
	
	private static void dfs(int depth, int[][] arr) {
		if(depth==k) {
			// 배열의 최솟값 구하기 
			calculateMin(arr);
			return;
		}
		
		for(int i=0;i<k;i++) {
			//배열돌리기 
			if(!visited[i]) {
				visited[i]=true;
				int[][] result=prepareRotate(i, arr);
				dfs(depth+1, result);
				visited[i]=false;
			}
		}
	}

	private static int[][] prepareRotate(int idx, int[][] arr) {
		int[] op=rotate[idx];
		int r=op[0]-1;
		int c=op[1]-1;
		int s=op[2];
		
		int[] top= {r-s, c-s};
		int[] down= {r+s,c+s};
		
		int[][] copy=new int[n][m]; // 원본 복사 
		for(int i=0;i<n;i++) {
			copy[i]=arr[i].clone();
		}
		
		return excuteRotate(copy, top,down);
	}
	
	private static int[][] excuteRotate(int[][] arr, int[] top, int[] down){

		int topR=top[0];
		int topC=top[1];
		int downR=down[0];
		int downC=down[1];
		
		if (topR >= downR || topC >= downC) {
	        return arr;
	    }
		
		int temp=arr[topR][topC];
		
		for(int i=topR;i<downR;i++)
			arr[i][topC]=arr[i+1][topC];
		
		for(int i=topC;i<downC;i++)
			arr[downR][i]=arr[downR][i+1];
		
		for(int i=downR;i>topR;i--)
			arr[i][downC]=arr[i-1][downC];
		
		for(int i=downC;i>topC+1;i--)
			arr[topR][i]=arr[topR][i-1];
		
		arr[topR][topC+1]=temp;
		
		return excuteRotate(arr, new int[] {topR+1,topC+1},new int[] {downR-1,downC-1});
	}

	private static void calculateMin(int[][] arr) {
		int rowMin=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			int total=0;
			
			for(int j=0;j<m;j++) {
				total+=arr[i][j];
			}
			
			rowMin=Math.min(rowMin, total);
		}
		
		min=Math.min(rowMin, min);
	}
}


/* 
 * 1. 현재 순서에 따라 배열을 돌린다.(배열 복사)
 * 2. 순서가 끝나면 A의 최솟값을 구한다. 
 * 
 * */


