import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		List<Integer> list=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			int target=list.get(i);
				
			int p=0;
			int q=n-1;
			
			while(p<q) {
				if(p==i) {
					p++;
					if(p>=q) {
						break;
					}
				}
				if(q==i) {
					q--;
					if(q<=p) {
						break;
					}
				}
				
				int sum=list.get(p)+list.get(q);
				
				if(sum<target) {
					p++;
				}
				else if(sum>target) {
					q--;
				}
				else {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

