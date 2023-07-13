package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

public class 수_찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 초기화
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = scanner.nextInt();
        }

        solution(array, targets);
    }

    private static void solution(int[] array, int[] targets) {
        Arrays.sort(array);

        for (int target : targets) {
            boolean isFind = false;

            int start = 0;
            int end = array.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int found = array[mid];

                if (found > target) {
                    end = mid - 1;
                } else if (found < target) {
                    start = mid + 1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
