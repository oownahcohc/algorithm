package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 없는숫자_더하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution2(new int[] {5, 8, 4, 0, 6, 7, 9});
		System.out.println(result);
	}

	static class Solution {

		private static final int TOTAL_SUM = 45;

		public int solution2(int[] numbers) {
			return TOTAL_SUM - Arrays.stream(numbers).sum();
		}

		public int solution(int[] numbers) {
			List<Integer> numList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
			List<Integer> nums = Arrays.stream(numbers)
				.boxed()
				.collect(Collectors.toList());
			numList.removeAll(nums);
			return numList.stream()
				.mapToInt(value -> value)
				.sum();
		}
	}
}
