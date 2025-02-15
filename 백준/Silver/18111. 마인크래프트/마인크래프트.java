import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n,m,b;
	static int ansHeight;
	static int ansTime=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		int max=Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				int h = Integer.parseInt(st.nextToken());
				arr[i][j] = h;
				if(h>max) {
					max=h; //최대 높이 갱신 
				}
			}
		}
		
		bruteForce(max);
		
		System.out.println(ansTime+" "+ansHeight);
	}
	
	static void bruteForce(int max) {
		
		for(int i=0;i<=max;i++) {
			int time=calTime(i);
			
			if(time==-1) {
				continue;
			}
			
			if(time>ansTime) {
				continue;
			}
			
			else if(time<ansTime) {
				ansTime=time;
				ansHeight=i;
			}
			
			else { //time == ansTime
				if(i < ansHeight) {
					continue;
				}else {
					ansHeight=i;
				}
			}
		}
	}
	
	static int calTime(int height) { //모든 땅이 height를 맞추는데 걸리는 시간 
		
		int time = 0;
		int block=b;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int now = arr[i][j];
				
				if(now == height) {
					continue;
				}

				if (now < height) { // 63 64
					time += height - now;
					block -= height- now;
				}

				else if (now > height) { // 64 63
					time += (now - height) * 2;
					block += now - height;
				}
			}
		}
		if(block<0) {
			time=-1;
		}
		return time;
	}
}
