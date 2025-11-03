import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n,r,c;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		recur((int)Math.pow(2, n),0,0);
		System.out.println(total);
	}

	private static void recur(int size, int i, int j) {
		if(size ==1) return;
		
		int half=size/2;
		
		if(r<i+half && c<j+half) {
			recur(half, i, j);
		}
		if(r<i+half && c>=j+half) {
			total+=half*half;
			recur(half,i,j+half);
		}
		if(r>=i+half && c<j+half) {
			total+=(half*half)*2;
			recur(half,i+half,j);
		}
		if(r>=i+half && c>=j+half) {
			total+=(half*half)*3;
			recur(half,i+half,j+half);
		}
	}
}
