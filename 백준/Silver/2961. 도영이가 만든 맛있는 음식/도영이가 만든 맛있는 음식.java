import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] ingredients;
	public static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		ingredients = new int[n][2]; // 신맛,쓴맛
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			ingredients[i][0]=Integer.parseInt(st.nextToken());
			ingredients[i][1]=Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		dfs(0,0,1,0,0);
		System.out.println(min);
	}

	public static void dfs(int i, int depth, int bitter, int sweet, int cnt) {
		if (depth == n) {
			if(cnt!=0) {
				min = Math.min(min, Math.abs(bitter - sweet));
			}
			return;
		}

		dfs(i + 1, depth + 1, bitter * ingredients[i][0], sweet + ingredients[i][1],cnt+1);
		dfs(i + 1, depth + 1, bitter, sweet,cnt);
	}
}
