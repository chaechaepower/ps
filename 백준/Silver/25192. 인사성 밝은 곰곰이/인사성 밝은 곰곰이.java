import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		Set<String> set=new HashSet<>();
		
		int cnt=0;
		
		while(n-->0) {
			String str=br.readLine();
			
			if(str.equals("ENTER")) {
				set.clear();
			}else if(set.contains(str)) {
				continue;
			}else {
				set.add(str);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}