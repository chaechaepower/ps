import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		int[] arr=new int [20000001];
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());
			arr[input+10000000]++;
		}
		
		int M=Integer.parseInt(bf.readLine());
		
		st=new StringTokenizer(bf.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int key=Integer.parseInt(st.nextToken());
			sb.append(arr[key+10000000]).append(' ');
		}
		
		System.out.println(sb);

	}

}