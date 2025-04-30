import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static char[] arr;
	static int swapN;
	static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			arr=st.nextToken().toCharArray();
			swapN=Integer.parseInt(st.nextToken());
			
			if(swapN>arr.length){
				swapN=arr.length;
			}
			
			dfs(0);
			System.out.println("#"+t+" "+max);
			max=0;
		}
	}
	
	static void dfs(int depth) {
		if(depth==swapN) {
			int n=Integer.valueOf(String.valueOf(arr));
			max=Math.max(n, max);
			
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				swap(i,j);
				dfs(depth+1);
				swap(i,j);
			}
		}
	}
	
	static void swap(int i, int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
