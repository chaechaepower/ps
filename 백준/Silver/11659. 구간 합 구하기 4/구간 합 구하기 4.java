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
		
		int[] arr=new int[n+1];
		st=new StringTokenizer(br.readLine());
		
		arr[0]= 0;
		for(int i=1;i<n+1;i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=arr[i-1]+num;
		}
		
		StringBuilder sb=new StringBuilder();
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			
			int partSum=arr[j]-arr[i-1];
			sb.append(partSum).append('\n');
		}
		System.out.println(sb);
	}
}