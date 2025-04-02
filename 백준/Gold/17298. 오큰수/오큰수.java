import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		int[] result= new int[n];
		Arrays.fill(result, -1);
		

		for (int i = 1; i < n; i++) {
			int topIdx = stack.peek();

			if (arr[i] < arr[topIdx]) {
				stack.push(i);
			}

			else {
				while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					int popIdx = stack.pop();
					result[popIdx] = arr[i];
				}
				stack.push(i);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int e:result) {
			sb.append(e).append(' ');
		}
		
		System.out.println(sb);
	}

}
