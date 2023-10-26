package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 덧칠하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.thirdSolution(4, 1, new int[]{1, 2, 3, 4});
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

        public int secondSolution(int n, int m, int[] section) {
            List<Boolean> wall = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                boolean isPainted = true;
                for (int sec : section) {
                    if (i == sec) {
                        isPainted = false;
                        break;
                    }
                }
                wall.add(i, isPainted);
            }

            int result = 0;
            while (wall.contains(false)) {
                for (int sec : section) {
                    if (wall.get(sec).equals(false)) {
                        for (int i = sec; i < sec + m && i <= n; i++) {
                            wall.set(i, true);
                        }
                        result++;
                    }
                }
            }

            return result;
        }

        public int thirdSolution(int n, int m, int[] section) {
            int answer = 0;

            int start = section[0];
            answer++;

            for (int item : section) {
                if (start + m > item) {
                    continue;
                }

                start = item;
                answer++;
            }

            return answer;
        }
    }
}
