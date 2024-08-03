import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());

        boolean[] prime=new boolean[n+1]; 

        for(int i=2;i<prime.length;i++){
            prime[i]=true;
        }

        for(int i=2;i<n+1;i++){
            while (!prime[i]) {
                i++;
                if (i>=n) {
                    break;
                }
            }
            
            for(int j=i+i;j<n+1;j+=i){
                prime[j]=false;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=m;i<=n;i++){
            if (prime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
      
    }
}