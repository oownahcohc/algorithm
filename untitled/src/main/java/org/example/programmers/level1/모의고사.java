package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(new int[] {1, 2, 3, 4, 5});
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		
		private static final int[] SOO_PO_JA_1 = new int[] {1, 2, 3, 4, 5};
		private static final int[] SOO_PO_JA_2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		private static final int[] SOO_PO_JA_3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		public int[] solution(int[] answers) {
			int[] scores = new int[3];
			for (int i = 0; i < answers.length; i++) {
				if (SOO_PO_JA_1[i % SOO_PO_JA_1.length] == answers[i]) {
					scores[0]++;
				}
				if (SOO_PO_JA_2[i % SOO_PO_JA_2.length] == answers[i]) {
					scores[1]++;
				}
				if (SOO_PO_JA_3[i % SOO_PO_JA_3.length] == answers[i]) {
					scores[2]++;
				}
			}

			List<Integer> result = new ArrayList<>();
			int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] == maxScore) {
					result.add(i + 1);
				}
			}

			return result.stream()
				.mapToInt(value -> value)
				.toArray();
		}
	}
}
