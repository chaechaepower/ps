import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	private static Map<String, String> parent; // 부모 
	private static Map<String, Integer> count; // 네트워크에 속하는 사람 수 
	
	private static String find(String name) {
		if(!parent.get(name).equals(name)) {
			parent.put(name, find(parent.get(name)));
		}
		
		return parent.get(name);
	}
	
	private static void union(String name1, String name2) {
		String root1=find(name1);
		String root2=find(name2);
		
		if(root1.equals(root2)) return;
		
		parent.put(root2, root1);
		count.put(root1, count.get(root1)+count.get(root2));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(testN-->0) {
			int f=Integer.parseInt(br.readLine());
			
			parent=new HashMap<>(); 
			count=new HashMap<>(); 
			
			while(f-->0) {
				st=new StringTokenizer(br.readLine());
				
				String name1=st.nextToken();
				String name2=st.nextToken();
				
				// 초기화. 네트워크 생성 
				if(!parent.containsKey(name1)) {
					parent.put(name1, name1);
					count.put(name1, 1);
				}
				
				if(!parent.containsKey(name2)) {
					parent.put(name2, name2);
					count.put(name2, 1);
				}
				
				// 두 네트워크 합치기
				union(name1, name2);
				System.out.println(count.get(find(name1)));
			}
		}
	}
}	


/*
 * 입력 이름에 해당하는 집합이 없을 경우 만든다. 
 * 있으면 해당 집합 사용한다.
 * 두 집합을 union한다.
 * 그 집합의 크기 출력
 * */
 
