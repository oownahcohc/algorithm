package org.example.programmers.level1;

import java.util.Arrays;
import java.util.Stack;

public class 과일장수 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(4, 3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
		System.out.println(result);
	}

	static class Solution {
		public int solution(int k, int m, int[] score) {
			Arrays.sort(score);
			Stack<Integer> box = new Stack<>();
			for (int i : score) {
				box.add(i);
			}

			int answer = 0;
			int boxCount = score.length / m;
			for (int i = 0; i < boxCount; i++) {
				int price = 0;
				for (int j = 0; j < m; j++) {
					price = box.pop();
				}
				answer += price * m;
			}

			return answer;
		}
	}
}
