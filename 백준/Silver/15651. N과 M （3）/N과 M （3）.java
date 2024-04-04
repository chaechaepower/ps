import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static int[] result;
	static int n;
	static int m;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		result=new int[m];
		
		dfs(0);
		
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if(depth==m) {
			for(int e:result) {
				sb.append(e).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<n;i++) {
			result[depth]=i+1;
			dfs(depth+1);
		}
		
	}

}