package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 숫자짝궁 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution2("100", "203045");
		System.out.println(result);
	}

	static class Solution {

		public String solution(String X, String Y) {
			Map<Character, Integer> xCountOfChar = new HashMap<>();
			Map<Character, Integer> yCountOfChar = new HashMap<>();
			for (int i = 0; i < X.length(); i++) {
				char x = X.charAt(i);
				if (xCountOfChar.get(x) != null) {
					xCountOfChar.compute(x, (character, integer) -> xCountOfChar.get(character) + 1);
					continue;
				}
				xCountOfChar.put(x, 1);
			}
			for (int i = 0; i < Y.length(); i++) {
				char x = Y.charAt(i);
				if (yCountOfChar.get(x) != null) {
					yCountOfChar.compute(x, (character, integer) -> yCountOfChar.get(character) + 1);
					continue;
				}
				yCountOfChar.put(x, 1);
			}

			List<Character> common = new ArrayList<>();
			for (Character ychar : yCountOfChar.keySet()) {
				if (xCountOfChar.containsKey(ychar)) {
					int min = Math.min(xCountOfChar.get(ychar), yCountOfChar.get(ychar));
					for (int j = 0; j < min; j++) {
						common.add(ychar);
					}
				}
			}
			if (common.isEmpty()) {
				return "-1";
			}
			if (common.stream().allMatch(character -> character.equals('0'))) {
				return "0";
			}

			Collections.sort(common);

			StringBuilder answer = new StringBuilder();
			for (int i = common.size()-1; i >= 0; i--) {
				answer.append(common.get(i));
			}

			return answer.toString();
		}

		public String solution2(String X, String Y) {
			int[] x = new int[10];
			int[] y = new int[10];

			for (int i = 0; i < X.length(); i++) {
				x[X.charAt(i) - '0'] += 1;
			}
			for (int i = 0; i < Y.length(); i++) {
				y[Y.charAt(i) - '0'] += 1;
			}

			StringBuilder answer = new StringBuilder();
			for (int i = x.length - 1; i >= 0 ; i--) {
				answer.append(
					String.valueOf(i)
						.repeat(Math.min(x[i], y[i]))
				);
			}

			String result = answer.toString();
			if (result.isBlank()) {
				return "-1";
			} else if (result.startsWith("0")) {
				return "0";
			} else {
				return result;
			}
		}
	}
}
