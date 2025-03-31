import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Deque<Integer> stack=new ArrayDeque<>(); //스택
		List<Character> oper=new ArrayList<>();//연산 저장할 배열 
		
		int ptr=0;
				
		for(int i=1;i<=n;i++) {
			stack.offerLast(i);
			oper.add('+');
			
			while(ptr<n && list.get(ptr).equals(stack.peekLast())) {
				stack.pollLast();
				oper.add('-');
				ptr++;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		
		if(stack.isEmpty()) {
			for(int i=0;i<oper.size()-1;i++) {
				sb.append(oper.get(i)).append('\n');
			}
			sb.append(oper.get(oper.size()-1));
		}
		else {
			sb.append("NO");
		}
		
		System.out.println(sb);
	}
}



/*
 * 마지막에 같으면 저장했던 +,-출력
 * 다르면 출력 x 
 * 
 * */




