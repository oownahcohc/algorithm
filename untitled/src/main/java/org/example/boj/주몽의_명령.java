package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의_명령 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inputStreamReader);

        int N = Integer.parseInt(bf.readLine()); // 재료 개수
        int M = Integer.parseInt(bf.readLine()); // M 이 되어야 갑옷 완성
        int[] meterials = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            meterials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meterials);

        int count = 0;
        int startPointerIndex = 0;
        int endPointerIndex = N - 1;
        while (startPointerIndex < endPointerIndex) {
            if (meterials[startPointerIndex] + meterials[endPointerIndex] == M) {
                count++;
                endPointerIndex--;
                startPointerIndex++;
            } else if (meterials[startPointerIndex] + meterials[endPointerIndex] < M) {
                startPointerIndex++;
            } else if (meterials[startPointerIndex] + meterials[endPointerIndex] > M) {
                endPointerIndex--;
            }
        }

        System.out.println(count);
    }
}
