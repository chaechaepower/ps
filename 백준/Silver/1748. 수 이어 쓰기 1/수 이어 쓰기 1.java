import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sum=0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		recur(num);
		
		System.out.println(sum);
	} 
	
	static void recur(int num) {
		
		int length=String.valueOf(num).length();
		
		if(length==1) {
			sum+=num;
			return;
		}
		
		int cnt=num-(int)Math.pow(10, length-1)+1;
		
		int rem=num-cnt;
		
		sum+= cnt*length;
		
		recur(rem);
	}
}

