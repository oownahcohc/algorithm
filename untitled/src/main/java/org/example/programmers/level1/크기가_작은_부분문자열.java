package org.example.programmers.level1;

public class 크기가_작은_부분문자열 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("3141592", "271");
        System.out.println(result);
    }

    static class Solution {

        public int solution(String t, String p) {
            int answer = 0;
            for (int i = 0; i <= t.length() - p.length(); i++) {
                String substring = t.substring(i, i + p.length());
                if (Double.parseDouble(substring) <= Double.parseDouble(p)) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
