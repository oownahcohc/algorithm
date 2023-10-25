package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 덧칠하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(8, 4, new int[]{2, 3, 6});
        System.out.println(result);
    }

    static class Solution {
        public int solution(int n, int m, int[] section) {
            List<Integer> notPaintedSection = new ArrayList<>();
            for (int value : section) {
                notPaintedSection.add(value);
            }

            int result = 0;
            int min = notPaintedSection.get(0);
            notPaintedSection.removeIf(sec -> sec <= min + (m - 1));
            result++;

            if (!notPaintedSection.isEmpty()) {
                int max = notPaintedSection.get(notPaintedSection.size() - 1);
                if (min + (m - 1) < max) {
                    notPaintedSection.removeIf(sec -> sec >= max - (m - 1));
                    result++;
                }
            }

            while (!notPaintedSection.isEmpty()) {
                int maxRemain = notPaintedSection.get(notPaintedSection.size() - 1);
                notPaintedSection.removeIf(sec -> sec >= maxRemain - (m - 1));
                result++;
            }

            return result;
        }
    }
}
