import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		
		long max=0;
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]>max) {
				max=arr[i];
			}
		}

		max++;
		
		long min=0;
		long mid=0;
		
		while(min<max) {
			
			mid=(min+max)/2;
			
			long length=0;
			
			for(int i=0;i<N;i++) {
				if(arr[i]-mid>0){
					length+=(arr[i]-mid);
				}
			}
			
			if(length<M) {
				max=mid;
			}
			else {
				min=mid+1;
			}
			
		}
		System.out.println(max-1);
	}
}