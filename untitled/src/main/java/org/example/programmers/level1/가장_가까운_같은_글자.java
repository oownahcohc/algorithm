package org.example.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution3("banana");
        System.out.println(Arrays.toString(result));
    }

    static class Solution {

        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            answer[0] = -1;
            
            for (int i = 1; i < s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        answer[i] = i - j;
                        break;
                    }
                    answer[i] = -1;
                }
            }

            return answer;
        }

        public int[] solution2(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int[] answer = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                int current = i;
                Integer index = map.computeIfPresent(s.charAt(current), (c, idx) -> {
                    answer[current] = current - idx;
                    return current;
                });
                if (index == null) {
                    map.put(s.charAt(i), i);
                    answer[i] = -1;
                }
            }

            return answer;
        }

        public int[] solution3(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int[] answer = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (map.containsKey(current)) {
                    answer[i] = i - map.get(current);
                    map.replace(current, i);
                } else {
                    map.put(current, i);
                    answer[i] = -1;
                }
            }

            return answer;
        }
    }
}
