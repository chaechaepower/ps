
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,s;
	static int result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		if(s==0) result--;
		
		System.out.println(result);
	}
	
	private static void dfs(int depth, int sum, int i) {
		if(depth==n) {
			if(sum==s) result++;
			return;
		}
		
		dfs(depth+1, sum+arr[i], i+1);
		dfs(depth+1, sum, i+1);
	}

}
