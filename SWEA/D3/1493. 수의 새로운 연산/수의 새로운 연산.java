import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static Map<Integer, int[]> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		
		map=new LinkedHashMap<>();
		initialize();
		//arr=new int[][];
		
		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] pPos=map.get(p);
			int[] qPos=map.get(q);
			
			int[] resultPos= {pPos[0]+qPos[0], pPos[1]+qPos[1]};
			
			System.out.print("#"+t+" ");
			for(int i=1;i<=45000;i++) {
				int[] pos=map.get(i);
				if(pos[0]==resultPos[0] && pos[1]==resultPos[1]) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	private static void initialize() {
		int sum=1;
		int num=1;
		
		map.put(0, new int[] {0,0});
		
		for(int i=sum;num<=45000;i++) {
			for(int j=1;j<=i;j++) {
				map.put(num, new int[] {j,(i+1)-j});
				num++;
			}
		}
	}
}
