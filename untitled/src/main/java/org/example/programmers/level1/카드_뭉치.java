package org.example.programmers.level1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class 카드_뭉치 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution2(
                new String[] {"i", "drink", "water"},
                new String[] {"want", "to"},
                new String[] {"i", "want", "to", "drink", "water"}
        );
        System.out.println(result);
    }

    static class Solution {

        public String solution(String[] cards1, String[] cards2, String[] goal) {
            List<String> cardList1 = Arrays.stream(cards1).collect(Collectors.toList());
            List<String> cardList2 = Arrays.stream(cards2).collect(Collectors.toList());
            List<String> goalList = Arrays.stream(goal).collect(Collectors.toList());

            String answer = "Yes";
            while (!goalList.isEmpty()) {
                String g = goalList.get(0);
                String s1 = null;
                String s2 = null;
                if (!cardList1.isEmpty()) {
                    s1 = cardList1.get(0);
                }
                if (!cardList2.isEmpty()) {
                    s2 = cardList2.get(0);
                }

                if (g.equals(s1)) {
                    goalList.remove(g);
                    cardList1.remove(s1);
                } else if (g.equals(s2)) {
                    goalList.remove(g);
                    cardList2.remove(s2);
                } else {
                    answer = "No";
                    break;
                }
            }
            return answer;
        }

        public String solution2(String[] cards1, String[] cards2, String[] goal) {
            Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(cards1));
            Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(cards2));
            Deque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

            String answer = "Yes";
            while (!goalDeque.isEmpty()) {
                String target = goalDeque.pop();
                if (target.equals(deque1.peek())) {
                    deque1.pop();
                } else if (target.equals(deque2.peek())) {
                    deque2.pop();
                } else {
                    answer = "NO";
                }
            }
            return answer;
        }
    }
}
