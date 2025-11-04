import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static char[] op;
    static boolean[] isSelected;
    static int sum_op;
    static char[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = sc.nextInt();
        }
        operator = new int[4];
        sum_op = 0;
        for(int i = 0; i < 4; i++){
            operator[i] = sc.nextInt();
            sum_op += operator[i];
        }
        op = new char[sum_op];
        result = new char[sum_op];
        int idx = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < operator[i]; j++){
                if(i == 0){
                    op[idx++] = '+'; 
                } else if(i == 1){
                    op[idx++] = '-';
                } else if(i == 2){
                    op[idx++] = '*';
                } else {
                    op[idx++] = '/';
                }
            }
        }
        isSelected = new boolean[sum_op];
        // for(int i = 0; i < sum_op; i++){
        //     System.out.println(op[i]);
        // }
        per(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void per(int cnt){
        if(cnt == sum_op){
            int value = calc();
            max = Math.max(value, max);
            min = Math.min(value, min);
            return ;
        }

        for(int i = 0; i < sum_op; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = op[i];
            per(cnt + 1);
            isSelected[i] = false;
        }
    }

    static int calc(){
        int res = numbers[0];
        for(int i = 0; i < sum_op; i++){
        char c = result[i]; 
        int nextNum = numbers[i + 1];
        switch(c){
            case '+': res += nextNum; break;
            case '-': res -= nextNum; break;
            case '*': res *= nextNum; break;
            case '/': res /= nextNum; break; 
        }
    }
    return res;
    }
}
