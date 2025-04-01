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
		
		Deque<Integer> deque=new ArrayDeque<>();
		
		for(int i=1;i<=n;i++) {
			deque.offerLast(i);
		}
		
		int result;
		
		while(true) {
			
			if(deque.size()==1) {
				result=deque.pollLast();
				break;
			}
			
			deque.pollFirst();
			int num=deque.pollFirst();
			deque.offerLast(num);
		}
		
		System.out.println(result);
	}
	
}
