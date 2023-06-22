import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] queue;

	static int rear = -1;
	static int front = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		queue = new int[N];

		while (N-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "front":
				sb.append(front()).append('\n');
				break;

			case "back":
				sb.append(back()).append('\n');
				break;

			default: // push
				push(Integer.parseInt(st.nextToken()));

			}
		}

		System.out.println(sb);
	}

	public static void push(int x) {

		queue[++rear] = x;
	}

	public static int pop() {

		if (front == rear) {
			return -1;
		} else {
			return queue[++front];
		}
	}

	public static int size() {

		return rear - front;
	}

	public static int empty() {

		if (front == rear) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {

		if (front == rear) {
			return -1;
		} else {
			return queue[front + 1];
		}
	}

	public static int back() {

		if (front == rear) {
			return -1;
		} else {
			return queue[rear];
		}
	}

}