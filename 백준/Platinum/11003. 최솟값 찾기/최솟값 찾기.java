import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	int idx;
	int num;

	public Node(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken()); // 윈도우 범위

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		Deque<Node> deque = new ArrayDeque<>();
		deque.offerFirst(new Node(1, arr[1]));

		sb.append(deque.peekFirst().num).append(" ");

		for (int i = 2; i <= n; i++) {
			while (!deque.isEmpty()) {
				if (deque.peekLast().num >= arr[i]) {
					deque.pollLast();
				} else {
					break;
				}
			}
			deque.offerLast(new Node(i, arr[i]));

			int lastIdx = deque.peekLast().idx;
			int firstIdx = deque.peekFirst().idx;

			if (lastIdx - firstIdx >= l) {
				deque.pollFirst();
			}

			sb.append(deque.peekFirst().num).append(" ");
		}

		System.out.println(sb);
	}
}
