import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] weights = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(weights);

			int start = 0;
			int end = n - 1;
			int max = -1;

			while (start != end) {
				int sum = weights[start] + weights[end];

				if (sum > m) {
					end--;
				} 
				else {
					max = Math.max(max, sum);
					start++;
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
	}
}
