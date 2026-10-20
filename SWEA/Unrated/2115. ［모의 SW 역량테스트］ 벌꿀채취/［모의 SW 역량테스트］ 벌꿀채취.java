import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n,m,c;
	static int[][] hive;
	static int temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken()); // 벌통들의 크기
			m=Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
			c=Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
			
			hive=new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<n;j++) {
					hive[i][j]=Integer.parseInt(st.nextToken()); 
				}
			}
			
			int max=Integer.MIN_VALUE;
			
			
			for(int r1=0;r1<n;r1++) {
				for(int c1=0;c1<=n-m;c1++) {
					// arr[r1][c1] ~ arr[r1][c1+m-1]
					
					for(int r2=0;r2<n;r2++) {
						for(int c2=0;c2<=n-m;c2++) {
							
							// 겹치면 제외 
							if(r1==r2 && (c1 < c2 + m && c2 < c1 + m)) continue;
							
							int total=0;
							
							temp=0;
							dfs(r1,c1,c1+m,0,0);
							total+=temp;
							
							temp=0;
							dfs(r2,c2,c2+m,0,0);
							total+=temp;
							
							max=Math.max(max,total);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
	}
	
	private static void dfs(int nowR, int nowC, int end, int sum, int pow) {
		// 가로 m개 중에 합이 c를 넘지않고 최대 제곱의 합 
		if(sum>c) {
			return;
		}
		
		if(nowC==end) {
			temp=Math.max(pow, temp);
			return;
		}
		
		// 선택 
		int honey=hive[nowR][nowC];
		dfs(nowR, nowC+1, end, sum+honey, pow+(int)Math.pow(honey,2));
		
		// 선택 x
		dfs(nowR, nowC+1, end, sum, pow);
	}
}

/*
 
 1. 일꾼 2명이 각각 가로로 M개 선택하는 경우
 	2차원 배열에서의 조합 
 
 2. 각 경우마다 일꾼이 선택할 수 있는 꿀의 양 < C
 3. 최대 이익 계산 
 
 */


