import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] input=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		List<Integer> seq=new ArrayList<>();
		for(int i=n;i>=1;i--) {
			seq.add(input[i],i);
		}
		
		for(int e:seq) {
			System.out.print(e+" ");
		}
	}
}

