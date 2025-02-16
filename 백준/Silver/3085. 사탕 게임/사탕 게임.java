import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static char[][] arr;
	static int n;
	static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		arr=new char[n][n];
		
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		brute();
		System.out.println(max);
		
	}
	
	//위치 바꾼다
	//바꾼 뒤 사탕 개수 
	static void brute() {
		
		//행 바꿈. 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) { //00 01 02
				
				if(arr[i][j]==arr[i][j+1]) {
					continue;
				}
							
				//자리 바꿈.
				swap(i,j,i,j+1);
				
				//최대 개수 셈.
				findMax();
				
				//다시 원래대로 자리 바꿈.
				swap(i,j,i,j+1);
			}
		}
		
		//열 바꿈. 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) { // 00 10 20
				
				if(arr[j][i]==arr[j+1][i]) {
					continue;
				}
							
				//자리 바꿈. 
				swap(j,i,j+1,i);
				
				//최대 개수 셈.
				findMax();

				//다시 원래대로 자리 바꿈.
				swap(j,i,j+1,i);
			}
		}
	}
	
	static void swap(int x1, int y1, int x2, int y2) {
		char temp=arr[x1][y1];
		arr[x1][y1]=arr[x2][y2];
		arr[x2][y2]=temp;
	}
	
	static void findMax() {
		
		//행 확인
		for(int i=0;i<n;i++) {
			int cnt=1;
			
			for(int j=0;j<n-1;j++) {
				if(arr[i][j]==arr[i][j+1]) {
					cnt++;
					max=Math.max(max, cnt);
				}else {
					cnt=1;
				}
			}
		}
		
		//열 확인 00 10 20 30
		for(int i=0;i<n;i++) { 
			int cnt=1;
			
			for(int j=0;j<n-1;j++) {
				if(arr[j][i]==arr[j+1][i]) {
					cnt++;
					max=Math.max(max, cnt);
				}else {
					cnt=1;
				}
			}
		}
		
	}
	
}
