package org.example.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 대충_만든_자판 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(
                new String[]{"ABACD", "BCEFD"},
                new String[]{"ABCD", "AABB"}
        );
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            Map<String, Integer> countMappedByKey = new HashMap<>();
            for (String key : keymap) {
                String[] changeOrder = key.split("");
                for (int i = 0; i < changeOrder.length; i++) {
                    Integer count = countMappedByKey.get(changeOrder[i]);
                    if (count == null) {
                        countMappedByKey.put(changeOrder[i], i + 1);
                    } else {
                        if (count > i + 1) {
                            countMappedByKey.replace(changeOrder[i], i + 1);
                        }
                    }
                }
            }

            int[] answer = new int[targets.length];
            for (int i = 0; i < targets.length; i++) {
                String[] inputKey = targets[i].split("");
                int sum = 0;
                for (String key : inputKey) {
                    Integer count = countMappedByKey.get(key);
                    if (count == null) {
                        sum = -1;
                        break;
                    }
                    sum += count;
                }
                answer[i] = sum;
            }

            return answer;
        }
    }
}
