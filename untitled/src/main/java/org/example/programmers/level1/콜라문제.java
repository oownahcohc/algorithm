package org.example.programmers.level1;

public class 콜라문제 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(3, 1, 20);
		System.out.println(result);
	}

	static class Solution {
		public int solution(int a, int b, int n) {
			int answer = 0;
			while ((n / a) != 0) {
				int emptyBottle = n / a * a;
				int received = emptyBottle / a * b;
				answer += received;
				n = n - emptyBottle + received;
			}
			return answer;
		}
	}
}
