import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] a = new int[n];
			int[] b = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			int answer = a.length > b.length ? cal(a, b) : cal(b, a);

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	public static int cal(int[] large, int[] small) {
		int answer = Integer.MIN_VALUE;
		
		for (int i = 0; i <= large.length - small.length; i++) {
			int sum=0;
			
			for(int j=0;j<small.length;j++) {
				sum+=large[i+j]*small[j];
			}
			
			answer=Math.max(answer, sum);
		}
		
		return answer;
	}
}