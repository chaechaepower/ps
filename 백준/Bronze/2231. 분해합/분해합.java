import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        
        for(int i=1;i<n;i++) {
        	int sh=i;
        	int rem=i;
        	int sum=i;
        	
        	while(sh>0) {
        		rem=sh%10;
        		sum+=rem;
        		sh/=10;
        	}
        	
        	if(sum==n) {
        		System.out.println(i);
        		return;
        	}
        }
        
        System.out.println(0);
        
    }
}
