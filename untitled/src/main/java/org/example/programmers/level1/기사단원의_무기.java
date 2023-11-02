package org.example.programmers.level1;

public class 기사단원의_무기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(10, 3, 2);
		System.out.println(result);
	}

	static class Solution {

		public int solution(int number, int limit, int power) {
			int answer = 0;
			for (int unit = 1; unit <= number; unit++) {
				int weapon = 0;
				for (int i = 1; i * i <= unit; i++) {
					if (i * i == unit) {
						weapon++;
					} else if (unit % i == 0) {
						weapon += 2;
					}
				}
				if (weapon > limit) {
					weapon = power;
				}
				answer += weapon;
			}
			return answer;
		}
	}
}
