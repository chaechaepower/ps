import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] nums;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		nums=new int[9];
		
		for(int i=0;i<9;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		
		seq=new int[7];
		dfs(0,0,0);
	}

	public static void dfs(int at, int depth, int sum) {
		if(depth==7) {
			if(sum==100) {
				for(int e:seq) {
					System.out.println(e);
				}
			}
			return;
		}
		
		for(int i=at;i<9;i++) {
			seq[depth]=nums[i];
			dfs(i+1,depth+1,sum+nums[i]);
		}
	}
}