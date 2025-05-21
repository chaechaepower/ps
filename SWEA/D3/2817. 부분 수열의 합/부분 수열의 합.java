import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int n;
	static int k;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			arr=new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			count=0;
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n",t,count);
		}
	}
	
	private static void dfs(int i, int sum, int depth) {
		if(depth==n) {
			if(sum==k) {
				count++;
			}
			return;
		}
		
		dfs(i+1, sum+arr[i], depth+1); //포함 
		dfs(i+1, sum, depth+1); //미포함 
	}
}
