import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));      
        
        int[] str1=new int['z'-'a'+1];
        int[] str2=new int['z'-'a'+1];

        for(char ch:br.readLine().toCharArray()){
            str1[ch-'a']++;
        }
        
        for(char ch:br.readLine().toCharArray()){
            str2[ch-'a']++;
        }

        int result=0;

        for(int i=0;i<'z'-'a'+1;i++){
            if(str1[i]!=str2[i]){
                if(str1[i]==0){
                    result+=str2[i];
                    continue;
                }
                if(str2[i]==0){
                    result+=str1[i];
                    continue;
                }
                result+=Math.abs(str1[i]-str2[i]);
            }
        }
        
        System.out.println(result);
    }
}

