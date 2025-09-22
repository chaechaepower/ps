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
		int n=Integer.parseInt(br.readLine());
		
		List<Integer>[] graph=new ArrayList[n+1];
		for(int i=1;i<=n;i++) graph[i]=new ArrayList<>();
		
		int[] time=new int[n+1];
		int[] indegree=new int[n+1];
		
		StringTokenizer st;
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			time[i]=t;
			
			while(true) {
				int pre=Integer.parseInt(st.nextToken());
				if(pre==-1) break;
				graph[pre].add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> queue=new LinkedList<>();
		int[] result=new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) {
				queue.offer(i);
				result[i]=time[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			
			for(int next:graph[cur]) {
				result[next]=Math.max(result[next], result[cur]+time[next]);
				
				indegree[next]--;
				if(indegree[next]==0) queue.offer(next);
			}
		}
		
		for(int i=1;i<n+1;i++) {
			System.out.println(result[i]);
		}
	}
	
}	



 