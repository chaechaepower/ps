import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		while (n-- > 0) {
			set.add(br.readLine());
		}

		List<String> list=new ArrayList<>();
		
		while(m-->0) {
			String name=br.readLine();
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb=new StringBuilder();
		sb.append(list.size()).append('\n');
		
		for(String s:list) {
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}
}