import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		//선택정렬 
		for(int i=0;i<n-1;i++) {
			int minIdx=i;
			
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx=j;
				}
			}
			
			int temp=arr[minIdx];
			arr[minIdx]=arr[i];
			arr[i]=temp;
		}
		
		StringBuilder sb=new StringBuilder();
		for(int e:arr) {
			sb.append(e).append('\n');
		}
		
		System.out.println(sb);
	}
	
}




