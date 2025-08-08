import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static List<Integer> inCards;
    static List<Integer> gyoCards;
    static boolean[] visited;
    static List<Integer> randInCards;
    static int inwin;
    static int inLose;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int testN=Integer.parseInt(br.readLine());

        for(int t=1;t<=testN;t++){
            inCards=new ArrayList<>();
            gyoCards=new ArrayList<>();

            StringTokenizer st=new StringTokenizer(br.readLine());
            
            for(int i=0;i<9;i++){
                gyoCards.add(Integer.parseInt(st.nextToken()));
            }

            for(int i=1;i<19;i++){
                if(gyoCards.contains(i)){
                    continue;
                }
                inCards.add(i);
            }

            randInCards=new ArrayList<>();
            visited=new boolean[9];
            inwin=0; inLose=0;
            dfs(0,0);

            System.out.printf("#%d %d %d\n",t,inLose,inwin);
        }
    }

    public static void dfs(int v, int depth){
        if(depth==9){
            game();
            return;
        }

        for(int i=0;i<9;i++){
            if(!visited[i]){
                visited[i]=true;
                randInCards.add(inCards.get(i));
                dfs(i,depth+1);
                randInCards.remove(randInCards.size()-1);
                visited[i]=false;

            }
        }
    }

    public static void game(){
        int gyoSum=0;
        int inSum=0;

        for(int i=0;i<9;i++){
            if(randInCards.get(i)>gyoCards.get(i)){
                inSum+=randInCards.get(i)+gyoCards.get(i);
            }
            else{
                gyoSum+=randInCards.get(i)+gyoCards.get(i);
            }
        }

        if(inSum>gyoSum){
            inwin++;
        } 
        else{
            inLose++;
        }
    }    
}
