import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr=new int[101];
		for(int i=1;i<101;i++) {
			arr[i]=i;
		}
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[x]=y;
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[x]=y;
		}
		
		System.out.println(bfs(1));
	}
	
	static int bfs(int start) {
		int[] visited=new int[101]; // 방문 횟수 카운트 
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		visited[start]=0;
		
		while(true) {
			int cur=queue.poll();
			
			for(int i=1;i<=6;i++) {
				int next=cur+i;
				
				if(next>100) continue;
				
				if(visited[arr[next]]!=0) continue;
				
				if(arr[next]==100) {
					return visited[cur]+1;
				}
				
				visited[arr[next]]=visited[cur]+1;
				queue.offer(arr[next]);
			}
		}
	}
}
