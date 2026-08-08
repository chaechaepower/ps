import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public String solution(String number, int k) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < number.length(); i++) {
			char cur = number.charAt(i);

			while (k > 0 && !stack.isEmpty() && stack.peek() < cur) {
				stack.pop();
				k--;
			}

			stack.push(cur);
		}
		
		while(k-->0) {
			stack.pop();
		}

		int size = stack.size();
		char[] result = new char[size];
		
		for (int i = size - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return new String(result);
	}
}