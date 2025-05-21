
import java.util.Scanner;

public class Solution {
	static int result;
	static int n;
	static int m;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			sc.nextInt();

			n = sc.nextInt();
			m = sc.nextInt();
			//System.out.printf("n: %d, m:%d\n",n,m);

			result=1;
			recur(n, m, 0);
			System.out.printf("#%d %d\n",t,result);
		}
	}

	private static void recur(int n, int m, int depth) {
		if(depth==m) {
			return;
		}
		
		result*=n;
		recur(n,m,depth+1);
	}
}

