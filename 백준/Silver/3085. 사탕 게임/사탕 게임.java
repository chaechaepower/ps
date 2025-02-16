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
				char temp=arr[i][j];
				arr[i][j]=arr[i][j+1];
				arr[i][j+1]=temp;
				
				//최대 개수 셈.
				findMax();
				
				//다시 원래대로 자리 바꿈.
				temp=arr[i][j];
				arr[i][j]=arr[i][j+1];
				arr[i][j+1]=temp;
			}
		}
		
		//열 바꿈. 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) { // 00 10 20
				
				if(arr[j][i]==arr[j+1][i]) {
					continue;
				}
							
				//자리 바꿈.
				char temp=arr[j][i];
				arr[j][i]=arr[j+1][i];
				arr[j+1][i]=temp;
				
				//최대 개수 셈.
				findMax();

				//다시 원래대로 자리 바꿈.
				temp=arr[j][i];
				arr[j][i]=arr[j+1][i];
				arr[j+1][i]=temp;
			}
		}
	}
	
	static void findMax() {
		
		//행 확인
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(arr[i][j]==arr[i][j+1]) {
					cnt++;
				}else {
					max=Math.max(max, cnt);
					cnt=1;
				}
			}
			max=Math.max(max, cnt);
		}
		
		//열 확인 00 10 20 30
		for(int i=0;i<n;i++) { 
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(arr[j][i]==arr[j+1][i]) {
					cnt++;
				}else {
					max=Math.max(max, cnt);
					cnt=1;
				}
			}
			max=Math.max(max, cnt);
		}
		
	}
	
}
