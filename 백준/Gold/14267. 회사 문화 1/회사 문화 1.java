import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static List<Integer>[] childs;
	static int[] compliments;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		childs = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			childs[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int sub = 1; sub < n + 1; sub++) {
			int boss = Integer.parseInt(st.nextToken());
			if (boss == -1)
				continue;

			childs[boss].add(sub);
		}

		compliments = new int[n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			compliments[i] += w;
		}

		passComplement(1, 0);

		for (int i = 1; i < n + 1; i++) {
			System.out.print(compliments[i] + " ");
		}
	}

	private static void passComplement(int i, int sum) {

		if(childs[i].isEmpty()) return;

		for (int child : childs[i]) {
			compliments[child] += sum;
			passComplement(child,compliments[child]);
		}
	}
}
