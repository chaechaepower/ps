import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        int answer = 0;  // 전체 작업의 반환시간 합
        int end = 0;     // 현재 시간 (직전 작업이 끝난 시점)
        int idx = 0;     // 아직 PQ에 넣지 않은 작업의 인덱스
        int cnt = 0;     // 처리 완료한 작업 개수

        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 소요 시간이 짧은 작업부터 꺼냄
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (cnt < jobs.length) {

            // 현재 시간까지 요청된 작업을 모두 PQ에 넣음
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }

            // 처리할 작업이 없다면
            // 다음 작업의 요청 시간으로 시간 이동
            if (pq.isEmpty()) {
                end = jobs[idx][0];

            } else {
                // 소요 시간이 가장 짧은 작업 선택
                int[] array = pq.poll();

                // 반환시간 = 종료시간 - 요청시간
                answer += array[1] + end - array[0];

                // 작업 종료 시간 갱신
                end += array[1];

                // 처리한 작업 수 증가
                cnt++;
            }
        }

        return answer / jobs.length;
    }
}