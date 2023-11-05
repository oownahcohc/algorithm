package org.example.programmers.level1;

public class 옹알이2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new String[] {"aya", "yee", "u", "maa"});
		System.out.println(result);
	}

	static class Solution {

		public int solution(String[] babbling) {
			int answer = 0;
			for (int i = 0; i < babbling.length; i++) {
				babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", "X");
				babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
				if (babbling[i].isBlank()) {
					answer++;
				}
			}
			return answer;
		}
	}
}
