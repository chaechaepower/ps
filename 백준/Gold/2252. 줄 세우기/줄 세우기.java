import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		// 노드 간 관계, indegree
		
		List<Integer> [] graph=new ArrayList[n+1]; //0은 사용 x
		for(int i=1;i<=n;i++) graph[i]=new ArrayList();
		int[] indegree=new int[n+1];
		
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			indegree[v]++;
		}
		
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) queue.offer(i);
		}
		
		StringBuilder sb=new StringBuilder();
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			sb.append(cur).append(' ');
			
			for(int next:graph[cur]) {
				indegree[next]--;
				if(indegree[next]==0)
					queue.offer(next);
			}
		}
		
		System.out.println(sb);
	}
	
}	



 