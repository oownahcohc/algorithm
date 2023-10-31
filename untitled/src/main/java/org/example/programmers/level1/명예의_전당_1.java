package org.example.programmers.level1;

import java.util.*;

public class 명예의_전당_1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution2(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        
        public int[] solution(int k, int[] score) {
            List<Integer> hallOfFame = new ArrayList<>(k);
            int[] answer = new int[score.length];

            if (k > score.length) {
                for (int i = 0; i < score.length; i++) {
                    hallOfFame.add(score[i]);
                    Collections.sort(hallOfFame);
                    answer[i] = hallOfFame.get(0);
                }
            } else {
                for (int i = 0; i < k; i++) {
                    hallOfFame.add(score[i]);
                    Collections.sort(hallOfFame);
                    answer[i] = hallOfFame.get(0);
                }

                for (int i = k; i < score.length; i++) {
                    if (hallOfFame.get(0) < score[i]) {
                        hallOfFame.set(0, score[i]);
                        Collections.sort(hallOfFame);
                        answer[i] = hallOfFame.get(0);
                    }
                    answer[i] = hallOfFame.get(0);
                }
            }

            return answer;
        }

        public int[] solution2(int k, int[] score) {
            int[] answer = new int[score.length];

            Queue<Integer> hallOfFame = new PriorityQueue<>(k);

            for (int i = 0; i < score.length; i++) {
                hallOfFame.offer(score[i]);
                if (hallOfFame.size() > k) {
                    hallOfFame.poll();
                }
                answer[i] = hallOfFame.element();
            }

            return answer;
        }
    }
}
