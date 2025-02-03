import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {		
		Set<String> set=new HashSet<>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		int cnt=0;
		for(int i=0;i<str.length();i++) {
			
			if(i+2<str.length()) {
				String sub3=str.substring(i,i+3);
				if(set.contains(sub3)) {
					cnt++;
					i+=2;
					continue;
				}
			}
			
			if(i+1<str.length()) {
				String sub2=str.substring(i,i+2);
				if(set.contains(sub2)) {
					cnt++;
					i+=1;
					continue;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		
	}
}
