import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		while(testN-->0) {
			st=new StringTokenizer(br.readLine()," ", true);
			while(st.hasMoreTokens()) {
				
				String word=st.nextToken();
				
				if(word.equals(" ")) {
					sb.append(" ");
				}else {
					for(int i=word.length()-1;i>=0;i--) {
						sb.append(word.charAt(i));
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
}

