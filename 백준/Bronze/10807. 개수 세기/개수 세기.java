import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[201];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        while(n-->0){
            int num=Integer.parseInt(st.nextToken());
            arr[num+100]++;
        }

        int target=Integer.parseInt(br.readLine());
        System.out.println(arr[target+100]);
    }
}

