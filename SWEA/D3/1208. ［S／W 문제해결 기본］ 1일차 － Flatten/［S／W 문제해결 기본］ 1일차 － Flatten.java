import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int dumpN=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] height=new int[101];
			
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			
			for(int i=0;i<100;i++) {
				int num=Integer.parseInt(st.nextToken());
				height[num]++;
				max=Math.max(max, num);
				min=Math.min(min, num);
			}
						
			while(dumpN-->0) {
				height[max]--;
				height[max-1]++;
				height[min]--;
				height[min+1]++;

				if(height[max]==0){
					for(int i=max-1;i>=0;i--) {
						if(height[i]>0) {
							max=i;
							break;
						}
					}
				}
				
				if(height[min]==0){
					for(int i=min+1;i<101;i++) {
						if(height[i]>0) {
							min=i;
							break;
						}
					}
				}
				
			}
		
			
			
			System.out.println("#"+t+" "+(max-min));
		}
	}

	
}
