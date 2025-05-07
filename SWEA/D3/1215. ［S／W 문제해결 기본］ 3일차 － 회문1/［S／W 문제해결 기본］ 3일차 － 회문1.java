import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int k=Integer.parseInt(br.readLine());
			char[][] arr=new char[8][8];
			
			for(int i=0;i<8;i++) {
				arr[i]=br.readLine().toCharArray();
			}
			
			int answer=0;
			
			//행 
			for(int i=0;i<8;i++) {
				for(int j=0;j<=8-k;j++) {
					//회문 검사 
					boolean isPel=true;
					
					for(int p=j;p<j+(k/2);p++) {
						if(arr[i][(j+k-1)-(p-j)]!=arr[i][p]) {
							isPel=false;
							break;
						}
					}
					if(isPel) {
						answer++;
					}
				}
			}
			
			//열 
			for(int i=0;i<8;i++) { //열 
				for(int j=0;j<=8-k;j++) { //행 
					//회문 검사 
					boolean isPel=true;
					
					for(int p=j;p<j+(k/2);p++) {
						if(arr[(j+k-1)-(p-j)][i]!=arr[p][i]) {
							isPel=false;
						}
					}
					if(isPel) {
						answer++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
