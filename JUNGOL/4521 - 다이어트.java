import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
	static int n;
    static int mp, mf, ms, mv;
    static int[][] ingredients;
    static List<Integer> temp;
    static List<Integer> result;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        temp = new ArrayList<>(); //1부터 시작

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        ingredients = new int[n+1][5]; //단 지 탄 비 가격
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            ingredients[i][0]=Integer.parseInt(st.nextToken());
            ingredients[i][1]=Integer.parseInt(st.nextToken());
            ingredients[i][2]=Integer.parseInt(st.nextToken());
            ingredients[i][3]=Integer.parseInt(st.nextToken());
            ingredients[i][4]=Integer.parseInt(st.nextToken());
        }
        
        min = Integer.MAX_VALUE;
        dfs(1,0,0,0,0,0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        System.out.println(min);
        for(int e:result){
            System.out.print(e+" ");
        }
    }

    private static void dfs(int depth, int nowMP, int nowMF, int nowMS, int nowMV, int cost){
        if(cost>min){
            return;
        }

        if(depth == n+1){
            if(nowMP >= mp && nowMF >= mf && nowMS >= ms && nowMV >= mv){
                if(cost<min){
                    min = cost;
                    result = new ArrayList<>(temp);
                }

                else if(cost == min && isFront()){
                    result = new ArrayList<>(temp);
                }
            }
            return;
        }

        temp.add(depth);
        dfs(
            depth+1,
            nowMP+ingredients[depth][0],
            nowMF+ingredients[depth][1],
            nowMS+ingredients[depth][2],
            nowMV+ingredients[depth][3],
            cost+ingredients[depth][4]
        );
        temp.remove(temp.size()-1);

        dfs(
            depth+1,
            nowMP,
            nowMF,
            nowMS,
            nowMV,
            cost
        );
    }

    private static boolean isFront(){ // temp가 사전순 더 앞인지
        for(int i=0;i<Math.min(temp.size(),result.size());i++){
            if(temp.get(i)!=result.get(i)){
                return temp.get(i)<result.get(i);
            }
        }
    
        return temp.size() < result.size();
    }
}


/*
조합


*/