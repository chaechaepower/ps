import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n=Integer.parseInt(br.readLine());
			
			int[][] arr=new int[n][n];
			StringTokenizer st;
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			int[][] rotateArr1=rotate(arr); //90
			int[][] rotateArr2=rotate(rotateArr1); //180
			int[][] rotateArr3=rotate(rotateArr2); //270 

			System.out.printf("#%d\n",t);
			
			for(int i=0;i<n;i++) {
				printArr(rotateArr1, i);
				printArr(rotateArr2, i);
				printArr(rotateArr3, i);
				System.out.println();
			}
		}
	}
	
	 private static int[][] rotate(int[][] arr) {
		 int n=arr.length;
		 int[][] temp=new int[n][n];
		 
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 temp[i][j]=arr[n-j-1][i];
			 }
		 }
		 
		 return temp;
	 }
	 
	 private static void printArr(int[][] arr, int r) { //r행 모든 열 출력
		 int n=arr.length;
		 
		 for(int i=0;i<n;i++) {
			System.out.print(arr[r][i]);
		 }
		 System.out.print(" ");
	 }
}
