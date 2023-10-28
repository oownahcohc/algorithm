package org.example.programmers.level1;

import java.util.stream.IntStream;

public class 크기가_작은_부분문자열 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("3141592", "271");
        System.out.println(result);
    }

    static class Solution {

        public int solution(String t, String p) {
            return (int) IntStream.rangeClosed(0, t.length() - p.length())
                    .mapToObj(i -> t.substring(i, i + p.length()))
                    .filter(s -> Double.parseDouble(s) <= Double.parseDouble(p))
                    .count();
        }
    }
}
