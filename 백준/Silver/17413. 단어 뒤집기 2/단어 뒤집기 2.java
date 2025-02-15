import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringBuilder sb=new StringBuilder();
				
		//<은 >이 끝날 때까지 포인터 계산 후, sb에 붙여넣기 
		//단어는 공백이나 <가 시작하기 전까지 포인터 계산 후, 거꾸로 붙영넣기 
		
		int start=0;
		int end=start;
		
		while(end<str.length()) {
			
			if(str.charAt(start)=='<') {
				while(str.charAt(end)!='>') {
					end++;
				}
					
				sb.append(str.substring(start, end+1));
				end++;
				start=end;
				
			}else {
				while(end<str.length()) {
					if(str.charAt(end)=='<' || str.charAt(end)==' ') {
						break;
					}else {
						end++;
					}
				}
				
				for(int i=end-1;i>=start;i--) {
					sb.append(str.charAt(i));
				}
				
				start=end;
				
				if(end>=str.length()) {
					break;
				}
				
				if(str.charAt(start)==' ') {
					sb.append(' ');
					start++;
					end=start;
				}
			}
		}
		
		System.out.println(sb);
	}
}