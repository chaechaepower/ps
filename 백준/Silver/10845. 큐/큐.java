import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] queue = new int[N];

		int rear = -1;
		int front = -1;

		while (N-- > 0) {

			String ins = br.readLine();

			switch (ins) {

			case "pop":
				if (queue[++front] >= 1) {
					System.out.println(queue[front]);
					queue[front] = -1;
				} else {
					System.out.println(-1);
					front--;
				}
				break;

			case "size":
				System.out.println(rear - front);
				break;

			case "empty":
				if (front == rear) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;

			case "front":
				if (front == rear) {
					System.out.println(-1);
				} else {
					System.out.println(queue[front + 1]);
				}
				break;

			case "back":
				if (front == rear) {
					System.out.println(-1);
				} else {
					System.out.println(queue[rear]);
				}
				break;

			default: // push
				StringTokenizer st = new StringTokenizer(ins);
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());

				queue[++rear] = x;

			}
		}
	}
}