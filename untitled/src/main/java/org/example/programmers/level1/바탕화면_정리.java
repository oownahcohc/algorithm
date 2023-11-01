package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 바탕화면_정리 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[] {
                "..........",
                ".....#....",
                "......##..",
                "...##.....",
                "....#....."
        });
        System.out.println(Arrays.toString(result));
    }

    static class Solution {

        public int[] solution(String[] wallpaper) {
            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            for (int y = 0; y < wallpaper.length; y++) {
                String[] line = wallpaper[y].split("");
                for (int x = 0; x < line.length; x++) {
                    if (line[x].equals("#")) {
                        xList.add(x);
                        yList.add(y);
                    }
                }
            }

            Collections.sort(xList);
            Collections.sort(yList);

            return new int[] {
                    yList.get(0),
                    xList.get(0),
                    yList.get(yList.size()-1) + 1,
                    xList.get(xList.size()-1) + 1
            };
        }
    }
}
