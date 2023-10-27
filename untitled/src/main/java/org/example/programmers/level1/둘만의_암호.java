package org.example.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 둘만의_암호 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("z", "abcdefghij", 20);
        System.out.println(result);
    }

    static class Solution {
        public String solution(String s, String skip, int index) {
            List<String> alphabet = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                alphabet.add(String.valueOf((char) (97 + i)));
            }
            List<String> skipWords = Arrays.stream(skip.split("")).collect(Collectors.toList());
            alphabet.removeAll(skipWords);

            Map<String, Integer> alphabetWithIndex = new HashMap<>();
            Map<Integer, String> indexWithAlphabet = new HashMap<>();
            for (String alp : alphabet) {
                alphabetWithIndex.put(alp, alphabet.indexOf(alp));
                indexWithAlphabet.put(alphabet.indexOf(alp), alp);
            }

            StringBuilder result = new StringBuilder();
            String[] input = s.split("");
            for (String ip : input) {
                int target = alphabetWithIndex.get(ip) + index;
                String output = indexWithAlphabet.getOrDefault(target, indexWithAlphabet.get(target % alphabet.size()));
                result.append(output);
            }

            return result.toString();
        }
    }
}
