import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			int aCost=p*w;
			int bCost=q;
			if(w>r) {
				bCost+=(w-r)*s;
			}
			
			int result=Math.min(aCost, bCost);
			
			System.out.printf("#%d %d\n",t,result);
		}
	}
	
}
