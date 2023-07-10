package org.example.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class 친구관계 {
    static ArrayList<Integer> [] friendList;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 초기화
        int people = scanner.nextInt();  // 사람 수 (노드)
        int relation = scanner.nextInt(); // 관계 수 (에지)
        friendList = new ArrayList[people];
        visited = new boolean[people];
        arrive = false;
        for (int i = 0; i < people; i++) {
            friendList[i] = new ArrayList<>();
        }
        for (int i = 0; i < relation; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            friendList[a].add(b);
            friendList[b].add(a);
        }

        // 모든 주어진 사람들에 대해 깊이 우선 탐색 진행
        int result = 0;
        for (int i = 0; i < people; i++) {
            DFS(i, 1);
            if (arrive) {
                result = 1;
                break;
            }
        }

        System.out.println(result);
    }

    /**
     * 노드 별로 수행할 DFS 함수
     * @param currentPerson 탐색할 노드
     * @param depth 하나의 노드에서 탐색한 깊이
     */
    private static void DFS(int currentPerson, int depth) {
        if (depth == 5) {
            arrive = true;
            return;
        }
        visited[currentPerson] = true;
        for (int friend : friendList[currentPerson]) {
            if (!visited[friend]) {
                DFS(friend, depth + 1);
            }
        }
        visited[currentPerson] = false;
    }
}
