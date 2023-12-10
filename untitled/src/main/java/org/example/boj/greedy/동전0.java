package org.example.boj.greedy;

import java.util.Scanner;

public class 동전0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coinCount = scanner.nextInt();
        int goal = scanner.nextInt();
        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = scanner.nextInt();
        }

        int result = solution(goal, coins);
        System.out.println(result);
    }

    private static int solution(int goalAmount, int[] coins) {
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (goalAmount >= coins[i]) {
                count += goalAmount / coins[i];
                goalAmount = goalAmount % coins[i];
            }
        }

        return count;
    }
}
