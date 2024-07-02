import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        //insertion sorting
        for(int i=1;i<n;i++){
            for(int j=i;j>0&&arr[j]<arr[j-1];j--){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
        }

        
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+arr[i];
        }

        int sum=0;

        for(int e:arr)
            sum+=e;

        System.out.println(sum);
        
    }
}