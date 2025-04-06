import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
	
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
	
		int cutoff=(int) Math.round(n*0.15);
		
		int count=n-cutoff*2;
		
		int sum=0;
		for(int i=cutoff;i<n-cutoff;i++) {
			sum+=list.get(i);
		}
		
		int mean=(int)Math.round((double)sum/count);
		System.out.println(mean);
		
	
	}
}

