import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		
		Set<Integer> set=new HashSet<>();
		StringBuilder sb=new StringBuilder();
		
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x;
			
			switch(st.nextToken()) {
			case "add":
				x=Integer.parseInt(st.nextToken());
				set.add(x);
				break;
				
			case "remove":
				x=Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					set.remove(x);
				}
				break;
				
			case "check":
				x=Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
				break;
				
			case "toggle":
				x=Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					set.remove(x);
				}else {
					set.add(x);
				}
				break;
				
			case "all":
				List<Integer> list=new ArrayList<>();
				for(int i=1;i<=20;i++) {
					list.add(i);
				}
				set.clear();
				set.addAll(list);
				break;
				
			case "empty":
				set.clear();
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
