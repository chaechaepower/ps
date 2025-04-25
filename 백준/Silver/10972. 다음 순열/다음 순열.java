import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] seq=new int[n];
		for(int i=0;i<n;i++) {
			seq[i]=Integer.parseInt(st.nextToken());
		}
		
		int i=n-1;
		while(i>0 && seq[i-1]>=seq[i]) {
			i--;
		}
		
		if(i<=0) {
			System.out.println(-1);
			return;
		}
		
		int j=n-1;
		while(j>=i&& seq[i-1]>=seq[j]) {
			j--;
		}
		
		int temp=seq[i-1];
		seq[i-1]=seq[j];
		seq[j]=temp;
		
		j=n-1;
		while(i<j) {
			//swap
			temp=seq[i];
			seq[i]=seq[j];
			seq[j]=temp;
			
			i++;
			j--;
			
		}
		
		StringBuilder sb=new StringBuilder();
		
		for(int e:seq) {
			sb.append(e).append(' ');
		}
		
		System.out.println(sb);
	}
}
