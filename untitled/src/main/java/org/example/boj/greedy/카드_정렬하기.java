package org.example.boj.greedy;

import java.util.PriorityQueue;

public class 카드_정렬하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(3, new int[] {10, 20, 40});
		System.out.println(result);
	}

	static class Solution {

		public int solution(int bundle, int[] cards) {
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
			for (int card : cards) {
				priorityQueue.add(card);
			}

			int answer = 0;
			while (priorityQueue.size() != 1) {
				int sum = priorityQueue.remove() + priorityQueue.remove();
				answer += sum;
				priorityQueue.add(sum);
			}

			return answer;
		}
	}
}
