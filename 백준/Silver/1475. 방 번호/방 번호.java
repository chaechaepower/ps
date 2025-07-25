import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        
        int[] count = new int[9]; //9 사용 x
        
        for(char c:String.valueOf(num).toCharArray()){
            int n=c-'0';

            if(n==9){
                count[6]++;
                continue;
            }
            
            count[c-'0']++;
        }

        count[6]=count[6]-count[6]/2;

        int max=0;
        for(int i=0;i<9;i++){
            if(count[i]>max){
                max=count[i];
            }
        }

        System.out.println(max);
    }
}
