class Solution {
	public int solution(int[] cookie) {
		int n = cookie.length;

		int answer = 0;

		for (int i = 0; i < n - 1; i++) { // m을 모든 i에 대해서 확인
			int m = i;

			int l = m, r = m + 1;

			int lSum = cookie[l], rSum = cookie[r];

			while (0 <= l && r < n) {
				if (lSum == rSum) {
					answer=Math.max(answer, rSum);
				}
				
				if(lSum<rSum) {
					if(l==0) break;
					
					l--;
					lSum+=cookie[l];
				}
				
				else {
					if(r==n-1) break;
					
					r++;
					rSum+=cookie[r];
				}
			}
		}
		
		return answer;
	}
}