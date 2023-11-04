package org.example.programmers.level1;

public class 햄버거_만들기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1});
		System.out.println(result);
	}

	static class Solution {

		private static final String BUGGER = "1231";

		public int solution(int[] ingredient) {
			int answer = 0;
			StringBuilder ingredientOrder = new StringBuilder();
			for (int i : ingredient) {
				ingredientOrder.append(i);
				if (ingredientOrder.length() > 3
					&& i == 1
					&& ingredientOrder.substring(ingredientOrder.length() - 4).equals(BUGGER)) {
					answer++;
					ingredientOrder.delete(ingredientOrder.length()-4, ingredientOrder.length());
				}
			}

			return answer;
		}
	}
}
