import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    StringBuilder sb=new StringBuilder();
	    int[] arr={25,10,5,1};
	    
	    while(T-->0) {
	    	int input=Integer.parseInt(br.readLine());
	    	for(int e:arr) {
	    		int sh=input/e;
	    		sb.append(sh+" ");
	    		input%=e;
	    	}
	    	sb.append("\n");
	    }
	    System.out.println(sb);
    }
}