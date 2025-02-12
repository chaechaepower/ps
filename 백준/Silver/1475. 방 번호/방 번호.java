import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer,Integer> map=new HashMap<>();
		for(char c:br.readLine().toCharArray()) {
			int n=c-'0';
			
			if(n==6 || n==9) {
				
				int minK, minV;
				
				int six=map.getOrDefault(6, 0);
				int nine=map.getOrDefault(9, 0);
				
				if(six<=nine) {
					minK=6;
					minV=six;
				}else {
					minK=9;
					minV=nine;
				}		
				map.put(minK, minV+1);
				
			}else {
				map.put(n, map.getOrDefault(n, 0)+1);
			}
		}
		
		List<Integer> keySet=new ArrayList<>(map.keySet());
		keySet.sort((o1,o2)->map.get(o2)-map.get(o1));
		
		System.out.println(map.get(keySet.get(0)));
		
	}

}
