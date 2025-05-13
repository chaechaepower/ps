import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Ingredient {
	int grade;
	int cal;

	public Ingredient(int grade, int cal) {
		this.grade = grade;
		this.cal = cal;
	}
}

public class Solution {
	static int n;
	static int lessCal;
	static Ingredient[] ingredients;
	static int maxGradeSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			lessCal = Integer.parseInt(st.nextToken());
			ingredients = new Ingredient[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int grade = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());

				ingredients[i] = new Ingredient(grade, cal);
			}

			maxGradeSum = Integer.MIN_VALUE;

			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, maxGradeSum);
		}
	}

	public static void dfs(int calSum, int gradeSum, int count) {
		if (count == n) {
			if (calSum <= lessCal) {
				if (gradeSum > maxGradeSum) {
					maxGradeSum = gradeSum;
				}
			}
			return;
		}

		// 포함하는 경우
		dfs(calSum + ingredients[count].cal, gradeSum + ingredients[count].grade, count + 1);

		// 포함하지 않는 경우
		dfs(calSum, gradeSum, count + 1);
	}

}
