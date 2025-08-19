import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
        int n=Integer.parseInt(br.readLine());
        arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        int m=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            int key=Integer.parseInt(st.nextToken());
            sb.append(binarySearch(0,n-1,key)).append('\n');
        }

        System.out.println(sb);
        
        
    }

    public static int binarySearch(int l, int r, int key){

        while(l<=r){
            int m=(l+r)/2;
            
            if(key<arr[m]) {
                r=m-1;
            }
            else if(key>arr[m]) {
                l=m+1;
            }
            else{ //key==arr[m]
                return 1;
            }
        }
        return 0;
    }
}
