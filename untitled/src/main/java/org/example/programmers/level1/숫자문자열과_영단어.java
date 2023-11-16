package org.example.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과_영단어 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution("one4seveneight");
		System.out.println(result);
	}

	static class Solution {
		public int solution(String s) {
			Map<String, String> numberMappedByWord = new HashMap<>();
			numberMappedByWord.put("zero", "0");
			numberMappedByWord.put("one", "1");
			numberMappedByWord.put("two", "2");
			numberMappedByWord.put("three", "3");
			numberMappedByWord.put("four", "4");
			numberMappedByWord.put("five", "5");
			numberMappedByWord.put("six", "6");
			numberMappedByWord.put("seven", "7");
			numberMappedByWord.put("eight", "8");
			numberMappedByWord.put("nine", "9");

			for (Map.Entry<String, String> entry : numberMappedByWord.entrySet()) {
				if (s.contains(entry.getKey())) {
					s = s.replace(entry.getKey(), entry.getValue());
				}
			}

			return Integer.parseInt(s);
		}

		public int solution2(String s) {
			String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
			for (int i = 0;  i < words.length; i++) {
				if (s.contains(words[i])) {
					s = s.replaceAll(words[i], String.valueOf(i));
				}
			}
			return Integer.parseInt(s);
		}
	}
}
