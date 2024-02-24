import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int m;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		String str;
		while (t-- > 0) {
			str=br.readLine();
			
			System.out.print(str.charAt(0));
			System.out.print(str.charAt(str.length()-1));
			System.out.println();
		}

	}

}