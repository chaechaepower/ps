import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x: "+x+"y: "+y+"\n";
	}
}

public class Main {
	static int n, m;
	static List<Pos> chicken;
	static List<Pos> house;
	static int[][] map;
	static int ans=Integer.MAX_VALUE; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		chicken = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) { // 집 좌표 모음.
					house.add(new Pos(i, j));
				}
				map[i][j] = num;
			}
		}
		
		dfs(0,0);
		System.out.println(ans);
	}
	
	static void dfs(int depth, int idx) { //n-m개의 치킨집 조합 
		if(depth==m) {
			calChickenDis();
			return;
		}
		
		for(int i=idx;i<n*n;i++) {
			int row=i/n+1;
			int col=i%n+1;
			
			if(map[row][col]==2) {
				chicken.add(new Pos(row,col));
				dfs(depth+1,i+1);
				chicken.remove(depth);
			}
		}
	}

	static void calChickenDis() { //도시의 치킨 거리 계산 
		int chickenDis=0;
		for(Pos h:house) {
			int min=Integer.MAX_VALUE;
			for(Pos c:chicken) {
				int dis=Math.abs(h.x-c.x)+Math.abs(h.y-c.y);
				min=Math.min(min,dis);
			}
			chickenDis+=min;
		}
		calMinChickenDis(chickenDis);
	}
	 
	static void calMinChickenDis(int chickenDis) { //도시의 치킨 거리의 최솟값 계산 
		ans=Math.min(chickenDis, ans);
	}

}
