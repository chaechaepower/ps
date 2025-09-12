import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static final int M=1, W=2, D=3, C=4; // M:이동중, W:대기중, D:내려가는중, C:완료 
	static class Person implements Comparable<Person>{
		int r,c,status,arrivalTime,downCnt; // 행,열,상태,계단입구도착시간,내려간계단수

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		void init() {
			arrivalTime=downCnt=0;
			status=M;
		}

		@Override
		public int compareTo(Solution.Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
	}
	
	static int N,min, cnt; // 맵의 크기, 최소 이동 시간, 사람수 
	static int[][] sList; // 계단 리스트(계단:r,c,height) 계단0, 계단1 
	static ArrayList<Person> pList; // 사람 리스트
	static int[] selected; // 사람마다 어떤 계단 배정되었는지 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine());
			pList=new ArrayList<>();
			sList=new int[2][];
			min=Integer.MAX_VALUE;
			for (int i = 0,k=0; i < N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				
				for (int j = 0 ; j < N; j++) {
					int c=Integer.parseInt(st.nextToken());
					if(c==1) pList.add(new Person(i,j));
					else if(c>1) sList[k++]=new int[] {i,j,c};
				}
			}
			
			cnt=pList.size();
			selected=new int[cnt];
			
			divide(0);
			System.out.println("#"+t+" "+min);
		}		
	}
	
	private static void divide(int index) { // index에 해당하는 사람의 계단 배정 
		if(index==cnt) {
			makeList();
			return;
		}
		
		selected[index]=0;
		divide(index+1);
		
		selected[index]=1;
		divide(index+1);
		
	}

	private static void makeList() { // 계단 배정에 따른 사람들 리스트에 배치 
		ArrayList<Person>[] list=new ArrayList[] {new ArrayList<Person>(),new ArrayList<Person>()};
	
		for (int i = 0; i < cnt; i++) {
			Person p=pList.get(i);
			p.init(); // 사람들의 상태를 새로운 계단 배정 위해 초기화 
			int no=selected[i]; //사람 i에 배정된 계단
			
			p.arrivalTime=Math.abs(p.r-sList[no][0])+Math.abs(p.c-sList[no][1]);
			list[no].add(p);
		}
		
		// 각각의 계단의 사람 리스트들을 이용해서 내려가기 구현
		int timeA=processDown(list[0], sList[0][2]);
		int timeB=processDown(list[1], sList[1][2]);
		int res=Math.max(timeA, timeB); // 두 계단을 모두 내려가는데 소요되는 시간 
		min=Math.min(min, res);
	}

	private static int processDown(ArrayList<Person> list, int height) {
		if(list.size()==0) return 0;
		Collections.sort(list); // 계단 도착 시간 기준 오름차순 정렬
		int time=list.get(0).arrivalTime;
		int size=list.size(); // 이 계단을 이용하는 사람 수 
		int ingCnt=0, cCnt=0; // 내려가고 있는 사람 수, 완료된 사람 수 
		
		while(true) { //매분마다 사람들의 상태를 업데이트 
			for(int i=0;i<size;i++) {
				Person p=list.get(i);
				
				if(p.status==C) continue; // 이미 계단을 다 내려간 사람이면 패스 
				if(p.arrivalTime==time) {
					p.status=W;
				}else if(p.status==W && ingCnt<3) { // 내려갈 수 있음.
					p.status=D;
					p.downCnt=1;
					++ingCnt;
				}else if(p.status==D) {
					if(p.downCnt<height) {
						++p.downCnt;
					}else {
						p.status=C;
						--ingCnt;
						++cCnt;
					}
				}
			}
			if(cCnt==size) break;
			++time;
		}
		return time;
	}
}
