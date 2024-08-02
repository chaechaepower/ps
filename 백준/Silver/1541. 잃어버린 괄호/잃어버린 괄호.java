import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(),"-");

        int sum=Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            
            String str=st.nextToken();

            StringTokenizer add=new StringTokenizer(str,"+");

            int temp=0;
            while (add.hasMoreTokens()) {
                temp+=Integer.parseInt(add.nextToken());
            }
            
            if (sum==Integer.MAX_VALUE) { //처음일 경우
                sum=temp;
            }else{
                sum-=temp;
            }
        }

        System.out.println(sum);
    }
}