import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

 

public class Solution {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=t;i++) {
			br.readLine();
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			Map<Integer,Integer> gradeCount=new HashMap<>();
			
			for(int c=0;c<1000;c++) {
				int grade=Integer.parseInt(st.nextToken());
				gradeCount.put(grade, gradeCount.getOrDefault(grade, 0)+1);
			}
			
			int ans=0;
			int maxCount=0;
			
			for(int grade:gradeCount.keySet()) {
				if(gradeCount.get(grade)>=maxCount) {
					ans=grade;
					maxCount=gradeCount.get(grade);
				}
			}
			
			System.out.println("#"+i+" "+ans);
		}
	}

	
}
