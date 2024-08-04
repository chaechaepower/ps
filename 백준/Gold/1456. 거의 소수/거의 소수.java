import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    
    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());

        int max=(int)Math.sqrt(b);

        boolean[] prime=new boolean[max+1]; 

        for(int i=2;i<prime.length;i++){ 
            prime[i]=true;
        }

        //소수이면 true, 아니면 false

        int cnt=0;
        for(int i=2;i<=max;i++){
            if (!prime[i]) {
                continue;
            }

            //현재 i(소수)에 대해서 거의 소수 카운팅
            long temp=i;
            while ((double)i<=(double)b/(double)temp) {
                if ((double)i>=(double)a/(double)temp) {
                    cnt++;
                }
                temp*=i;
            }

            for(int j=i+i;j<=max;j+=i){
                prime[j]=false;
            }
        }

        System.out.println(cnt);
    }
}