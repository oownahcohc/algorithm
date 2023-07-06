package org.example.boj;

import java.util.Scanner;

/**
 * 투 포인터
 * sum > N : sum
 */
public class 연속된_자연수합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 1;
        int sum = 1;
        int startPointer = 1;
        int endPointer = 1;

        while (endPointer != N) {
            if (sum < N) {
                endPointer++;
                sum = sum + endPointer;
            } else if (sum == N) {
                count++;
                endPointer++;
                sum = sum + endPointer;
            } else if (sum > N) {
                sum = sum - startPointer;
                startPointer++;
            }
        }

        System.out.println(count);
    }
}
