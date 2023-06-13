import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] count=new int[10001];
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			count[num]++;
		}

		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<10001;i++) {
			while(count[i]-->0) {
				sb.append(i).append('\n');
			}
		}

		System.out.println(sb);

	}

}