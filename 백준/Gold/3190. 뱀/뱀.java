import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static int time;
	static int[] dr= {0, 1, 0, -1}; //동서남북(시계)
	static int[] dc= {1, 0, -1, 0};
	static Map<Integer, String> map;
	static Deque<int[]> snake;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		arr=new int[n+1][n+1];
		
		int k=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(k-->0) {
			st=new StringTokenizer(br.readLine());
			int row=Integer.parseInt(st.nextToken());
			int col=Integer.parseInt(st.nextToken());
			arr[row][col]=2;
		}
		
		map=new HashMap<>(); //시간-방향 변환 정보
		int l=Integer.parseInt(br.readLine());
		
		while(l-->0) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			String d=st.nextToken();
			map.put(t, d);
		}
		snake=new ArrayDeque<>();
		snake.offerFirst(new int[] {1,1});
		arr[1][1]=1;
		game(0);
		System.out.println(time+1);
	}
	
	static void game(int dir) {
		int[] head=snake.peekFirst();
		int headR=head[0];
		int headC=head[1];
		
		int newR=headR+dr[dir];
		int newC=headC+dc[dir];
		
		//벽
		if(newR < 1 || newR > n || newC <1 || newC > n) {
			return;
		}
			
		//자기 몸
		if(arr[newR][newC]==1) {
			return;
		}
		
		time++;
		
		//사과 o
		if(arr[newR][newC]==2) {
			arr[newR][newC]=1;
			snake.offerFirst(new int[] {newR, newC});
		}else {//사과 x
			snake.offerFirst(new int[] {newR, newC});
			arr[newR][newC]=1;
			
			int[] tail=snake.pollLast();
			int tailR=tail[0];
			int tailC=tail[1];
			
			arr[tailR][tailC]=0;
		}
		
		//방향 전환해야하면 하기
		if(map.containsKey(time)) {
			String dirInfo=map.get(time);
			
			//왼(반시계)
			if(dirInfo.equals("L")) {
				dir=(dir+3)%4;
			}else { //오(시계)
				dir=(dir+1)%4;
			}
		}	
		
		game(dir);
	}
}



/*
 * 사과: 2, 자기 몸: 1, 그냥: 0
 * 동서남북 : 
 * */



