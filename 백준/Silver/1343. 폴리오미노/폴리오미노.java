import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static final String poly1="AAAA";
	public static final String poly2="BB";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringTokenizer st=new StringTokenizer(br.readLine(),".",true);
		StringBuilder sb=new StringBuilder();
		
		while(st.hasMoreTokens()) {
			String token=st.nextToken();
			
			if(token.startsWith(".")) {
				sb.append(token);
				continue;
			}
			
			int tokenLen=token.length();
			int findX=-1;
			int findY=-1;
			
			boolean isFound=false;
			
			for(int y=0;y<tokenLen;y++) {
				for(int x=0;x<tokenLen;x++) {
					if(!isFound) {
						if(4*x+2*y==tokenLen) {
							findX=x;
							findY=y;
							isFound=true;
						}
					}
				}
			}
			
			if(isFound) {
				for(int i=0;i<findX;i++) {
					sb.append(poly1);
				}
				for(int i=0;i<findY;i++) {
					sb.append(poly2);
				}
			}
			else {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(sb);
	}
}