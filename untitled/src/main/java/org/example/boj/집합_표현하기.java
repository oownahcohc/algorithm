package org.example.boj;

import java.util.Scanner;

public class 집합_표현하기 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int flag = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (flag == 0) {
                union(a, b);
            } else {
                int p = find(a);
                int c = find(b);
                if (p == c) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        int p = find(a);
        int c = find(b);
        if (p != c) {
            parent[c] = p;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }
}
