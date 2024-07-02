import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] arr=br.readLine().toCharArray();

        int n=arr.length;

        for(int i=0;i<n-1;i++){
            int max=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[max])
                    max=j;         
            }
            char temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
        }

        for(char c:arr)
            System.out.print(c);
    }
}