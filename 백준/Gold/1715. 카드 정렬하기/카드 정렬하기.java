import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ=new PriorityQueue<>();

        for(int i=0;i<n;i++){
           pQ.offer(Integer.parseInt(br.readLine()));
        }
        
        int result=0;
        while (pQ.size()!=1) {
            int n1=pQ.poll();
            int n2=pQ.poll();
            int sum=n1+n2;
            result+=sum;

            pQ.offer(sum);
        }

        System.out.println(result);
    }
}