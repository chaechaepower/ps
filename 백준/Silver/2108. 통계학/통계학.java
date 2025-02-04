import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int mean=0;
		for(int e:list) {
			mean+=e;
		}
		mean=((int)Math.round((double)mean/n));
		
		Collections.sort(list);
		
		int mid=list.get((n-1)/2); //중앙값 
		int range=list.get(n-1)-list.get(0); //범위 
		
		Map<Integer, Integer> map=new HashMap<>();
		for(int e:list) {
			map.put(e, map.getOrDefault(e, 0)+1);
		}
				
		List<Integer> keySet=new ArrayList<>(map.keySet());
		keySet.sort((o1,o2)->{			
			if(map.get(o1)==map.get(o2)) {
				return o1-o2; 
			}else {
				return map.get(o2)-map.get(o1);
			}
			
		}); //빈도수로 내림차순하되, 같면 key를 기준으로 오름차순 
	
		int freq=keySet.get(0);
		
		if(n>1) {
			freq=map.get(freq)==map.get(keySet.get(1))?keySet.get(1):keySet.get(0);
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(mean).append('\n'); 
		sb.append(mid).append('\n');
		sb.append(freq).append('\n'); 
		sb.append(range).append('\n');
		System.out.println(sb);
	}
}

