import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			Deque<Character> stack=new ArrayDeque<>();
			
			for(char ch:br.readLine().toCharArray()) {
				switch(ch) {
				case '(':
					stack.offerLast(ch);
					break;
				case '[':
					stack.offerLast(ch);
					break;
				case '{':
					stack.offerLast(ch);
					break;
				case '<':
					stack.offerLast(ch);
					break;
					
				case ')':
					if(stack.peekLast()=='(') {
						stack.pollLast();
					}
					else {
						stack.offerLast(')');
					}
					break;
				case ']':
					if(stack.peekLast()=='[') {
						stack.pollLast();
					}
					else {
						stack.offerLast(']');
					}
					break;
				case '}':
					if(stack.peekLast()=='{') {
						stack.pollLast();
					}
					else {
						stack.offerLast('}');
					}
					break;
				case '>':
					if(stack.peekLast()=='<') {
						stack.pollLast();
					}
					else {
						stack.offerLast('>');
					}
					break;
				}
			}
			
			System.out.printf("#%d ",t);
			if(stack.isEmpty()) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}
}

