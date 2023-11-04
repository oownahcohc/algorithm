package org.example.programmers.level1;

public class 푸드파이트_대회 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution(new int[] {1, 3, 4, 6});
		System.out.println(result);
	}

	static class Solution {
		public String solution(int[] food) {
			StringBuilder answer = new StringBuilder();
			for (int i = 1; i < food.length; i++) {
				int count = food[i] / 2;
				answer.append(String.valueOf(i).repeat(count));
			}
			answer.append(0);

			for (int i = food.length - 1; i >= 1; i--) {
				int count = food[i] / 2;
				answer.append(String.valueOf(i).repeat(count));
			}

			return answer.toString();
		}
	}
}
