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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		
		while(n-->0) {
			char[] func=br.readLine().toCharArray();
			int length=Integer.parseInt(br.readLine());
			
			String arrStr=br.readLine();
			String subStr=arrStr.substring(1,arrStr.length()-1);
			StringTokenizer st=new StringTokenizer(subStr,",");
			
			//덱 생성
			Deque<Integer> deque=new ArrayDeque<>();
			for(int i=0;i<length;i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			//명령어 수행 
			boolean isReverse=false;
			boolean isError=false;
			for(int i=0;i<func.length;i++) {
				
				if(func[i]=='R') { //뒤집어라. 
					isReverse= (isReverse==true) ? false : true;
				}else if(func[i]=='D') { //앞에꺼 지워라. 
					if(deque.isEmpty()) {
						isError=true;
						break;
					}else if(!isReverse) { //안뒤집힘 
						deque.pollFirst();
					}else { //뒤집힘 
						deque.pollLast();
					}
				}
			}
	
				
				if(isError) {
					sb.append("error").append('\n');
					continue;
				}
				
				if(!deque.isEmpty()) {
					if(!isReverse) {
						int size=deque.size();
						sb.append("[");
						for(int j=0;j<size-1;j++) {
							sb.append(deque.pollFirst()).append(",");
						}
						sb.append(deque.pollFirst()).append("]").append("\n");
					}
					
					else {
						int size=deque.size();
						sb.append("[");
						for(int j=0;j<size-1;j++) {
							sb.append(deque.pollLast()).append(",");
						}
						sb.append(deque.pollLast()).append("]").append("\n");
					}
				}else {
					sb.append("[]").append('\n');
				}
				
				
			
		}
		
		
		System.out.println(sb);
		
	}

}
