import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] lis = new int[n + 1]; // 길이가 1,2,..n일 때의 lis 수열의 가장 끝에 있는 숫자

			System.out.printf("#%d %d\n",t,lisLen(lis, arr));
		}
	}

	private static int lisLen(int[] lis, int[] arr) {
		int idx = 0;
		lis[++idx] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (lis[idx] < arr[i]) {
				lis[++idx] = arr[i];
			} else if (lis[idx] > arr[i]) {
				int loIdx = lowerBound(lis, 1, idx + 1, arr[i]);
				lis[loIdx] = arr[i];
			}
		}

		return idx;
	}

	private static int lowerBound(int[] lis, int left, int right, int key) {
		while (left < right) {
			int mid = (left + right) / 2;

			if (lis[mid] >= key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return right;
	}

}
