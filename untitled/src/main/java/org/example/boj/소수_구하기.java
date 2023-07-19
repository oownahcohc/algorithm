package org.example.boj;

import java.util.Scanner;

/**
 * 에라토스테네스의 체
 */
public class 소수_구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] result = solution(end);
        for (int i = start; i <= end; i++) {
            if (result[i] != 0) {
                System.out.println(result[i]);
            }
        }
    }

    private static int[] solution(int end) {
        int[] input = new int[end+1];
        for (int i = 2; i <= end; i++) {
            input[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (input[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= end; j += i) {
                input[j] = 0;
            }
        }

        return input;
    }
}
