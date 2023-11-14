package org.example.programmers.level1;

public class 부족한_금액_계산하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		long result = solution.solution(2500, 500, 2500);
		System.out.println(result);
	}

	static class Solution {
		public long solution(long price, long money, long count) {
			for (long c = 1; c <= count; c++) {
				money -= price * c;
			}
			if (money >= 0) {
				return 0;
			}
			return Math.abs(money);
		}
	}
}
