import java.util.Scanner;

public class Main {
    static int N;
    static int[] dx = new int[]{-1, 0};
    static int[] dy = new int[]{0, -1};
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new long[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = 1;
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         if(dp[i][j] == 0) continue;
        //         for(int k = 0; k < 2; k++){
        //             int nx = i + dx[k] * map[i][j];
        //             int ny = j + dy[k] * map[i][j];
                    
        //             if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        //             dp[nx][ny] += dp[i][j];
        //         }
        //     }
        // }
        
        for(int i= 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    for(int dir = 0; dir < 2 ; dir++){
                        int nx = i + dx[dir] * k;
                        int ny = j + dy[dir] * k;
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(k == map[nx][ny]){
                            dp[i][j] += dp[nx][ny];
                        }
                    }
                }
            }
        }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
//         for (int i = 0; i < N; i++) {
//     for (int j = 0; j < N; j++) {
//         if (dp[i][j] == 0 || map[i][j] == 0) continue;

//         int jump = map[i][j];
//         if (i + jump < N) dp[i + jump][j] += dp[i][j];
//         if (j + jump < N) dp[i][j + jump] += dp[i][j];
//     }
// }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[N -1][N - 1]);
    }
}
