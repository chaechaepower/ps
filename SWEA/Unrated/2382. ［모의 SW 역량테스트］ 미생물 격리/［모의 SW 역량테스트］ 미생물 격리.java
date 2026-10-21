import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static class Point{
		int r,c;
		
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			return r == other.r && c == other.c;
		}
		
		@Override
		public int hashCode() {
		    return 31 * r + c;
		}
	}
	
	static class Micro{
		Point point;
		int dir,count;
		
		public Micro(Point point, int dir, int count) {
			this.point=point;
			this.dir=dir;
			this.count=count;
		}
		
		@Override
		public boolean equals(Object obj) {
			Micro other = (Micro) obj;
			return point == other.point && dir==other.dir && count==other.count;
		}
	}
	
	static int[] dr= {0,-1,1,0,0}; // 0은 사용 x
	static int[] dc= {0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()); // 셀의 개수 
			int m=Integer.parseInt(st.nextToken()); // 격리 시간 
			int k=Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			
			List<Micro> list=new ArrayList<>();
			for(int i=0;i<k;i++) {
				st= new StringTokenizer(br.readLine());
				
				int r=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int count=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				
				Point point = new Point(r,c);
				Micro micro = new Micro(point,dir,count);
				
				list.add(micro);
			}
			
			while(m-->0) {
				// 해시맵 선언 
				HashMap<Point, List<Micro>> map = new HashMap<>();
				
				for(int i=0;i<list.size();i++) {
					Micro micro=list.get(i);
					
					int nowR = micro.point.r;
					int nowC = micro.point.c;
					int nowDir = micro.dir;
					int nowCount = micro.count;
					
					int nextR=nowR+dr[nowDir];
					int nextC=nowC+dc[nowDir];
					
					micro.point.r=nextR;
					micro.point.c=nextC;
					
					if(nextR<=0 || nextR>=n-1 || nextC<=0 || nextC>=n-1) {
						micro.count/=2;
						micro.dir = (micro.dir % 2 == 0) ? micro.dir - 1 : micro.dir + 1;
						
						if(micro.count==0) {
							continue;
						}
					}
					
					map.computeIfAbsent(micro.point, key -> new ArrayList<>()).add(micro);
				}
				
				list.clear();
				
				for(Point point:map.keySet()) {
					// 합, 방향 계산 
					int r=point.r, c= point.c;
					int total=0, dir=0;
					int max=Integer.MIN_VALUE;
					int maxDir=-1;
					
					List<Micro> micros=map.get(point);
					
					for (Micro now : micros) {
			            total += now.count;

			            if (now.count > max) {
			                max = now.count;
			                maxDir = now.dir;
			            }
			        }
					
					list.add(new Micro(new Point(point.r,point.c),maxDir,total));
				}
			}
			
			int ans=0;
			for(int i=0;i<list.size();i++) {
				Micro micro = list.get(i);
				ans+=micro.count;
			}
			
			System.out.printf("#%d %d\n",t,ans);
		}
		
	}
}

/*
 
 for(m시간 동안)
 	for(각 미생물 군집별)
 		다음셀로 이동 
 		셀에 부딪히는 경우 처리(미생물 수 반감, 방향 전환) 
 		
 	같은 군집에 모이는지 -> 어떻게? 
 
 미생물 정보 -> 위치, 방향, 미생물수
 
 
 
 
 
 */


