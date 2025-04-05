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
		
		//int[] input=new int[n+1];
		int[] seq=new int[n];
		
		for(int i=1;i<=n;i++) {
			int input=Integer.parseInt(st.nextToken());
		
			int emptyCount=0;
			
			for(int j=0;j<n;j++) {
				if(emptyCount==input && seq[j]==0) {
					seq[j]=i;
					break;
				}
				
				if(seq[j]==0) {
					emptyCount++;
				}
				
			}
		}
		
		for(int i=0;i<n-1;i++) {
			System.out.print(seq[i]+" ");
		}
		System.out.println(seq[n-1]);
	}
}

