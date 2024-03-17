import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int testN=Integer.parseInt(br.readLine());
 
		while(testN-->0) {
			String str=br.readLine();
			
			int score=0;
			int cons=0;
			for(int i=0;i<str.length();i++) {
				
				if(str.charAt(i)=='O') {
					cons++;
					score+=cons;
				}else {
					cons=0;
				}
			}
			
			System.out.println(score);
			
		}
 
	}
}