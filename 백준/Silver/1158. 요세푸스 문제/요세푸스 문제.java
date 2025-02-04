import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		List<Integer> result=new ArrayList<>();
		
		int idx=0;
		int cnt=1;
		while(true) {
			if(cnt==k) {
				int num=list.remove(idx);
				result.add(num);
				cnt=0;
				if(list.isEmpty()) {
					break;
				}else {
					cnt++;
					continue;
				}
			}
			idx=(idx+1)%list.size();
			cnt++;
		}
		
		System.out.print("<");
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i)+", ");
			}
		}
		System.out.println(">");
	}
}


