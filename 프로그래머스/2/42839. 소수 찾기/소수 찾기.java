import java.lang.*;
import java.util.*;

class Solution {
    
    int n; //글자수 
    List<Integer> prime;
    char[] temp; 
    boolean[] visited;
    String orig;
    
    //int가 return 값
    public int solution(String numbers) {
        prime=new ArrayList<>();
        visited=new boolean[numbers.length()];
        orig=new String(numbers);
        
        //글자수가 1~numbers.len
        for(int i=1;i<=numbers.length();i++){
            n=i; 
            temp=new char[n];
            dfs(0);
        }
       
        return prime.size();
    }
    
    void dfs(int depth){
        if(depth==n){
            String newN=new String(temp);
            for(int i=0;i<newN.length();i++){
                if(newN.charAt(i)!='0'){
                    int temp=Integer.parseInt(newN.substring(i));
                    isPrime(temp);
                }
            }
            //소수 판별 함수 호출
            return;
        }
        
        for(int i=0;i<orig.length();i++){
            if(!visited[i]){
                visited[i]=true;
                temp[depth]=orig.charAt(i);
                dfs(depth+1);
                visited[i]=false;
            }
        }
        
    }
    
    //소수 판별함수
    //이미 있는 숫자면 pass
    void isPrime(int num){
        if(num==0 || num==1){
            return;
        }
        
        if(prime.contains(num)){
            return;
        }
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return;
            }
        }
        prime.add(num);
    }
    
}


/*
길이 1~numbers.len에 대해 백트래킹

완성된 숫자의 첫글자가 0인 경우? 
0이 아닌 인덱스부터 읽기. 없으면 0리턴

소수 검사로 넘기기.
소수이면 list에 추가

*/

