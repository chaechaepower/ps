import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
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

			int max;
			
			if(m>n) {
				max=calSum(a,b,n,m);
			}
			else {
				max=calSum(b,a,m,n);
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
	
	private static int calSum(int[]a, int[]b, int n, int m) {
		int max=Integer.MIN_VALUE;
		
		for (int j = 0; j <= m - n; j++) {
			int temp=0;

			for (int i = 0; i < n; i++) {
				temp += a[i] * b[j + i];
			}
			max = Math.max(temp, max);
		}
		
		return max;
	}
}
