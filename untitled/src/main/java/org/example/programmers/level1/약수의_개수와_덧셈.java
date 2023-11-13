package org.example.programmers.level1;

public class 약수의_개수와_덧셈 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(13, 17);
		System.out.println(result);
	}

	static class Solution {

		public int solution2(int left, int right) {
			int answer = 0;

			for (int i = left; i <= right; i++) {
				//제곱수인 경우 약수의 개수가 홀수
				if (i % Math.sqrt(i) == 0) {
					answer -= i;
				}
				//제곱수가 아닌 경우 약수의 개수가 짝수
				else {
					answer += i;
				}
			}

			return answer;
		}

		public int solution(int left, int right) {
			int answer = 0;

			for (int pivot = left; pivot <= right; pivot++) {
				int temp = pivot;
				int count = 0;
				for (int j = 1; j * j <= temp; j++) {
					if (j * j == temp) {
						count++;
					}  else if (temp % j == 0) {
						count += 2;
					}
				}
				if (count % 2 != 0) {
					temp = -temp;
				}
				answer += temp;
			}

			return answer;
		}
	}
}
