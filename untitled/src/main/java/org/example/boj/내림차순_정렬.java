package org.example.boj;

import java.util.Scanner;

/**
 * 선택 정렬
 */
public class 내림차순_정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        int[] array = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            array[i] = Integer.parseInt(string.substring(i, i+1));
        }

        for (int i = 0; i < string.length(); i++) {
            int largest = i;
            for (int j = i+1; j < string.length(); j++) {
                if (array[j] > array[largest]) {
                    largest = j;
                }
            }
            if (array[i] < array[largest]) {
                int temp = array[largest];
                array[largest] = array[i];
                array[i] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
