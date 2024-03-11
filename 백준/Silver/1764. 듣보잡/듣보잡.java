import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String,Integer> listen = new HashMap<>();
		while (n-- > 0) {
			listen.put(br.readLine(),1);
		}

		List<String> inter=new ArrayList<>();
				
		while (m-- > 0) {
			String ppl = br.readLine();
			
			listen.put(ppl, listen.getOrDefault(ppl, 0)+1);
			
			if(listen.get(ppl)==2) {
				inter.add(ppl);
			}
		}
		
		Collections.sort(inter);

		StringBuilder sb = new StringBuilder();
		sb.append(inter.size()).append('\n');
		for(String s:inter) {
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}

}