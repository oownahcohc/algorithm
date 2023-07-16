package org.example.boj;

import java.util.Scanner;

public class 잃어버린_괄호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(solution(expression));
    }
    
    private static int solution(String expression) {
        int answer = 0;

        String[] minus = expression.split("-");
        int[] sum = new int[minus.length];
        for (int i = 0; i < minus.length; i++) {
            String[] plus = minus[i].split("\\+");
            for (String p : plus) {
                sum[i] += Integer.parseInt(p);
            }
            if (i == 0) {
                answer += sum[i];
            } else {
                answer -= sum[i];
            }
        }

        return answer;
    }
}
