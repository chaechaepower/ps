import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		long[] arr=new long[n+1];
		st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=arr[i-1]+num; //부분합
		}
		
		long[] remainder=new long[m];
		long cnt=0;
		
		for(int i=1;i<=n;i++) {
			int rem=(int)(arr[i]%m); //부분합을 m으로 나눔. 
			
			if(rem==0) {
				cnt++;
			}
			
			remainder[rem]++;
		}
		
		for(int i=0;i<remainder.length;i++) {
			if(remainder[i]>1) {
				cnt+=(remainder[i]*(remainder[i]-1))/2;
			}
		}
		
		System.out.println(cnt);
	}
}
