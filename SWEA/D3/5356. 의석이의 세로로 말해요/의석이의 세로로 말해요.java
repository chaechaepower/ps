import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testN; t++) {
			char[][] arr = new char[5][15];
			
			for(int i=0;i<5;i++) {
				arr[i]=br.readLine().toCharArray();
			}
			
//			for(int i=0;i<5;i++) {
//				for(int j=0;j<arr[i].length;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			System.out.printf("#%d ",t);
			for(int j=0;j<15;j++) {
				
				for(int i=0;i<5;i++) {
					if(arr[i].length<=j) {
						continue;
					}
					else {
						System.out.print(arr[i][j]);
					}
				}
			}
			System.out.println();
		}
	}

}
