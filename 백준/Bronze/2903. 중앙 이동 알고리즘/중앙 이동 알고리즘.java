import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
		br.close();
        
		int k=2;
		
		
		for(int i=1;i<=n;i++) {
			k=k+k-1;
		}
		System.out.println(k*k);
        
    }
}