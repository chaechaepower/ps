import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] board;
	static int n;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n=Integer.parseInt(br.readLine());
		board=new int[n];
		
		dfs(0);
		System.out.println(answer);
	}

	public static void dfs(int depth) {
		if (depth == n) {
			answer++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if(isPossible(depth,i)) {
				board[depth]=i;
				dfs(depth+1);
			}
		}
	}

	private static boolean isPossible(int row, int col) {
		for(int i=0;i<row;i++) {
			if(board[i]==col || Math.abs(row-i) == Math.abs(board[i]-col)) {
				return false;
			}
		}
		return true;
	}

	
}
