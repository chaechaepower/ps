import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, E;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        E = sc.nextInt();
        int start = sc.nextInt(); 
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            addGraph(x, y, z);
        }  
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int curNode = now[0];
            int curDist = now[1];
            if(isVisited[curNode]) continue;
            isVisited[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                Node next = list[curNode].get(i);
                int n = next.to;
                int w = next.weight;

                if(dist[n] > curDist + w){
                    dist[n] = curDist + w;
                    pq.add(new int[]{n, dist[n]});
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else {
            System.out.println(dist[i]);
            } 
        } 
    }

    static class Node{
        int to, weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static void addGraph(int from, int to, int weight){
        list[from].add(new Node(to, weight));
    }
}
