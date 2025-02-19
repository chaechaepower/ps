import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		Set<Integer> set=new HashSet<>();
		
		while(n-->0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int x=Integer.parseInt(br.readLine());
		int cnt=0;
		boolean[] isChecked=new boolean[1000000];
		
		for(int k:set) {
			int diff=x-k;
			isChecked[k]=true;
			
			if(set.contains(diff)) {
				if(!isChecked[diff]) {
					isChecked[diff]=true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
	


