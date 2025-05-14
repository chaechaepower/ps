import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testN; t++) {
			char[] arr = br.readLine().toCharArray();
			char[] base = new char[arr.length];
			for(int i=0;i<base.length;i++) {
				base[i]='0';
			}

			int idx = 0;
			int modifyCount = 0;

			while (idx < arr.length) {

				if (arr[idx] == base[idx]) {
					idx++;
				}

				else {
					char ch = arr[idx];

					for (int i = idx; i < base.length; i++) {
						base[i] = ch;
					}
					
					modifyCount++;
				}
				
			}

			System.out.printf("#%d %d\n", t, modifyCount);
		}
	}

}
