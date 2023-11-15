package org.example.programmers.level1;

public class 삼진법_뒤집기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(125);
		System.out.println(result);
	}

	static class Solution {
		public int solution(int n) {
			int temp = n;
			int count = 0;
			while (temp != 0) {
				temp = temp / 3;
				count++;
			}

			int answer = 0;
			for (int i = count - 1; i >= 0; i--) {
				answer += (n % 3) * Math.pow(3, i);
				n /= 3;
			}

			return answer;
		}
	}
}
