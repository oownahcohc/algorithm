package org.example.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 성격유형_검사하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution(
			new String[] {"AN", "CF", "MJ", "RT", "NA"},
			new int[] {5, 3, 2, 7, 5}
		);
		System.out.println(result);
	}

	static class Solution {

		public String solution(String[] survey, int[] choices) {
			for (int i = 0; i < survey.length; i++) {
				int score = choices[i] - 4;
				if (score < 0) {
					String category = String.valueOf(survey[i].charAt(0));
					PersonalityType.addScore(category, Math.abs(score));
				} else if (score > 0) {
					String category = String.valueOf(survey[i].charAt(1));
					PersonalityType.addScore(category, score);
				}
			}

			StringBuilder answer = new StringBuilder();
			for (int num = 1; num <= 4; num++) {
				answer.append(PersonalityType.findLargeScoreType(num));
			}

			return answer.toString();
		}

		private enum PersonalityType {

			R(1, 0), T(1, 0),
			C(2, 0), F(2, 0),
			J(3, 0), M(3, 0),
			A(4, 0), N(4, 0);

			final int num;
			int score;

			PersonalityType(int num, int score) {
				this.num = num;
				this.score = score;
			}

			static void addScore(String category, int score) {
				valueOf(category).score += score;
			}

			static String findLargeScoreType(int num) {
				List<PersonalityType> types = Arrays.stream(values())
					.filter(type -> type.num == num)
					.collect(Collectors.toList());
				int score1 = types.get(0).score;
				int score2 = types.get(1).score;
				if (score1 < score2) {
					return types.get(1).name();
				} else {
					return types.get(0).name();
				}
			}
		}
	}
}
