import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));      
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] arr=new int[7][2];
        while(n-->0){
            st=new StringTokenizer(br.readLine());
            int gender=Integer.parseInt(st.nextToken());
            int grade=Integer.parseInt(st.nextToken());
            
            arr[grade][gender]++;
        }

        int sum=0;

        for(int i=0;i<2;i++){
            for(int j=1;j<=6;j++){
                if(arr[j][i]>0 && arr[j][i]<=m){
                    sum+=1;
                }
                else{
                    sum+=arr[j][i]/m+arr[j][i]%m;
                }
            }
        }

        System.out.println(sum);
    }
}

