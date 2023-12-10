package org.example.boj.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class 수를_묶어서_최댓값_만들기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {-1, -8, 2, 1, 3, 6, -5, 0, 1});
		System.out.println(result);
	}

	static class Solution {

		public int solution(int[] sequence) {
			PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> negativePq = new PriorityQueue<>();
			int oneCount = 0;
			int zeroCount = 0;
			for (int seq : sequence) {
				if (seq > 1) {
					positivePq.add(seq);
				} else if (seq < 0){
					negativePq.add(seq);
				} else if (seq == 1) {
					oneCount++;
				} else {
					zeroCount++;
				}
			}

			int answer = 0;
			while (positivePq.size() > 1) {
				int mul = positivePq.remove() * positivePq.remove();
				answer += mul;
			}
			if (!positivePq.isEmpty()) {
				answer += positivePq.remove();
			}

			answer += oneCount;

			while (negativePq.size() > 1) {
				int mul = negativePq.remove() * negativePq.remove();
				answer += mul;
			}

			if (!negativePq.isEmpty() && zeroCount == 0) {
				answer += negativePq.remove();
			}

			return answer;
		}
	}
}
