
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int n=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			
			int[] boxes=new int[n+1]; //0제외 
			
			for(int i=1;i<=q;i++) {
				st=new StringTokenizer(br.readLine());
				int l=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				
				for(int j=l;j<=r;j++) {
					boxes[j]=i;
				}
			}
			
			System.out.printf("#%d ",t);
			for(int i=1;i<n+1;i++) {
				System.out.print(boxes[i]+" ");
			}
			System.out.println();
		}
	}
}
