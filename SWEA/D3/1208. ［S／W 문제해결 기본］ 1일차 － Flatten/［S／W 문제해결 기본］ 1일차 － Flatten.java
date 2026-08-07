import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());

			int[] arr = new int[100];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);

			for (int i = 0; i < dump; i++) {
				arr[99]=arr[99]-1;
				arr[0]=arr[0]+1;
				Arrays.sort(arr);
			}

			int max = arr[99];
			int min = arr[0];
			
			System.out.printf("#%d %d\n", t, max - min);
		}
	}
}
