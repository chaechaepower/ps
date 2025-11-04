import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] population;
    static ArrayList<Integer>[] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] isSelected;
    static boolean[] isVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        population = new int[N + 1];
        map = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++){
            population[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            int x = sc.nextInt();
            for(int j = 0; j < x; j++){
                int y = sc.nextInt();
                map[i].add(y);
            }
        }
        isSelected = new boolean[N + 1];
        func(0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void addGraph(int x, int y){
        map[x].add(y);
        map[y].add(x);
    }


    static void func(int cnt){
        if(cnt == N){
            int idx1 = -1;
            int idx2 = -1;
            for(int i = 1; i <= N; i++){
                if(isSelected[i]){
                    idx1 = i;
                } else {
                    idx2 = i;
                }
            }
            if(idx1 == -1 || idx2 == -1) return; // 모두 한 팀으로 되었을 때 return
            isVisited = new boolean[N + 1];
            bfs(idx1);
            bfs(idx2);
            for(int i = 1; i <= N; i++){ // 방문 못한 곳이 있다 -> 연결되어 있지 않음
                if(!isVisited[i]) return;
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 1; i <= N; i++){
                if(isSelected[i]){
                    sum1 += population[i];
                } else {
                    sum2 += population[i];
                }
            }
            int result = Math.abs(sum1 - sum2);
            if(result < min){
                min = result;
            }
            return;
        }

        isSelected[cnt + 1] = true;
        func(cnt + 1);

        isSelected[cnt + 1] = false;
        func(cnt + 1);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < map[node].size(); i++){
                int next = map[node].get(i);
                if(isVisited[next]) continue;
                if(isSelected[node] != isSelected[next]) continue;
                isVisited[next] = true;
                q.add(next);
            }
        }
    }
}
