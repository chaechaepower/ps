import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
	static class BC {
		int x, y;
		int c; // 충전 범위
		int p; // 처리량

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BC other = (BC) obj;
			return c == other.c && p == other.p && x == other.x && y == other.y;
		}
	}

	static int[] dr = {0, 0, 1, 0, -1 };
	static int[] dc = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int totalTime = Integer.parseInt(st.nextToken()); // 총 이동시간
			int bcNum = Integer.parseInt(st.nextToken()); // BC 개수

			int[] a = new int[totalTime+1]; // a의 이동방향
			int[] b = new int[totalTime+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < totalTime+1; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < totalTime+1; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			BC[] bc = new BC[bcNum];
			for (int i = 0; i < bcNum; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				bc[i] = new BC(x, y, c, p);
			}

			int sum = 0;
			List<BC> aRange;
			List<BC> bRange;

			int aX = 1, aY = 1, bX = 10, bY = 10; // 1~10

			for (int time = 0; time < totalTime+1; time++) {
				// 위치 계산
				int aDir = a[time];
				int bDir = b[time];

				aX += dr[aDir];
				aY += dc[aDir];
				bX += dr[bDir];
				bY += dc[bDir];

				aRange = new ArrayList<>();
				bRange = new ArrayList<>();

				// 어느 bc에 속하는지 계산
				boolean isOverlap = false;

				for (int i = 0; i < bcNum; i++) {
					// 거리 계산
					int bcX = bc[i].x;
					int bcY = bc[i].y;
					int bcC = bc[i].c;

					int aDis = Math.abs(bcX - aX) + Math.abs(bcY - aY);
					int bDis = Math.abs(bcX - bX) + Math.abs(bcY - bY);

					if (aDis <= bcC) {
						aRange.add(bc[i]);
					}
					if (bDis <= bcC) {
						bRange.add(bc[i]);
					}

					if (aDis <= bcC && bDis <= bcC) {
						isOverlap = true;
					}
				}

				if(isOverlap) {
					int max=Integer.MIN_VALUE;
					
					for(int i=0;i<aRange.size();i++) {
						BC aBC=aRange.get(i);
						
						for(int j=0;j<bRange.size();j++) {
							BC bBC=bRange.get(j);
							int total=0;
							
							if(aBC==bBC) {
								total=aBC.p;
							}else {
								total=aBC.p+bBC.p;
							}
							
							max=Math.max(total, max);
						}
					}
					
					sum+=max;
				}
				
				else {
					if(!aRange.isEmpty()) {
						Collections.sort(aRange,(bc1,bc2)->bc2.p-bc1.p);
						sum+=aRange.get(0).p;
					}
					if(!bRange.isEmpty()) {
						Collections.sort(bRange,(bc1,bc2)->bc2.p-bc1.p);
						sum+=bRange.get(0).p;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,sum);
		}

	}

}

/*
 * 
 * 
 * 매초마다 할거 1.위치 계산 2.어느 ap에 속하는지 검사 3.a,b모두 계산 후 겹치는지 확인 4.겹칠 경우 broute force로
 * 충전량 max 확인
 * 
 * 
 * 겹친다-> 더햇을때 최대 안겹친다-> 각각에서 최대값
 * 
 */
