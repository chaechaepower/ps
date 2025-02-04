import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (testN-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] priorityCnt = new int[10];
			Queue<int[]> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int priority = Integer.parseInt(st.nextToken());
				priorityCnt[priority]++;
				q.offer(new int[] { i, priority });
			}

			int rank=0;
			while(true) {
				int[] now=q.peek();
				int nowPriority=now[1];
			
				boolean isTop=true;
				for(int i=nowPriority+1;i<10;i++) { //현재 문서보다 우선순위가 높은 문서가 뒤에 존재
					if(priorityCnt[i]>0) {
						isTop=false;
						q.offer(q.poll()); //현재 문서를 빼서 뒤에 넣음.
						break;
					}
				}
				//아니라면 인쇄 
				if(isTop) {
					int[] result=q.poll();
					priorityCnt[nowPriority]--;
					rank++;
					if(result[0]==m) {
						sb.append(rank).append('\n');
						break;
					}
				}	
			}
		}
		System.out.println(sb);
	}
}


