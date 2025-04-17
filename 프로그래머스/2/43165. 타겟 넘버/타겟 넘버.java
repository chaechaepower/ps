import java.util.*;

class Solution {
    char[] opList;
    int[] numberList;
    int len;
    int targetNumber;
    int count;
    
    public int solution(int[] numbers, int target) {
        len=numbers.length;
        opList=new char[len];
        numberList=Arrays.copyOf(numbers,len);
        targetNumber=target;
        dfs(0);
        return count;
    }
    
    public void dfs(int depth){
        if(depth==len){
            calculateTargetNumber();
            return;
        }
        
        for(int i=0;i<2;i++){
            opList[depth]="+-".charAt(i);
            dfs(depth+1);
        }
    }
    
    public void calculateTargetNumber(){
        int result=0;
        
        for(int i=0;i<len;i++){
            char op=opList[i];
            
            if(op=='+'){
                result+=numberList[i];
            }
            
            if(op=='-'){
                result-=numberList[i];
            }
        }
        
        if(result==targetNumber){
            count++;
        }
    }
}