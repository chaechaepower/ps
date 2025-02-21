import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack=new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push('(');
            }
            
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        if(stack.size()==0){
            answer=true;
        }else{
            answer=false;
        }

        return answer;
    }
}

/*
(이면 넣고
)이면 뺀다. 이때 뺼게 없으면(스택 사이즈가 0이면) 바로 false
마지막에 스택 사이즈가 0이면 올바른 괄호 -> true

*/