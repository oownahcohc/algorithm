package org.example.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };
        Solution solution = new Solution();
        int[] result = solution.solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            Map<String, Integer> nameAndScore = new HashMap<>();
            for (int i = 0; i < name.length; i++) {
                nameAndScore.put(name[i], yearning[i]);
            }

            int[] answer = new int[photo.length];
            for (int i = 0; i < photo.length; i++) {
                int sum = 0;
                for (String n : photo[i]) {
                    Integer score = nameAndScore.getOrDefault(n, 0);
                    sum += score;
                }
                answer[i] = sum;
            }

            return answer;
        }
    }
}
