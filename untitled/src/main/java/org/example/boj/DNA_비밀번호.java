package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
    static int[] current = new int[4];
    static int[] lowest = new int[4];
    static int satisfy = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(bf.readLine());

        final int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        final int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        final char[] DNA = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        for (int i =0; i < 4; i++) {
            lowest[i] = Integer.parseInt(st.nextToken());
            if (lowest[i] == 0) {
                satisfy++;
            }
        }

        current = new int[4];
        // 최초 DNA 에 대한 처리
        for (int i = 0; i < P; i++) {
            addCurrent(DNA[i]);
        }
        checkSatisfy();

        // 슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            int j = i - P;
            addCurrent(DNA[i]);
            removeCurrent(DNA[j]);
            checkSatisfy();
        }

        System.out.println(result);
    }

    private static void addCurrent(char c) {
        switch (c) {
            case 'A':
                current[0]++;
                if (current[0] == lowest[0]) {
                    satisfy++;
                }
                break;
            case 'C':
                current[1]++;
                if (current[1] == lowest[1]) {
                    satisfy++;
                }
                break;
            case 'G':
                current[2]++;
                if (current[2] == lowest[2]) {
                    satisfy++;
                }
                break;
            case 'T':
                current[3]++;
                if (current[3] == lowest[3]) {
                    satisfy++;
                }
                break;
        }
    }

    private static void removeCurrent(char c) {
        switch (c) {
            case 'A':
                if (current[0] == lowest[0]) {
                    satisfy--;
                }
                current[0]--;
                break;
            case 'C':
                if (current[1] == lowest[1]) {
                    satisfy--;
                }
                current[1]--;
                break;
            case 'G':
                if (current[2] == lowest[2]) {
                    satisfy--;
                }
                current[1]--;

                break;
            case 'T':
                if (current[3] == lowest[3]) {
                    satisfy--;
                }
                current[3]--;
                break;
        }
    }

    private static void checkSatisfy() {
        if (satisfy == 4) {
            result++;
        }
    }
}
