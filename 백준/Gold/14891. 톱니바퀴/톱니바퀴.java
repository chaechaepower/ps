import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] wheel = new int[5][8];

		for (int i = 1; i <= 4; i++) {
			String line = br.readLine();

			for (int j = 0; j < 8; j++) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향

			int[] dirs=new int[5];
			dirs[num]=dir;
			
			for (int left = num - 1; left >= 1; left--) {
				if(wheel[left][2]!=wheel[left+1][6]) {
					dirs[left] = -dirs[left + 1];
			    } else break;
			}
			
			for(int right=num+1; right<=4;right++) {
				if(wheel[right][6]!=wheel[right-1][2]) {
					dirs[right]=-dirs[right-1];
				}else break;
			}

			for(int i=1;i<=4;i++) {
				if(dirs[i]==1) {
					int temp = wheel[i][7];
			        for (int j = 7; j > 0; j--) {
			            wheel[i][j] = wheel[i][j - 1];
			        }
			        wheel[i][0] = temp;
				}
				else if(dirs[i]==-1) {
					int temp = wheel[i][0];
			        for (int j = 0; j < 7; j++) {
			            wheel[i][j] = wheel[i][j + 1];
			        }
			        wheel[i][7] = temp;
				}
			}
		}

		int sum = 0;
		int weight = 1;

		for (int i = 1; i <= 4; i++, weight *= 2) {
			sum += wheel[i][0] == 0 ? 0 : weight;
		}

		System.out.println(sum);
	}
}
