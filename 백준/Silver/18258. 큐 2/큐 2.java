import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		Deque<Integer> deque=new ArrayDeque<>();
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		while(n-->0) {
			st=new StringTokenizer(br.readLine());
			int x;
			switch(st.nextToken()) {
			
				case "push": x=Integer.parseInt(st.nextToken());
							deque.offerFirst(x);
							break;
					
				case "pop": if(deque.isEmpty()) {
									sb.append(-1).append('\n');
								}else {
									x=deque.pollLast();
									sb.append(x).append('\n');
								}
								break;
					
				case "size": sb.append(deque.size()).append('\n');
								break;
					
				case "empty": if(deque.isEmpty()) {
									sb.append(1).append('\n');
								}else {
									sb.append(0).append('\n');
								}
								break;
					
				case "front": if(deque.isEmpty()) {
									sb.append(-1).append('\n');
								}else {
									sb.append(deque.peekLast()).append('\n');
								}
								break;
					
				default : if(deque.isEmpty()) {
								sb.append(-1).append('\n');
							}else {
								sb.append(deque.peekFirst()).append('\n');
							}
			}
		}
		System.out.println(sb);
	}
}



//큐 삽입: offerFirst
//큐 삭제: pollLast
//가장 뒤에 원소: peekFirst


