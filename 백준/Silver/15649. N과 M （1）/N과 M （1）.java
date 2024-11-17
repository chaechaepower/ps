import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static int m;
	public static int n;
	public static int[] arr;
	public static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		visited=new boolean[n];
		arr=new int[m];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth==m) {
			for(int e:arr) {
				sb.append(e).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
	
	
}
