import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		
		while(n-->0) {
			String command=br.readLine();
			int length=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine(),"[],");
			
			//덱 생성
			Deque<Integer> deque=new ArrayDeque<>();
			
			for(int i=0;i<length;i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
						
			//명령어 수행 
			AC(command, deque);
		}
		System.out.println(sb);
	}
	
	static void AC(String command, Deque<Integer> deque) {
		
		boolean isReverse=false;
		
		for(char cmd:command.toCharArray()) {
			
			if(cmd=='R') {
				isReverse=!isReverse;
				continue;
			}
			
			if(!isReverse) { //순방향
				if(deque.pollFirst()==null) {
					sb.append("error\n");
					return;
				}
				
			}else { //역방향
				if(deque.pollLast()==null) {
					sb.append("error\n");
					return;
				}
			}
		}
		
		printString(deque, isReverse);
	}
	
	static void printString(Deque<Integer> deque, boolean isReverse) {
		
		sb.append('[');
		
		if(!deque.isEmpty()) {
			if(!isReverse) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()){
					sb.append(',').append(deque.pollFirst());
				}
			}else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()){
					sb.append(',').append(deque.pollLast());
				}
				
			}
		}
		
		sb.append(']').append('\n');
	}
}
