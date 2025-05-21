import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static char[][] board;
	static int h;
	static int w;
	static int curR;
	static int curC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
		
			int[] arr=new int[11112];
			
			for(int i=1;i<11112;i++) {
				if(i%m==0){//m의 배수 초에는 +k
					arr[i]=k;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[Integer.parseInt(st.nextToken())]--;
			}
			
			int total=0;
			boolean isPossible=true;
			
			for(int i=0;i<11112;i++) {
				total+=arr[i];
				if(total<0) {
					isPossible=false;
					break;
				}
			}
			
			if(isPossible) {
				System.out.printf("#%d Possible\n",t);
			}
			else {
				System.out.printf("#%d Impossible\n",t);
			}
		}
	}
}
