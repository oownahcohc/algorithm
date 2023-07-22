package org.example.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 위상 정렬
 */
public class 줄세우기 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        // 진입차수 배열 설정
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int front = scanner.nextInt();
            int back = scanner.nextInt();
            lists[front].add(back);
            inDegree[back]++;
        }

        // 위상 정렬 - 진입 차수가 0 인 놈만 큐에 집어넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : lists[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
