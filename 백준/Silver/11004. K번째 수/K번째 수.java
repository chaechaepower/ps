import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str=bf.readLine();
		
		StringTokenizer st=new StringTokenizer(str);
		int N=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int arr[]=new int[N];
		
		str=bf.readLine();
		st=new StringTokenizer(str);
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		System.out.println(arr[k-1]);
	}
	
	
}