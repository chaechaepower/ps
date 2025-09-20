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
		
		int n=Integer.parseInt(st.nextToken()); // 가수의 수 
		int m=Integer.parseInt(st.nextToken()); // 보조 pd의 수 
		
		List<Integer>[] graph=new ArrayList[n+1]; // 0은 사용x
		for(int i=1;i<n+1;i++) graph[i]=new ArrayList<>();
		int[] indegree=new int[n+1];
		
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int singerCounts=Integer.parseInt(st.nextToken());
			int num1=Integer.parseInt(st.nextToken());
			
			while(--singerCounts>0) {
				int num2=Integer.parseInt(st.nextToken());
				graph[num1].add(num2);
				indegree[num2]++;
				num1=num2;
			}
		}
		
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) {
				queue.offer(i);
			}
		}
		
		List<Integer> seq=new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			seq.add(cur);
			
			for(int e:graph[cur]) {
				indegree[e]--;
				if(indegree[e]==0) queue.offer(e);
			}
		}
		
		if(seq.size()!=n) {
			System.out.println(0);
			return;
		}
		
		for(int e:seq) {
			System.out.println(e);
		}
	}

}	

/*
 * 위상정렬: 한 작업과 다른 작업 사이의 선후 관계가 있고 이런 작업이 여러 개 있을 때 어떻게 하면 전체 순서를 결정지을 수 있을까!에 대한 것
 * 1. 각 노드별로 indegree 저장, 그래프 저장 
 * 2. indegree가 0인 노드를 큐에 넣는다
 * 3. 큐에서 노드를 빼고 해당 노드에 연결된 다른 노드의 indegree 값을 1 감소
 *    - 이때 indegree가 0이 되는 노드를 큐에 넣는다.
 * 4. 반복뜨 
 * 
 */
