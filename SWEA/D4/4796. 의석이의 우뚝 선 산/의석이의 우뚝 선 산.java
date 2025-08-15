import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int testN = sc.nextInt();

		for (int t = 1; t <= testN; t++) {
			int n = sc.nextInt();
            int[] arr = new int[n];
						
			for(int i=0;i<n;i++) {
				arr[i]=arr[i] = sc.nextInt();
			}
			
			int down=0;
			int up=0;
			int ans=0;
			
			for(int i=1;i<n;i++) {
				if(arr[i-1]<arr[i]) {
					if(down>0) {
						ans+=up*down;
						up=0;
						down=0;
					}
					up++;
				}
				else {
					down++;
				}
			}
			
			ans+=up*down;
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}
