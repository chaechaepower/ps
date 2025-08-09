import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr; //안맞는 조합 
	static int n;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			arr=new int[n+1];
			
			while(m-->0) {
				st=new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(st.nextToken());
				int v2=Integer.parseInt(st.nextToken());
				
				arr[v1]|=1<<v2;
				arr[v2]|=1<<v1;
			}
			
			cnt=0;
			dfs(1,0,0);
			System.out.printf("#%d %d\n",t,cnt);
		}
	}

	public static void dfs(int i, int depth, int visit) {
		if(depth==n) {
			cnt++;
			return;
		}
		
		if((visit & arr[i]) ==0) {
			dfs(i+1,depth+1,visit|(1<<i));
		}
		
		dfs(i+1,depth+1,visit);
	}
}


