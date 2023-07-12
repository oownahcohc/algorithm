package org.example.boj;

import java.util.*;

public class DFS_BFS {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력값 받아서 초기화
        int node = scanner.nextInt();
        int edge = scanner.nextInt();
        int start = scanner.nextInt();
        lists = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            lists[n].add(e);
            lists[e].add(n);
        }
        // 작은 노드 먼저 탐색을 위한 인접 리스트 정렬
        for (int i = 1; i <= node; i++) {
            Collections.sort(lists[i]);
        }

        visited = new boolean[node + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[node + 1];
        BFS(start);
    }

    private static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int node : lists[start]) {
            if (!visited[node]) {
                DFS(node);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");
            for (int node : lists[poll]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
