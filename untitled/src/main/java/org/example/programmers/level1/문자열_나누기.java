package org.example.programmers.level1;

import java.util.Deque;
import java.util.LinkedList;

public class 문자열_나누기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("abaabab");
        System.out.println(result);
    }

    static class Solution {

        public int solution(String s) {
            Deque<Character> input = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                input.offer(s.charAt(i));
            }

            char pivot = s.charAt(0);
            int pivotCount = 0;
            int anotherCount = 0;
            int answer = 0;
            while (!input.isEmpty()) {
                Character poll = input.poll();
                if (poll == pivot) {
                    pivotCount++;
                } else {
                    anotherCount++;
                }
                if (pivotCount == anotherCount) {
                    answer++;
                    pivotCount = 0;
                    anotherCount = 0;
                    if (!input.isEmpty()) {
                        pivot = input.peek();
                    }
                }
                if (input.isEmpty() && pivotCount != anotherCount) {
                    answer++;
                }
            }

            return answer;
        }
    }
}

