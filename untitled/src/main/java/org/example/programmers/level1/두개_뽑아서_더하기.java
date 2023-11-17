package org.example.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두개_뽑아서_더하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(new int[] {5,0,2,7});
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(int[] numbers) {
			Set<Integer> set = new HashSet<>();
			for (int start = 0; start < numbers.length; start++) {
				for (int end = numbers.length - 1; end > start; end--) {
					set.add(numbers[start] + numbers[end]);
				}
			}
			return set.stream()
				.mapToInt(value -> value)
				.sorted()
				.toArray();
		}
	}
}
