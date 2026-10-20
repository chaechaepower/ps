import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			List<int[]> home=new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				st= new StringTokenizer(br.readLine());
				
				for(int j=0;j<n;j++) {
					int value=Integer.parseInt(st.nextToken());
					
					if(value==1) {
						home.add(new int[] {i,j});
					}
				}
			}
			
			int max=Integer.MIN_VALUE;
			
			for(int k=1;k<=2*n-1;k++) {
				// 운영 비용
				int oper=(int)(Math.pow(k,2)+Math.pow(k-1,2));
				
				for(int r=0;r<n;r++) {
					for(int c=0;c<n;c++) {
						
						int count=0;
						
						for(int i=0;i<home.size();i++) {
							int[] h=home.get(i);
							
							
							if(Math.abs(r-h[0])+Math.abs(c-h[1])<=k-1) {
								count++;
							}
						}
						
						int profit=m*count;
						
						if(profit-oper>=0) {
							max=Math.max(count,max);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
		
	}
}

/*
 
 집 리스트 생성
 1~최대k까지 0,0~n,n이 중심점일 때의 범위 안의 집 개수 구함 

 
 */


