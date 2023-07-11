package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {
    static ArrayList<Integer>[] ADJACENCY;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ADJACENCY = new ArrayList[node + 1];
        VISITED = new boolean[node + 1];
        for (int i = 1; i <= node+1; i++) {
            ADJACENCY[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ADJACENCY[u].add(v);
            ADJACENCY[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= node+1; i++) {
            if (!VISITED[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v) {
        if (VISITED[v]) {
            return;
        }
        VISITED[v] = true;
        for (int i : ADJACENCY[v]) {
            DFS(i);
        }
    }
}
