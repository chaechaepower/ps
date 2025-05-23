import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int[] sArr = new int[14]; // 0은 제외
			int[] dArr = new int[14];
			int[] hArr = new int[14];
			int[] cArr = new int[14];

			String str = br.readLine();
			int strLen = str.length();

			int sLack = 13;
			int dLack = 13;
			int hLack = 13;
			int cLack = 13;
			boolean isError=false;

			for (int i = 0; i <= strLen - 3; i += 3) {
				String cardInfo = str.substring(i, i + 3);

				char c = cardInfo.charAt(0);
				int digit1 = cardInfo.charAt(1) - '0';
				int digit2 = cardInfo.charAt(2) - '0';
				int num = 10 * digit1 + digit2;

				switch (c) {
				case 'S':
					if (sArr[num] >= 1) {
						isError=true;
						break;
					}
					sArr[num]++;
					sLack--;
					break;
				case 'D':
					if (dArr[num] >= 1) {
						isError=true;
						break;
					}
					dLack--;
					dArr[num]++;
					break;
				case 'H':
					if (hArr[num] >= 1) {
						isError=true;
						break;
					}
					hLack--;
					hArr[num]++;
					break;
				case 'C':
					if (cArr[num] >= 1) {
						isError=true;
						break;
					}
					cArr[num]++;
					cLack--;
					break;
				}
				
				if(isError) {
					break;
				}
			}
			
			System.out.printf("#%d ", t);
			if(!isError) {
				System.out.printf("%d %d %d %d\n", sLack, dLack, hLack, cLack);
			}
			else {
				System.out.print("ERROR\n");
			}
		}
	}

}
