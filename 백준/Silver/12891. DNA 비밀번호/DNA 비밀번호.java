import java.io.*;
import java.util.*;

public class Main {

    // 'A','C','G','T' -> 0,1,2,3
    static int toIdx(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().trim().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] need = new int[4];       // 최소 필요 개수
        for (int i = 0; i < 4; i++) need[i] = Integer.parseInt(st.nextToken());

        int[] cur = new int[4];        // 현재 윈도우 내 개수
        int satisfied = 0;             // 조건을 만족한 문자 종류 수

        // (핵심1) need가 0이면 처음부터 만족 처리
        for (int i = 0; i < 4; i++) if (need[i] == 0) satisfied++;

        // 초기 윈도우 [0, P)
        for (int i = 0; i < P; i++) {
            int idx = toIdx(arr[i]);
            cur[idx]++;
            if (cur[idx] == need[idx]) satisfied++; // 막 필요치에 도달했을 때만 +1
        }

        int answer = (satisfied == 4) ? 1 : 0;

        // 슬라이딩
        for (int left = 0, right = P; right < S; left++, right++) {
            int li = toIdx(arr[left]);
            // (핵심2) 빼기 전에 "바로 지금 need를 딱 충족 중인지"만 본다.
            // 또한 need가 0인 경우엔 satisfied를 건드리면 안 된다.
            if (need[li] > 0 && cur[li] == need[li]) satisfied--;
            cur[li]--;

            int ri = toIdx(arr[right]);
            cur[ri]++;
            if (cur[ri] == need[ri]) satisfied++; // 추가로 막 필요치에 도달하면 +1

            if (satisfied == 4) answer++;
        }

        System.out.println(answer);
    }
}
