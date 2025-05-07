import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			char[] str=br.readLine().toCharArray();
			
			Map<Character,Integer> map=new HashMap<>();

			for(char c:str) {
				map.put(c, map.getOrDefault(c, 0)+1);
			}
			
			List<Character> keySet=new ArrayList<>(map.keySet());

			keySet.sort((c1,c2)->{
				return map.get(c1)-map.get(c2);
			});
			
			int candidate=str.length/(map.get(keySet.get(0)));
			
			if(str[0]==str[candidate]) {
				System.out.println("#"+t+" "+candidate);
			}
			else {
				System.out.println("#"+t+" "+(candidate-1));
			}
		}
	}
}
