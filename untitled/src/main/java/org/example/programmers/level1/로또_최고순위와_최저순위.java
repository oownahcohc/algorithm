package org.example.programmers.level1;

import java.util.Arrays;

public class 로또_최고순위와_최저순위 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19});
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(int[] lottos, int[] winNums) {
			int zeroCount = 0;
			int sameCount = 0;
			for (int lotto : lottos) {
				if (lotto == 0) {
					zeroCount++;
				}
				for (int winNum : winNums) {
					if (lotto == winNum) {
						sameCount++;
					}
				}
			}
			return new int[] {
				getRank(zeroCount + sameCount),
				getRank(sameCount)
			};
		}

		private int getRank(int correctCount) {
			int rank;
			switch (correctCount) {
				case 6 -> rank = 1;
				case 5 -> rank = 2;
				case 4 -> rank = 3;
				case 3 -> rank = 4;
				case 2 -> rank = 5;
				default -> rank = 6;
			}
			return rank;
		}
	}
}
