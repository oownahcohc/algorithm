package org.example.programmers.level1;

import java.util.Arrays;

public class 삼총사 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {-3, -2, -1, 0, 1, 2, 3});
		System.out.println(result);
	}

	static class Solution {
		public int solution(int[] number) {
			Arrays.sort(number);
			int answer = 0;
			for (int pivotIndex = 0; pivotIndex <= number.length - 2; pivotIndex++) {
				int pivot = number[pivotIndex];
				for (int firstPointerIndex = number.length - 1; firstPointerIndex >= pivotIndex + 2; firstPointerIndex--) {
					int secondPointerIndex = firstPointerIndex - 1;
					while (secondPointerIndex != pivotIndex) {
						if (number[firstPointerIndex] + number[secondPointerIndex] == Math.abs(pivot)) {
							answer++;
						}
						secondPointerIndex--;
					}
				}
			}
			return answer;
		}
	}
}
