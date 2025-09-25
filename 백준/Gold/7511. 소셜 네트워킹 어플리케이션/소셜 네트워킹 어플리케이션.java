import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] parent;
	
	private static int find(int x) {
		if(parent[x]==x) return parent[x];
		return parent[x]=find(parent[x]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false;
		
		parent[bRoot]=aRoot;
		return true;
	}
	
	private static void initialize(int n) {
		parent=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		for(int t=1;t<=testN;t++) {
			int n=Integer.parseInt(br.readLine()); // 유저 수 
			int k=Integer.parseInt(br.readLine()); // 친구 관계 수 
			
			initialize(n);
			
			while(k-->0) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			sb.append("Scenario").append(" ").append(t).append(":").append("\n");
			
			int m=Integer.parseInt(br.readLine()); // 구해야할 쌍의 수 
			
			while(m-->0) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				int aRoot=find(a);
				int bRoot=find(b);

				if(aRoot==bRoot) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}	

 
