package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A[0] 부터 A[i] 까지의 합
 * S[i] = A[0] + A[1] + ... + A[i-1] + A[i];
 * S[i] = S[i-1] + A[i];
 *
 * i 에서 j 까지의 합
 * S[j] - S[i-1]
 */
public class 구간_합_구하기1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int dataCount = Integer.parseInt(st.nextToken());
        int questionSize = Integer.parseInt(st.nextToken());
        int[] sum = new int[dataCount + 1];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= dataCount; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int[] result = new int[questionSize];
        for (int q = 0; q < questionSize; q++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            result[q] = sum[j] - sum[i - 1];
        }

        for (int r : result) {
            System.out.println(r);
        }
    }
}
