import java.io.*;
import java.util.*;

public class Main {
	static int white;
	static int blue;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(n, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void recur(int size, int r, int c) {
		int color = arr[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != color) {
					int halfSize = size / 2;
					recur(halfSize, r, c);
					recur(halfSize, r, c + halfSize);
					recur(halfSize, r + halfSize, c);
					recur(halfSize, r + halfSize, c + halfSize);
					return;
				}
			}
		}

		if (color == 1)
			blue++;
		else
			white++;

	}
}