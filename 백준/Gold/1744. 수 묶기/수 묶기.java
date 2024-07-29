import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        List<Integer> pList=new ArrayList<>(); //양수 리스트
        List<Integer> nList=new ArrayList<>(); //음수 리스트

        for(int i=0;i<n;i++){
            int input=Integer.parseInt(br.readLine());
            if(input<=0){
                nList.add(input);
            }else{
                pList.add(input);
            }
        }

        Collections.sort(pList, Collections.reverseOrder());
        Collections.sort(nList);

        int result=0;
        
        //pList 계산
        int i=0;
        while(i<pList.size()){
            if(i+1<pList.size()&&pList.get(i)!=1&&pList.get(i+1)!=1){
                result+=pList.get(i++)*pList.get(i++);
            }else{
                result+=pList.get(i++);
            }
        }

        //nList 계산
        i=0;
        while(i<nList.size()){
            if (i+1<nList.size()) {
                result+=nList.get(i++)*nList.get(i++);
            }else{
                result+=nList.get(i++);
            }
        }

        System.out.println(result);

    }
}