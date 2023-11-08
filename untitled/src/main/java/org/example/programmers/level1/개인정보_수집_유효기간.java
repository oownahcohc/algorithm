package org.example.programmers.level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		Integer[] result = solution.solution(
			"2021.05.15",
			new String[] {"A 1", "B 18"},
			new String[] {"2000.12.01 A", "2019.10.15 B"}
		);
		System.out.println(Arrays.toString(result));
	}

	static class Solution {

		private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy.MM.dd");

		public Integer[] solution(String today, String[] terms, String[] privacies) {
			Map<String, Integer> termWithExpires = new HashMap<>();
			for (String term : terms) {
				String[] split = term.split(" ");
				termWithExpires.put(split[0], Integer.valueOf(split[1]));
			}

			List<Integer> destroyed = new ArrayList<>();
			LocalDate todayDate = LocalDate.parse(today, DTF);
			for (int i = 0; i < privacies.length; i++) {
				String[] privacy = privacies[i].split(" ");
				LocalDate collectDate = LocalDate.parse(privacy[0], DTF);
				Integer expirationPeriod = termWithExpires.get(privacy[1]);
				LocalDate expiredDate = calculateExpirationDate(collectDate, expirationPeriod);
				if (expiredDate.isBefore(todayDate) || expiredDate.isEqual(todayDate)) {
					destroyed.add(i + 1);
				}
			}

			return destroyed.toArray(new Integer[0]);
		}

		private LocalDate calculateExpirationDate(LocalDate collectDate, int expirationPeriod) {
			int year = collectDate.getYear() + expirationPeriod / 12;
			int month = collectDate.getMonthValue() + expirationPeriod % 12;
			if (month > 12) {
				year++;
				month -= 12;
			}
			return collectDate.withYear(year).withMonth(month);
		}
	}
}
