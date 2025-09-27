import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[501]; // 위치 번호 1~500 사이 
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a]=b;
		}
		
		int[] dp=new int[501];
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<501;i++) {
			if(arr[i]==0) continue;
						
			int temp=Integer.MIN_VALUE;
			
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i] && temp<dp[j]) {
					temp=dp[j];
				}
			}
			
			dp[i]=(temp==Integer.MIN_VALUE) ? 1: temp+1;
			max=Math.max(dp[i], max);
		}
		
		System.out.println(n-max);
	}
}


/*
 * 1. 시작점 기준으로 정렬
 * 2. i까지 왔을 때 최대 연결횟수 
 * 3. 1~i-1에서 arr[i]보다 작고 dp가 가장 큰 값 
 * */
 