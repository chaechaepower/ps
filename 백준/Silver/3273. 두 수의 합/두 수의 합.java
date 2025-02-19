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
		
		Map<Integer, Boolean> map=new HashMap<>();
		
		while(n-->0) {
			map.put(Integer.parseInt(st.nextToken()), false);
		}
		
		int x=Integer.parseInt(br.readLine());
		
		Set<Integer> keySet=new HashSet<>(map.keySet());
		int cnt=0;
		
		for(int k:keySet) {
			int diff=x-k;
			map.put(k, true);
			
			if(keySet.contains(diff)) { //차이에 해당하는 수가 존재하고, 
				if(!map.get(diff)) { //아직 그 수를 카운팅 안했다면
					cnt++;
					map.put(diff, true);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
	