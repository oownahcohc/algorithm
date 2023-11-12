package org.example.programmers.level1;

public class 최소직사각형 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[][] {
			{14, 4},
			{19, 6},
			{6, 16},
			{18, 7},
			{7, 11}
		});
		System.out.println(result);
	}

	static class Solution {
		public int solution(int[][] sizes) {
			int w = Math.max(sizes[0][0], sizes[0][1]);
			int h = Math.min(sizes[0][0], sizes[0][1]);
			for (int i = 1; i < sizes.length; i++) {
				w = Math.max(Math.max(sizes[i][0], sizes[i][1]), w);
				h = Math.max(Math.min(sizes[i][0], sizes[i][1]), h);
			}
			return w * h;
		}
	}
}
