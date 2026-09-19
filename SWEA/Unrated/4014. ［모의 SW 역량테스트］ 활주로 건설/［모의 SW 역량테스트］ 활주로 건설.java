import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[][] map;
	static int n,x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			// 행
			for (int i = 0; i < n; i++) {
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = map[i][j];
				}

				if (check(arr)) {
					count++;
				}
			}

			// 열
			for (int i = 0; i < n; i++) {
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = map[j][i];
				}

				if (check(arr)) {
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}

	private static boolean check(int[] arr) {
		boolean[] installed = new boolean[n];

		for(int i=0;i<n-1;i++) {
			int prev=arr[i];
			int now=arr[i+1];

			// 같다
			if(prev==now) {
				continue;
			}
			
			// 높이 차이가 2이상
			int diff=Math.abs(now-prev);
			
			if(diff>=2) {
				return false;
			}
			
			// 현재 = 이전 +1 (증가)  
			if(now == prev+1) {
				
				// 이전에 prev랑 같은 높이가 x칸만큼 있는지 
				for(int j=i;j>=i+1-x;j--) {
					// j 범위 초가 
					if(j<0) {
						return false;
					}
					
					// prev랑 높이가 다름
					if(arr[j]!=prev || installed[j]) {
						return false;
					}
					
					installed[j]=true;
				}
				
			}
			
			// 현재 = 이전 -1 (감소) 
			if(now == prev-1) {
				
				// 이후 now랑 같은 높이가 x칸만큼 있는지 
				for(int j=i+1;j<i+1+x;j++) {
					// j 범위 초가 
					if(j>=n) {
						return false;
					}
					
					// prev랑 높이가 다름
					if(arr[j]!=now || installed[j]) {
						return false;
					}
					
					installed[j]=true;
				}
			}
		}
		
		return true;
	}
}

/*
 * 
 * 같다 -> 계속 진행
 * 
 * 높이 차이가 2이상 -> false c
 * 
 * 현재 = 다음이 +1 -> 지금까지 지나온 낮은 평지 X칸 검사
 * 
 * 현재 = 다음이 -1 -> 앞으로 나올 낮은 평지 X칸 검사
 * 
 * 
 
 */
