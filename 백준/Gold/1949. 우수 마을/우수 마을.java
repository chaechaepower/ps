import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int n;
		Node next;
		
		public Node(int n, Main.Node next) {
			super();
			this.n = n;
			this.next = next;
		}
	}
	
	static int[] citizens;
	static Node[] tree;
	static boolean[] visited;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		citizens=new int[n+1]; // 0은 사용 
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			citizens[i]=Integer.parseInt(st.nextToken());
		}
		
		tree=new Node[n+1]; // 각 정점에 연결된 정점들 
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			tree[u]=new Node(v,tree[u]);
			tree[v]=new Node(u,tree[v]);
		}
		
		visited=new boolean[n+1];
		dp=new int[n+1][2]; // 0: 우수마을x 1: 우수마을o
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	private static void dfs(int v) {
		visited[v]=true;
		dp[v][0]=0;
		dp[v][1]=citizens[v];
		
		for(Node next=tree[v]; next!=null; next=next.next) {
			if(!visited[next.n]) {
				dfs(next.n);
				dp[v][0]+=Math.max(dp[next.n][0], dp[next.n][1]);
				dp[v][1]+=dp[next.n][0];
			}
		}
	}
}


