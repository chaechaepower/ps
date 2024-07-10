import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int[] arr;
    public static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine()); 

        arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
       
        dfs(0);

        System.out.println(sb);
    }

    //back tracking
    static void dfs(int depth){
        if(depth==n){
            for(int e:arr){
                sb.append(e);
            }
            sb.append('\n');
            return;
        }
        
        for(int i=0;i<=9;i++){

            int num=0;

            for(int e:arr){
                if(e==-1) {
                    break;
                }
                num=num*10+e;
            }

            num=num*10+i;

            if(isPrime(num)){
                arr[depth]=i;
                dfs(depth+1);
                arr[depth]=-1;
            }
        }
    }

    //prime
    static boolean isPrime(int num){

        if(num<2){
            return false;
        }

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}