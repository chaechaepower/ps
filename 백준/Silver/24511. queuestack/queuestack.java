import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine()); //큐스택 길이 
		int[] queueStack=new int[n]; //큐스택 
		int[] element=new int[n]; //큐스택 요소 
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			queueStack[i]=Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque=new ArrayDeque<>();
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			
			if(queueStack[i]==0) {
				deque.offerLast(num);
			}
		}
		
		int m=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		if(deque.isEmpty()) {
			for(int i=0;i<m;i++) {
				int input=Integer.parseInt(st.nextToken());
				sb.append(input+" ");
			}
		}
		
		else {
			for(int i=0;i<m;i++) {
				int input=Integer.parseInt(st.nextToken());
				
				sb.append(deque.pollLast()).append(' ');
				deque.offerFirst(input);
			}
		}
		
		System.out.println(sb);
	}
}


/*
 * 
 */


