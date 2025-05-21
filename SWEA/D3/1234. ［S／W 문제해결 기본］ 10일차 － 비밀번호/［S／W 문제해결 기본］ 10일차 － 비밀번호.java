import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] dirR = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dirC = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			
			List<Character> list=new ArrayList<>();
			
			for(char c:st.nextToken().toCharArray()) {
				list.add(c);
			}
			
			while(true) {
				int i=0;
				for(i=0;i<list.size()-1;i++) {
					if(list.get(i)==list.get(i+1)) {
						list.remove(i);
						list.remove(i);
						break;
					}
				}
				
				if(i==list.size()-1) {
					break;
				}
			}
			
			System.out.printf("#%d ",t);
			for(char c:list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
