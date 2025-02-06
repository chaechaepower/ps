import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long[] dp1; //dp1[i]: i를 포함하는 연속된 수의 최대 합(왼쪽부터)
	static Long[] dp2; //dp1[i]: i를 포함하는 연속된 수의 최대 합(오른쪽부터)
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp1=new Long[n];
		dp2=new Long[n];
		arr=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//제거 전 왼쪽부터 연속 최대 합 구하기 
		dp1[0]=(long) arr[0];
		long max=dp1[0];
		for(int i=1;i<n;i++) {
			dp1[i]=Math.max(dp1[i-1]+arr[i], arr[i]);
			max=Math.max(max, dp1[i]);
		}
		
		//제거 전 오른쪽부터 연속 최대 합 구하기 
		dp2[n-1]=(long)arr[n-1];
		for(int i=n-2;i>=0;i--) {
			dp2[i]=Math.max(dp2[i+1]+arr[i], arr[i]);
		}
		
		for(int i=1;i<n-1;i++) {
			if(arr[i]<0) {
				max=Math.max(max, dp1[i-1]+dp2[i+1]);
			}
		}
		
		System.out.println(max);
		
	}

}
