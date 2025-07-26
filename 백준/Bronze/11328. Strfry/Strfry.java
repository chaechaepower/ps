import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int[] str1 = new int['z' - 'a' + 1];
			int[] str2 = new int['z' - 'a' + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (char ch : st.nextToken().toCharArray()) {
				str1[ch-'a']++;
			}

			for (char ch : st.nextToken().toCharArray()) {
				str2[ch-'a']++;
			}
			
			boolean isPossible=true;
			
			for(int i=0;i<str1.length;i++) {
				if(str1[i]!=str2[i]) {
					isPossible=false;
					break;
				}
			}
			
			if(isPossible) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
		}

	}
}
