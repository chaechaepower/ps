import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // 주차 공간 개수
			int m = Integer.parseInt(st.nextToken()); // 차량 개수
			
			int[] parkings = new int[n + 1]; // 주차 공간의 단위 무게당 요금
			int[] cars = new int[m + 1]; // 차량의 무게

			for (int i = 1; i <= n; i++) {
				parkings[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i <= m; i++) {
				cars[i] = Integer.parseInt(br.readLine());
			}

			PriorityQueue<Integer> emptyParking = new PriorityQueue<>();
			for (int i = 1; i <= n; i++) {
				emptyParking.offer(i);
			}
			Queue<Integer> waitingCars = new LinkedList<>();
			int[] carInParking = new int[m + 1]; // 차량이 있는 주차공간

			int profit = 0;
			int count = m * 2;
			while (count-- > 0) {
				int car = Integer.parseInt(br.readLine());

				if (car > 0) {
					if (emptyParking.isEmpty()) {
						waitingCars.offer(car);
					} else {
						int parking = emptyParking.poll();
						carInParking[car] = parking;
						profit += parkings[parking] * cars[car];
					}
				} else {
					emptyParking.offer(carInParking[-1*car]);
					if(!waitingCars.isEmpty()) {
						int watingCar=waitingCars.poll();
						int parking = emptyParking.poll();
						carInParking[watingCar] = parking;
						profit += parkings[parking] * cars[watingCar];
					}
				}
			}

			System.out.print("#" + t + " ");
			System.out.println(profit);
		}
	}

}
