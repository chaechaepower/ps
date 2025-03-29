import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.function.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		if(n==2) {
			System.out.println(0);
			return;
		}
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt=0;
		
		for(int m=0;m<n;m++) {
			int i=0;
			int j=n-1;
			int target=arr[m];
			
			while(i<j) {
				if(i==m) {
					i++;
					if(i>=j) {
						break;
					}
				}
				
				if(j==m) {
					j--;
					if(i>=j) {
						break;
					}
				}
				
				int sum=arr[i]+arr[j];
				
				if(sum<target) {
					i++;
				}
				
				else if(sum>target) {
					j--;
				}
				
				else {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

